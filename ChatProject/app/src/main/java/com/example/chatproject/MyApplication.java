package com.example.chatproject;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context _context;

    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
    }

    public static Context getAppContext() {
        return _context;
    }
}
