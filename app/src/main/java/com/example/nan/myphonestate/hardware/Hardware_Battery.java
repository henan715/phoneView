package com.example.nan.myphonestate.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Created by Nan on 2016/5/12.
 */
public class Hardware_Battery {
    public final String BATTERY_STATUS="电池状态";
    public final String BATTERY_HEALTH="电池健康";
    public final String BATTERY_LEVEL="剩余电量";
    public final String BATTERY_TECHNOLOGY="电池类别";
    public final String BATTERY_TEMPERATURE ="电池温度";
    public final String BATTERY_VOLTAGE="电池电压";
    public final String BATTERY_PLUNGGED="充电类别";

    Intent batteryIntent;

    private int battery_status;
    private int battery_level;
    private int battery_health;
    private String battery_technology;
    private double battery_temperature;
    private int battery_voltage;
    private int battery_plungged;


    public Hardware_Battery(Context context) {
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        batteryIntent=context.getApplicationContext().registerReceiver(null,filter);
    }

    /**
     * 返回电池状态
     * @return
     */
    public String getBattery_status() {
        battery_status=batteryIntent.getIntExtra("status",0);
        switch (battery_status){
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                return "未知状态";
            case BatteryManager.BATTERY_STATUS_CHARGING:
                return "充电中";
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                return "放电中";
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                return "未充电";
            case BatteryManager.BATTERY_STATUS_FULL:
                return "充电完成";
            default:
                return "电池状态获取失败";
        }
    }

    /**
     * 返回电池健康信息
     * @return
     */
    public String getBattery_health() {
        battery_health=batteryIntent.getIntExtra("health",1);
        switch (battery_health){
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                return "状态未知";
            case BatteryManager.BATTERY_HEALTH_GOOD:
                return "电池健康";
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                return "电池过热";
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                return "电压过高";
            case BatteryManager.BATTERY_HEALTH_COLD:
                return "电池过寒";
            case BatteryManager.BATTERY_HEALTH_DEAD:
                return "电池失效";
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                return "未知异常";
            default:
                return "电池健康信息获取失败";
        }
    }

    /**
     * 返回电池当前电量
     * @return
     */
    public String getBattery_level(){
        battery_level=batteryIntent.getIntExtra("level",0);
        return battery_level+"%";
    }

    /**
     * 返回电池温度信息
     * @return
     */
    public String getBattery_temperature(){
        battery_temperature=(double)batteryIntent.getIntExtra("temperature",1);
        return battery_temperature/10+"℃";
    }

    /**
     * 返回电池电压信息
     * @return
     */
    public String getBattery_voltage(){
        battery_voltage=batteryIntent.getIntExtra("voltage",1);
        return battery_voltage+"mV";
    }

    /**
     * 返回当前充电类型
     * @return
     */
    public String getBattery_plungged(){
        battery_plungged=batteryIntent.getIntExtra("plunged",0);
        switch (battery_plungged){
            case BatteryManager.BATTERY_PLUGGED_AC:
                return "电源充电中";
            case BatteryManager.BATTERY_PLUGGED_USB:
                return "USB充电中";
            case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                return "无线充电中";
            default:
                return "未知的充电方式";
        }
    }

    /**
     * 返回电池类别
     * @return
     */
    public String getBattery_technology() {
        battery_technology=batteryIntent.getStringExtra("technology");
        return battery_technology;
    }
}
