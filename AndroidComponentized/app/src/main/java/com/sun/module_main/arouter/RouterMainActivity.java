package com.sun.module_main.arouter;


import android.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.commonlibrary.arouter.ArouterPath;
import com.sun.commonlibrary.base.BaseActivity;
import com.sun.commonlibrary.util.TestBean;
import com.sun.module_main.R;

import java.net.ServerSocket;

/**
 * 进行Arouter跳转的主页面
 */

@Route(path = ArouterPath.APP_RouterMainActivity)
public class RouterMainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_routermain;
    }

    @Override
    protected void initView() {
        Fragment fragment=(Fragment) ARouter.getInstance().build(ArouterPath.APP_RouterFragment).navigation();
        getFragmentManager().beginTransaction().add(R.id.frame,fragment).commit();
    }

    @Override
    protected void initData() {

    }

    public void moduleParamsClick(View view) {
        TestBean bean = new TestBean("sunguanyong", 30);
        ARouter.getInstance().build(ArouterPath.APP_RouterDataActivity)
                .withBoolean(RouterDataActivity.BOOLEAN_KEY, true)
                .withInt(RouterDataActivity.INT_KEY, 100)
                .withString(RouterDataActivity.STRING_KEY, "hello Android组件化")
                .withObject(RouterDataActivity.STRING_BEAN, bean)
                .navigation();
    }


    public void moduleParamsLoginClick(View view) {
        TestBean bean = new TestBean("sunguanyong", 30);
        ARouter.getInstance().build(ArouterPath.MODULEA_RouterDataActivity)
                .withBoolean(RouterDataActivity.BOOLEAN_KEY, true)
                .withInt(RouterDataActivity.INT_KEY, 100)
                .withString(RouterDataActivity.STRING_KEY, "hello Android组件化")
                .withObject(RouterDataActivity.STRING_BEAN, bean)
                .navigation(this, new LoginNavigationCallback());
    }
}