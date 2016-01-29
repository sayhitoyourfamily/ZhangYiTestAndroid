package com.zy.ndkdemo1;

/**
 * @author zhangyi
 *
 * TODO  jni的方法类，在这里面声明了native方法，方法的实现在xxx.cpp文件中
 */
public class JNI {
	
	/**
	 * 经常在调用一个已编译好的so库，在安卓上加载该库时找不到报错。
java.lang.UnsatisfiedLinkError: no XXX in java.library.path
库的路径不对
static 
{
	System.setProperty("java.library.path", "."); 
	System.loadLibrary("testcalc");
	//System.load("/home/lijungang/android/projects/calculation/libs/armeabi/libtestcalc.so");
}

	 * 
	 */
	
	
	//加载本地类库，以调用native方法
	static {
		System.loadLibrary("zyndk");
		LogKT.zy("JNI---------static-----------");
		
	}

	/**
	 * 得到一个字符串
	 * @return
	 */
	public static native String stringFromJNI();

	/**
	 * 计算两个数的和
	 * @param a
	 * @param z
	 * @return
	 */
	public static native double add(double a, double z);
	
	/**
	 * 获取一个布尔值
	 * @param b
	 * @return
	 */
	public static native boolean getBoolean(boolean b);
	
	/**
	 * 求一个int数组的和
	 * @param a
	 * @return
	 */
	public static native int getIntArraySum(int[] a);
	
	/**
	 * 得到一个int型的数组
	 * @param a  数组的长度
	 * @return
	 */
	public static native int[] getIntArray(int a);
	
	public static native int ad(double a,double b,int c);
	
}
