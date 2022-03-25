package module;

import com.sun.commonlibrary.base.BaseApplication;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
}
