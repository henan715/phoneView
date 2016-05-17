package com.example.nan.myphonestate.hardware;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Nan on 2016/5/13.
 */
public class Hardware_Display {
    public final String DISPLAY_SIZE="屏幕分辨率";
    public final String DISPLAY_DPI="屏幕DPI";
    public final String MULTITOUCH="多点触控";

    public String displaySize;
    public String displayDpi;
    public String multiTouch;
    private Context mContex;
    DisplayMetrics dm;

    public Hardware_Display(Context context) {
        this.mContex=context;
    }

    public String getDisplaySize() {
        dm=mContex.getResources().getDisplayMetrics();
        displaySize=dm.widthPixels+"*"+dm.heightPixels;
        return displaySize;
    }

    public String getDisplayDpi() {
        dm=mContex.getResources().getDisplayMetrics();
        displayDpi=dm.densityDpi+"";
        return displayDpi;
    }

    public String getMultiTouch() {
        multiTouch="未知";
        PackageManager pm=mContex.getPackageManager();
        boolean isMultiTouchSupported=pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH);
        if (isMultiTouchSupported){
            multiTouch="支持";
        } else {
            multiTouch="不支持";
        }
        return multiTouch;
    }
}
