package com.qiniu.pili.droid.shortvideo.demo.tusdk;

import org.lasque.tusdk.core.TuSdk;
import org.lasque.tusdk.core.TuSdkApplication;

public class TuApplication extends TuSdkApplication {
    /**
     * 应用程序创建
     */
    @Override
    public void onCreate() {
        super.onCreate();

        /**
         ************************* TuSDK 集成三部曲 *************************
         *
         * 关于TuSDK体积 (约2M大小)
         *
         * Android 编译知识：
         * APK文件包含了Java代码，JNI库和资源文件；
         * JNI库包含arm64-v8a,armeabi等不同CPU的编译结果的集合，这些都会编译进 APK 文件；
         * 在安装应用时，系统会自动选择最合适的JNI版本，其他版本不会占用空间；
         * 除去资源和JNI库，SDK本身的大小约2M；
         *
         * 接入中有任何疑问可联系七牛技术支持
         */


        // 设置资源类，当 Application id 与 Package Name 不相同时，必须手动调用该方法, 且在 init 之前执行。
        // TuSdk.setResourcePackageClazz(org.lasque.tusdkdemo.R.class);

        // 自定义 .so 文件路径，在 init 之前调用
        // NativeLibraryHelper.shared().mapLibrary(NativeLibType.LIB_CORE, "libtusdk-library.so 文件路径");
        // NativeLibraryHelper.shared().mapLibrary(NativeLibType.LIB_IMAGE, "libtusdk-image.so 文件路径");

        // 设置输出状态，建议在接入阶段开启该选项，以便定位问题。
        TuSdk.setResourcePackageClazz(com.qiniu.pili.droid.shortvideo.demo.R.class);
        this.setEnableLog(true);
        /**
         *  初始化SDK，应用密钥是您的应用在 TuSDK 的唯一标识符。每个应用的包名(Bundle Identifier)、密钥、资源包(滤镜、贴纸等)三者需要匹配，否则将会报错。
         *
         *  @param appkey 应用秘钥 (当前密钥只能用于短视频 demo ，如用户需要在自己的应用中接入，需要另外申请密钥，请联系七牛销售申请密钥)
         */
        this.initPreLoader(this.getApplicationContext(), "ce51161476868602-03-bshmr1");

        /**
         *  指定开发模式,需要与lsq_tusdk_configs.json中masters.key匹配， 如果找不到devType将默认读取master字段
         *  如果一个应用对应多个包名，则可以使用这种方式来进行集成调试。
         */
        // this.initPreLoader(this.getApplicationContext(), "12aa4847a3a9ce68-04-ewdjn1", "debug");

        // 如果不想继承TuSdkApplication，直接在自定义Application.onCreate()方法中调用以下方法
        // 初始化全局变量
        // TuSdk.enableDebugLog(true);
        // 开发ID (请联系七牛销售获取您的 APP 开发秘钥)
        // TuSdk.init(this.getApplicationContext(), "12aa4847a3a9ce68-04-ewdjn1");
        // 需要指定开发模式 需要与lsq_tusdk_configs.json中masters.key匹配， 如果找不到devType将默认读取master字段
        // TuSdk.init(this.getApplicationContext(), "12aa4847a3a9ce68-04-ewdjn1", "debug");
    }
}