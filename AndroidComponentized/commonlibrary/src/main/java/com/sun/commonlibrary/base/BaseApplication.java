package com.sun.commonlibrary.base;

import android.app.Application;


public class BaseApplication extends Application {

    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {

    }

}
