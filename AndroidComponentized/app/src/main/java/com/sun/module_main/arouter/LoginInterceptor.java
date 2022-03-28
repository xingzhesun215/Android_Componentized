package com.sun.module_main.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.sun.commonlibrary.arouter.ArouterPath;
import com.sun.module_main.MyApplication;

//跳转进行切面登录拦截,框架自动处理,需处理不需要登录路径,否则跳去拦截回调函数onInterrupt()
@Interceptor(name = "login", priority = 6)
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        Log.e("ME","登录切片拦截 path="+path);
        boolean isLogin = MyApplication.loginToken;

        if (isLogin) { // 如果已经登录不拦截
            callback.onContinue(postcard);
        } else {  // 如果没有登录
            switch (path) {
                // 不需要登录的直接进入这个页面
                case ArouterPath.APP_RouterDataActivity:
                case ArouterPath.APP_RouterLoginActivity:
                case ArouterPath.APP_RouterMainActivity:
                    callback.onContinue(postcard);
                    break;
                // 需要登录的直接拦截下来
                default:
                    callback.onInterrupt(null);
                    break;
            }
        }

    }

    @Override
    public void init(Context context) {//此方法只会走一次
        Log.e("LoginInterceptorImpl","路由登录拦截器初始化成功");
    }
}
