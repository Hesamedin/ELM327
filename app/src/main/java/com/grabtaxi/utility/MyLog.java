package com.grabtaxi.utility;

/**
 * Created by admin on 12/29/14
 */
public class MyLog
{
    private static boolean LOG = true;

    public static void i(String tag, String string)
    {
        if (LOG)
        {
            android.util.Log.i(tag, string);
        }
    }

    public static void e(String tag, String string)
    {
//        if(LOG)
        android.util.Log.e(tag, string);
    }

    public static void e(String tag, String string, Throwable tr)
    {
//        if(LOG)
        android.util.Log.e(tag, string, tr);
    }

    public static void d(String tag, String string)
    {
        if (LOG)
        {
            android.util.Log.d(tag, string);
        }
    }

    public static void v(String tag, String string)
    {
        if (LOG)
        {
            android.util.Log.v(tag, string);
        }
    }

    public static void w(String tag, String string)
    {
        if (LOG)
        {
            android.util.Log.w(tag, string);
        }
    }
}
