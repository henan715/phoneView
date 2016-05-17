package com.example.nan.myphonestate.hardware;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by Nan on 2016/5/13.
 */
public class Hardware_OS {
    public final String OS_BASE_OS="基带系统";
    public final String OS_CODENAME="系统类别";
    public final String OS_INCREMENTAL="系统编译次数";
    public final String OS_SDK_NAME="系统版本";
    public final String OS_SDK_VERSION="SDK版本";
    public final String OS_SDK_RELEASE="发布版本";

    private String baseOS;
    private String codeName;
    private String incremental;
    private String sdkName;
    private int sdkVersion;
    private String sdkRelease;


    private Context mContex;
    private PackageManager packageManager;
    private PackageInfo packageInfo;

    public Hardware_OS(Context context) {
        this.mContex=context;
        packageManager=mContex.getPackageManager();
        try{
            packageInfo=packageManager.getPackageInfo(mContex.getPackageName(),0);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getBaseOS() {
        baseOS=Build.VERSION.BASE_OS;
        return baseOS;
    }

    public String getCodeName() {
        codeName=Build.VERSION.CODENAME;
        return codeName;
    }

    public String getIncremental() {
        incremental=Build.VERSION.INCREMENTAL;
        return incremental;
    }

    public String getSdkName() {
        sdkName=Build.VERSION.SDK;
        return sdkName;
    }

    public String getSdkVersion() {
        sdkVersion=Build.VERSION.SDK_INT;
        return sdkVersion+"";
    }

    public String getSdkRelease() {
        sdkRelease=Build.VERSION.RELEASE;
        return sdkRelease;
    }
}//---end of all---
