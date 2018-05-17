package com.example.hydra.quizactivity.utils;

import android.util.Log;

/**
 * Log工具类，主要通过if判断，来区分不同等级，通过设置level的值来分别打印不同等级的日志文件
 */
public class LogUtil {
    //常量
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    //静态变量
    public static int level = VERBOSE;

    public static void v(String tag, String msg){
        if (level <= VERBOSE){
            Log.v(tag , msg);
        }
    }
    public static void d(String tag, String msg){
        if (level <= VERBOSE){
            Log.v(tag , msg);
        }
    }public static void i(String tag, String msg){
        if (level <= VERBOSE){
            Log.v(tag , msg);
        }
    }public static void w(String tag, String msg){
        if (level <= VERBOSE){
            Log.v(tag , msg);
        }
    }public static void e(String tag, String msg){
        if (level <= VERBOSE){
            Log.v(tag , msg);
        }
    }
}
