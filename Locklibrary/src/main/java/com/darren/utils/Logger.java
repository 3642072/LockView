package com.darren.utils;

import android.util.Log;

import java.io.FileNotFoundException;

public class Logger {
 private static final String TAG = "Logger";
 private static final boolean DEBUG = true;
 private Logger() {
  //Do nothing
 }

 public static void d(String sMessage) {
  if (DEBUG) {
   d(TAG, sMessage);
  }
 }

 public static void d(Object o) {
  Logger.d(String.valueOf(o));
 }

 public static void d(String sTag, String sMessage) {
  if (DEBUG&&null != sMessage) {
    Log.d(sTag, sMessage);
  }
 }

 // Warning Info
 public static void w(String sTag, String sMessage) {
  if (DEBUG&&null != sMessage) {
    Log.w(sTag, sMessage);
  }
 }

 // Error Info
 public static void e(String sMessage) {
  if (DEBUG&&null != sMessage) {
    e(TAG, sMessage);
   }
 }

 public static void e(String sTag, String sMessage) {
  if (DEBUG&&null != sMessage) {
    Log.e(sTag, sMessage);
  }
 }
 // 打印log
  public static void log(String tag, FileNotFoundException msg) {
   Log.d(tag, String.valueOf(msg));
  }
}
