package com.sun.module_main.arouter;


import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.commonlibrary.arouter.ArouterPath;
import com.sun.commonlibrary.base.BaseActivity;
import com.sun.commonlibrary.util.TestBean;
import com.sun.module_main.R;

/**
 * 用来测试本模块自跳转,同时跳转到其他模块的页面
 */
@Route(path = ArouterPath.APP_RouterDataActivity)
public class RouterDataActivity extends BaseActivity {
    public static final String BOOLEAN_KEY = "BOOLEAN_KEY";
    public static final String INT_KEY = "BOOLEAN_INT";
    public static final String STRING_KEY = "BOOLEAN_STRING";
    public static final String STRING_BEAN = "BOOLEAN_BEAN";


    @Autowired(name = BOOLEAN_KEY)
    public boolean data_boolean;

    @Autowired(name = INT_KEY)
    public int data_int;

    @Autowired(name = STRING_KEY)
    public String data_String;

    @Autowired(name = STRING_BEAN)
    public TestBean bean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_routerdata;
    }

    @Override
    protected void initView() {
        TextView tv_message = this.findViewById(R.id.tv_message);
        tv_message.append("\n     我不关心我的登录状态");
        tv_message.append("\n     boolean=" + data_boolean);
        tv_message.append("\n     int=" + data_int);
        tv_message.append("\n     string=" + data_String);
        tv_message.append("\n     bean=" + bean.toString());
    }

    @Override
    protected void initData() {
    }
}