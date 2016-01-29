package com.kting.recodingdemo.view;

import java.io.File;
import java.util.UUID;

import android.media.MediaRecorder;
import android.util.Log;

public class AudioManager {
	private MediaRecorder mMediaRecorder;
	private String mDir;
	private String mCurrentFilePath;

	/** ���� */
	private static AudioManager mInstance;

	public boolean isPrepared;

	private AudioManager(String dir) {
		mDir = dir;
	}

	/** �ص�׼����� */
	public interface AudioStateListener {
		void wellPrepared();
	}

	public AudioStateListener mListener;

	public void setOnAudioStateListener(AudioStateListener listener) {
		mListener = listener;
	}

	public static AudioManager getInstance(String dir) {
		if (mInstance == null) {
			synchronized (AudioManager.class) {
				if (mInstance == null)
					mInstance = new AudioManager(dir);
			}
		}
		return mInstance;
	}

	/* ׼�� */
	public void prepareAudio() {
		try {
			isPrepared = false;
			File dir = new File(mDir);
			if (!dir.exists())
				dir.mkdirs();
			String fileName = generateFileName();
			File file = new File(dir, fileName);
			mCurrentFilePath = file.getAbsolutePath();
			mMediaRecorder = new MediaRecorder();
			// ��������ļ�
			mMediaRecorder.setOutputFile(file.getAbsolutePath());
			// ������ƵԴΪ��˷�
			mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			// ������Ƶ�ĸ�ʽ
			mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
			// ������Ƶ�ı���
			mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			mMediaRecorder.prepare();
			mMediaRecorder.start();
			// ׼������
			isPrepared = true;
			if (mListener != null) {
				mListener.wellPrepared();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������ļ�������
	 * 
	 * @return ��׺Ϊ.amr��β���ļ���
	 */
	private String generateFileName() {
		return UUID.randomUUID().toString() + ".amr";
	}

	/* ��������ȼ� */
	public int getVoiceLevel(int maxLevel) {
		if (isPrepared) {
			//Log.i("zy", "mMediaRecorder.getMaxAmplitude()-----------------"+mMediaRecorder.getMaxAmplitude());
			//Log.i("zy", "mMediaRecorder.getMaxAmplitude()/32768-----------------"+mMediaRecorder.getMaxAmplitude()/32768);
			//Log.i("zy", "maxLevel*mMediaRecorder.getMaxAmplitude()/32768-----------------"+(maxLevel*mMediaRecorder.getMaxAmplitude()/327688+1));
			try {
				
				return maxLevel*mMediaRecorder.getMaxAmplitude()/32768+1;
			} catch (Exception e) {
			}
		}
		
		return 1;
	}
	/*�ͷ���Դ*/
	public void release() {
		mMediaRecorder.stop();
		mMediaRecorder.release();
		mMediaRecorder = null;
	}

	public void cancel() {
		release();
		if (mCurrentFilePath != null) {
			File file = new File(mCurrentFilePath);
			file.delete();
			mCurrentFilePath = null;
		}

	}

	public String getCurrentFilePath() {
		return mCurrentFilePath;
	}
}
