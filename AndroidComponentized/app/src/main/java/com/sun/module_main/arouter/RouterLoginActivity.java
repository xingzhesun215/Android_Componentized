package com.sun.module_main.arouter;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.commonlibrary.arouter.ArouterPath;
import com.sun.commonlibrary.base.BaseActivity;
import com.sun.module_main.MyApplication;
import com.sun.module_main.R;


@Route(path = ArouterPath.APP_RouterLoginActivity)
public class RouterLoginActivity extends BaseActivity {

    @Autowired(name = "message")
    public String message;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_arouterlogin;
    }

    @Override
    protected void initView() {
        TextView tv_message = this.findViewById(R.id.tv_message);
        tv_message.append(message);
    }


    @Override
    protected void initData() {

    }

    public void loginClick(View view) {

        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        MyApplication.loginToken = true;
    }
}
