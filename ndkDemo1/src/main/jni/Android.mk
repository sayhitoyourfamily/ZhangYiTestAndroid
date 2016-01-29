LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := zyndk
LOCAL_SRC_FILES := zyndk.cpp



include $(BUILD_SHARED_LIBRARY)
