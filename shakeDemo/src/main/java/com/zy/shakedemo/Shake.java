package com.zy.shakedemo;

import android.app.Service;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;

public class Shake implements SensorEventListener {

	private Context mContext;

	// 定义sensor管理器
	private SensorManager mSensorManager;
	// 震动
	private Vibrator vibrator;

	private ShakeListener shakeListener;

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			String jsonString = bundle.getString("data");
			int action = msg.what;
			switch (action) {
			case 1:
				registerListener();
				break;
			case 2:
				unregisterListener();
				vibrator.vibrate(200);
				handler.sendEmptyMessageDelayed(1, 3000);
				break;
			case 3:

				break;
			case 99999:
				break;
			default:
				break;
			}

		}

	};

	public Shake(Context mContext) {
		super();
		this.mContext = mContext;
		// 获取传感器管理服务
		mSensorManager = (SensorManager) mContext
				.getSystemService(Service.SENSOR_SERVICE);
		// 震动
		vibrator = (Vibrator) mContext
				.getSystemService(Service.VIBRATOR_SERVICE);
		registerListener();
	}

	public ShakeListener getShakeListener() {
		return shakeListener;
	}

	public void setShakeListener(ShakeListener shakeListener) {
		this.shakeListener = shakeListener;
	}

	private void registerListener() {
		if (mSensorManager != null) {
			// 加速度传感器
			// 还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
			// 根据不同应用，需要的反应速率不同，具体根据实际情况设定
			mSensorManager.registerListener(this,
					mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
					SensorManager.SENSOR_DELAY_NORMAL);
		}

	}

	public void unregisterListener() {
		if (mSensorManager != null) {
			mSensorManager.unregisterListener(this);
		}

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		int sensorType = event.sensor.getType();

		float[] values = event.values;
		float x = values[0]; // x轴方向的重力加速度，向右为正
		float y = values[1]; // y轴方向的重力加速度，向前为正
		float z = values[2]; // z轴方向的重力加速度，向上为正
		// Log.i("摇一摇", "x轴方向的重力加速度" + x + "；y轴方向的重力加速度" + y + "；z轴方向的重力加速度" +
		// z);
		// 一般在这三个方向的重力加速度达到40就达到了摇晃手机的状态。
		int medumValue = 13;// 三星 i9250怎么晃都不会超过20，没办法，只设置19了
		if (sensorType == Sensor.TYPE_ACCELEROMETER) {
			if (Math.abs(x) > medumValue || Math.abs(y) > medumValue
					|| Math.abs(z) > medumValue) {
				if (shakeListener != null) {
					shakeListener.onShake();
				}
				handler.sendEmptyMessage(2);
			}
		}

	}

}
