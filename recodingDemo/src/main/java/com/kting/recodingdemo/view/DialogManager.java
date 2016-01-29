package com.kting.recodingdemo.view;

import com.kting.recodingdemo.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogManager {
	private Dialog mDialog;
	private ImageView mIcon;
	private ImageView mVoice;
	private TextView mLable;
	private Context mContext;

	public DialogManager(Context context) {
		mContext = context;
	}

	/** ��ʾ¼���ĶԻ��� */
	public void showRecordingDialog() {
		mDialog = new Dialog(mContext, R.style.ThemeAudioDialog);
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = inflater.inflate(R.layout.dialog_recording, null);
		mDialog.setContentView(view);
		mIcon = (ImageView) mDialog.findViewById(R.id.id_recorder_dialog_icon);
		mVoice = (ImageView) mDialog
				.findViewById(R.id.id_recorder_dialog_voice);
		mLable = (TextView) mDialog.findViewById(R.id.id_recorder_dialog_label);
		mDialog.show();
	}

	/** ���ڲ��� */
	public void recording() {
		if (mDialog != null && mDialog.isShowing()) {
			mIcon.setVisibility(View.VISIBLE);
			mVoice.setVisibility(View.VISIBLE);
			mLable.setVisibility(View.VISIBLE);
			mIcon.setImageResource(R.drawable.recorder);
			mLable.setText(R.string.move_up);
		}
	}

	/** ��ʾ��ֹ���͵ĶԻ��� */
	public void wantToCancel() {
		if (mDialog != null && mDialog.isShowing()) {
			mIcon.setVisibility(View.VISIBLE);
			mVoice.setVisibility(View.GONE);
			mLable.setVisibility(View.VISIBLE);
			mIcon.setImageResource(R.drawable.cancel);
			mLable.setText(R.string.move_over);
		}
	}

	/** ��ʾʱ��̫�̵ĶԻ��� */
	public void tooShort() {
		if (mDialog != null && mDialog.isShowing()) {
			mIcon.setVisibility(View.VISIBLE);
			mVoice.setVisibility(View.GONE);
			mLable.setVisibility(View.VISIBLE);
			mIcon.setImageResource(R.drawable.voice_to_short);
			mLable.setText(R.string.move_too_short);
		}
	}

	/** ���ضԻ��� */
	public void dimissDialog() {
		if (mDialog != null && mDialog.isShowing()) {
			mDialog.dismiss();
			mDialog = null;
		}
	}

	/** ͨ��Leverȥ����voice�ϵ�ͼƬ */
	public void updateVoiceLevel(int level) {
		if (mDialog != null && mDialog.isShowing()) {
			// mIcon.setVisibility(View.VISIBLE);
			// mVoice.setVisibility(View.VISIBLE);
			// mLable.setVisibility(View.VISIBLE);
			int resId = mContext.getResources().getIdentifier("v" + level,
					"drawable", mContext.getPackageName());
			mVoice.setImageResource(resId);
		}
	}
}
