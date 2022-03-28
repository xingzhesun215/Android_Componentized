package com.sun.commonlibrary.arouter;

public class ArouterPath {


    /**
     * 路径必须是/xxx/xxx
     * 不然编译出错 [Failed to extract default group! String index out of range: -2]
     */
    //app MainActivity
    public static final String APP_MainActivity="/app/MainActivity";

    public static final String APP_RouterLoginActivity="/app/RouterLoginActivity";
    public static final String APP_RouterMainActivity="/app/RouterMainActivity";
    public static final String APP_RouterDataActivity="/app/RouterDataActivity";


    public static final String MODULEA_RouterDataActivity="/module_a/RouterDataActivity";

}
