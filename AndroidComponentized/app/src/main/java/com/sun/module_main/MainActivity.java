package com.sun.module_main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sun.main.BuildConfig;
import com.sun.main.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "当前组件moduleA是否在当前项目中=" + BuildConfig.isModuleA_To_Main);
    }
}