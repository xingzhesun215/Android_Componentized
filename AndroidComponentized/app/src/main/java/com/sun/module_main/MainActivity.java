package com.sun.module_main;

import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.commonlibrary.arouter.ArouterPath;
import com.sun.commonlibrary.base.BaseActivity;

@Route(path = ArouterPath.APP_MainActivity)
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Log.e(TAG, "当前组件moduleA是否在当前项目中=" + BuildConfig.isModuleA_To_Main);


    }

    @Override
    protected void initData() {
//        ARouter.getInstance().build(ArouterPath.APP_RouterMainActivity).navigation();
        ARouter.getInstance().build(ArouterPath.APP_RouterMainActivity)
                .navigation(this,new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.e(TAG,"found="+postcard.getPath());
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.e(TAG,"onLost="+postcard.getPath());
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.e(TAG,"onArrival="+postcard.getPath());
                        MainActivity.this.finish();
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.e(TAG,"onInterrupt="+postcard.getPath());
                    }
                });
    }
}