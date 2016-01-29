#include <jni.h>
#include<stdio.h>
#include <stdlib.h>
extern "C" {
JNIEXPORT jboolean JNICALL Java_com_zy_ndkdemo1_JNI_getBoolean(JNIEnv *e,
		jobject thiz, jboolean b) {

	return b;
}

JNIEXPORT jstring JNICALL Java_com_zy_ndkdemo1_JNI_stringFromJNI(JNIEnv *env,
		jobject thiz) {
	return env->NewStringUTF("Hello my  JNI");
}
JNIEXPORT jdouble JNICALL Java_com_zy_ndkdemo1_JNI_add(JNIEnv *env,
		jobject thiz, jdouble a, jdouble b) {

	double k;
	k = (double) a + (double) b;

	return (jdouble) k;

}


JNIEXPORT jint JNICALL Java_com_zy_ndkdemo1_JNI_ad(JNIEnv *env,jobject thiz,double a,double b,int c){

	int  i=0;
	i=a+b+c;
	return i;
}

JNIEXPORT jint JNICALL Java_com_zy_ndkdemo1_JNI_getIntArraySum(JNIEnv *env,
		jobject obj, jintArray array) {
	int sum = 0;
	jsize length = env->GetArrayLength(array); //获取数组长度
	if (length == 0) //防止异常发生，如果是空的需要返回了
		return 0;

	jint *pointer = env->GetIntArrayElements(array, 0); //获取数组指针
	for (int i = 0; i < length; i++) {
		sum += pointer[i]; //相加每个数组元素
	}
	env->ReleaseIntArrayElements(array, pointer, 0); //释放内存，这个不能忘了
	return sum;
}

JNIEXPORT jintArray JNICALL
Java_com_zy_ndkdemo1_JNI_getIntArray(JNIEnv *env, jclass clazz, jint size) {
	jintArray result; //定义返回对象

	result = env->NewIntArray(size); //构造一个新的数组对象
	if (result == NULL) {
		return NULL;
	}
	jint szBuffer[256];
	for (int i = 0; i < size; i++) //循环size次
			{
		szBuffer[i] = i + 10;
	}
	env->SetIntArrayRegion(result, 0, size, szBuffer);
	//env->DeleteLocalRef( result);

	return result;
}

}
