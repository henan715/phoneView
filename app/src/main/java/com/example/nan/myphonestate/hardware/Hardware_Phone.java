package com.example.nan.myphonestate.hardware;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nan on 2016/5/13.
 */
public class Hardware_Phone {
    public final String PHONE_BRAND="设备品牌";
    public final String PHONE_MANUFACTER="制造厂商";
    public final String PHONE_PRODUCT="产品全称";
    public final String PHONE_BOARD="主板型号";
    public final String PHONE_BOOTLOADER="BootLoader";
    public final String PHONE_DEVICE="设备型号";
    public final String PHONE_BUILDTIME="内核编译时间";
    public final String PHONE_HARDWARE="硬件版本";

    private String phone_brand;
    private String phone_manufacter;
    private String phone_product;
    private String phone_board;
    private String phone_bootloader;
    private String phone_device;
    private String phone_buildtime;
    private String phone_hardware;

    private Context mContex;
    private TelephonyManager telecomManager;

    public Hardware_Phone(Context context) {
        this.mContex=context;
        telecomManager=(TelephonyManager)mContex.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public String getPhone_brand() {
        return Build.BRAND;
    }

    public String getPhone_manufacter() {
        return Build.MANUFACTURER;
    }

    public String getPhone_product() {
        return Build.PRODUCT;
    }

    public String getPhone_board() {
        return Build.BOARD;
    }

    public String getPhone_bootloader() {
        return Build.BOOTLOADER;
    }

    public String getPhone_device() {
        return Build.DEVICE;
    }

    public String getPhone_buildtime() {
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date=new Date(Build.TIME);
        phone_buildtime=sdf.format(date);
        return phone_buildtime;
    }

    public String getPhone_hardware() {
        return Build.HARDWARE;
    }
}
