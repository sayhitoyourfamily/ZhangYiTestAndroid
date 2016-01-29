package com.kting.recodingdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.kting.recodingdemo.R;
import com.kting.recodingdemo.view.AudioManager.AudioStateListener;

@SuppressLint({ "ClickableViewAccessibility", "HandlerLeak" })
public class AudioRecorderButton extends Button implements AudioStateListener {
	private static final int DISTANCE_Y_CANCEL = 50;
	/** ����button������״̬ */
	private static final int STATE_NORMAL = 1;
	private static final int STATE_RECORDING = 2;
	private static final int STATE_WANT_TO_CANCEL = 3;
	/* �Ѿ���ʼ¼��¼�� */
	private boolean isRecording = false;
	/* ����Ĭ��״̬��NORMAL */
	private int mCurState = STATE_NORMAL;
	/* ��dialog���ɵ�button�� */
	private DialogManager mDialogManager;
	/* ��ʼ��AudioManager */
	private AudioManager mAudioManager;
	/* ��ʼ��ʱ�� */
	private float mTime;
	/* �Ƿ񴥷�longClick */
	private boolean mReady;

	public AudioRecorderButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		mDialogManager = new DialogManager(getContext());
		String dir = Environment.getExternalStorageDirectory()
				+ "/kting_recorder_audios";
		mAudioManager = AudioManager.getInstance(dir);
		mAudioManager.setOnAudioStateListener(this);
		setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				mReady = true;
				mAudioManager.prepareAudio();
				return false;
			}
		});
	}
	/**¼����ɺ�Ļص�*/
	public interface AudioFinishRecorderListener{
		void onFinish(float seconds,String filePath);
	}
	AudioFinishRecorderListener mListener;
	@SuppressWarnings("unused")
	public void setAudioFinishRecorderListener(AudioFinishRecorderListener listener){
		mListener = listener;
	}
	public AudioRecorderButton(Context context) {
		this(context, null);
	}

	// ��ȡ������С��Runnable;
	private Runnable mGetVoiceLevelRunnable = new Runnable() {
		@Override
		public void run() {
			while (isRecording) {
				try {
					Thread.sleep(100);
					mTime += 0.1f;
					mHandler.sendEmptyMessage(MSG_VOICE_CHANGED);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};
	// handle��Ҫ����������¼�
	private static final int MSG_AUDIO_PREPARE = 0X110;
	private static final int MSG_VOICE_CHANGED = 0X111;
	private static final int MSG_DIALOG_DIMISS = 0X112;
	private Handler mHandler = new Handler() {
		@SuppressLint("HandlerLeak") 
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MSG_AUDIO_PREPARE:
				// ��ʾӦ��audio end prepared֮��
				mDialogManager.showRecordingDialog();
				isRecording = true;
				new Thread(mGetVoiceLevelRunnable).start();
				break;
			case MSG_VOICE_CHANGED:
				mDialogManager.updateVoiceLevel(mAudioManager.getVoiceLevel(7));
				break;
			case MSG_DIALOG_DIMISS:
				mDialogManager.dimissDialog();
				break;
			}
		};
	};

	/** �ص����� */
	@Override
	public void wellPrepared() {
		mHandler.sendEmptyMessage(MSG_AUDIO_PREPARE);
	}

	/** ��дonTouchEvent */
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();
		int x = (int) event.getX();
		int y = (int) event.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			changeState(STATE_RECORDING);
			break;
		case MotionEvent.ACTION_MOVE:
			if (isRecording) {// �Ƿ���¼��
				/* ����x,y���������ж��Ƿ���Ҫȡ�� */
				if (wantToCancel(x, y)) {
					changeState(STATE_WANT_TO_CANCEL);
				} else {
					changeState(STATE_RECORDING);
				}
			}
			break;
		case MotionEvent.ACTION_UP:
			/*
			 * ������� 1��down�Ժ�û����longclick 2��down�Ժ󴥷�longClick��û��prepaer��Ͼ��ɿ���
			 * 3��¼��ʱ��̣ܶ�û�дﵽ�����趨��ֵ 4�� 5��
			 */
			if (!mReady) {
				reset();
				return super. onTouchEvent(event);
			}
			if (!isRecording || mTime < 0.6f) {
				mDialogManager.tooShort();
				mAudioManager.cancel();
				mHandler.sendEmptyMessageDelayed(MSG_DIALOG_DIMISS, 1300);
			}else if (mCurState == STATE_RECORDING) {//����¼�ƽ���
				mDialogManager.dimissDialog();
				mAudioManager.release();
				if (mListener!=null) {
					mListener.onFinish(mTime, mAudioManager.getCurrentFilePath());
				}
			} else if (mCurState == STATE_WANT_TO_CANCEL) {
				mDialogManager.dimissDialog();
				mAudioManager.cancel();
			}
			reset();
			break;

		}
		return super.onTouchEvent(event);
	}

	/** �ָ�״̬�Լ���־λ */
	private void reset() {
		isRecording = false;
		mReady = false;
		mTime = 0;
		changeState(STATE_NORMAL);
	}

	private boolean wantToCancel(int x, int y) {
		if (x < 0 || x > getWidth()) {
			return true;
		}
		if (y < -DISTANCE_Y_CANCEL || y > getHeight() + DISTANCE_Y_CANCEL) {
			return true;
		}
		return false;

	}

	/** �ı�button�ı��� */
	private void changeState(int state) {
		if (mCurState != state) {
			mCurState = state;
			switch (state) {
			case STATE_NORMAL:
				setBackgroundResource(R.drawable.btn_recorder_nomal);
				setText(R.string.str_recorder_nomal);
				break;

			case STATE_RECORDING:
				setBackgroundResource(R.drawable.btn_recorder_recordingl);
				setText(R.string.str_recorder_recording);
				if (isRecording) {
					mDialogManager.recording();
				}
				break;

			case STATE_WANT_TO_CANCEL:
				setBackgroundResource(R.drawable.btn_recorder_recordingl);
				setText(R.string.str_recorder_want_cancel);
				mDialogManager.wantToCancel();
				break;
			}
		}
	}

}
