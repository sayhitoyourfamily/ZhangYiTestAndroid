package com.kting.recodingdemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kting.recodingdemo.view.AudioRecorderButton;
import com.kting.recodingdemo.view.AudioRecorderButton.AudioFinishRecorderListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
	private ListView mListView;
	private ArrayAdapter<Recorder> mArrayAdapter;
	private List<Recorder> mDatas = new ArrayList<Recorder>();
	private AudioRecorderButton mAudioRecorderButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.id_listview);
		 mAudioRecorderButton = (AudioRecorderButton) findViewById(R.id.id_recorder_button);
		 mAudioRecorderButton.setAudioFinishRecorderListener(new AudioFinishRecorderListener() {
			@Override
			public void onFinish(float seconds, String filePath) {
				Recorder recorder = new Recorder(seconds, filePath);
				mDatas.add(recorder);
				mArrayAdapter.notifyDataSetChanged();
				mListView.setSelection(mDatas.size()-1);
			}
		});
		 mArrayAdapter = new RecorderAdapter(this, mDatas);
		 mListView.setAdapter(mArrayAdapter);
		 mListView.setOnItemClickListener(new OnItemClickListener() {

			private View animView;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (animView !=null){
					animView.setBackgroundResource(R.drawable.adj);
					animView = null;
				} 
				animView = view.findViewById(R.id.id_recorder_anim);
				animView.setBackgroundResource(R.drawable.anim_play);
				AnimationDrawable anim =  (AnimationDrawable) animView.getBackground();
				anim.start();
				// ������Ƶ
				MediaManager.playSound(mDatas.get(position).filePath,new MediaPlayer.OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO Auto-generated method stub
						animView.setBackgroundResource(R.drawable.adj);
					}
				});
			}
		});
	}

	class Recorder {
		float time;
		String filePath;

		public Recorder(float time, String filePath) {
			super();
			this.time = time;
			this.filePath = filePath;
		}

		public float getTime() {
			return time;
		}

		public void setTime(float time) {
			this.time = time;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
	}
	@Override
	protected void onPause() {
		super.onPause();
		MediaManager.pause();
	}
	@Override
	protected void onResume() {
		super.onResume();
		MediaManager.resume();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		MediaManager.relese();
	}
}
