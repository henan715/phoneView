package com.example.nan.myphonestate.hardware;

import android.app.ActivityManager;
import android.content.Context;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Nan on 2016/5/12.
 */
public class Hardware_RAM {
    public final String RAM_TOTAL="内存总量";
    public final String RAM_USED="已用内存";
    public final String RAM_FREE="剩余内存";

    public String total_ram;
    public long used_ram;

    private ActivityManager activityManager;
    ActivityManager.MemoryInfo memoryInfo;

    public Hardware_RAM(Context context) {
        activityManager=(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        memoryInfo=new ActivityManager.MemoryInfo();
    }

    //获取内存总量
    public String getTotal_ram() {
        String[] arrayOfString;//获取到的ram信息格式为“MemTotal: 1899564 kb”,需要二次处理以更好的阅读
        long convertSize;//将原始的kb大小转化为MB大小
        try{
            FileReader fileReader=new FileReader("/proc/meminfo");//通过读取系统文件获取总内存大小
            BufferedReader bufferedReader=new BufferedReader(fileReader,8192);
            total_ram=bufferedReader.readLine();//读取第一行的系统总内存大小
            arrayOfString=total_ram.split("\\s+");
            convertSize=Integer.valueOf(arrayOfString[1]).intValue()/1024;
            total_ram=convertSize+"MB";

            fileReader.close();
            bufferedReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return total_ram;
    }

    //获取已用的内存(这边的方法可以优化一下，上下两个方法都返回了string类型，可以将代码抽取一下简化代码，这边就不抽了)
    public String getUsed_ram() {
        //获取总内存
        String totalRAM;
        String[] arrayOfString;
        long convertSize;
        try{
            FileReader fileReader=new FileReader("/proc/meminfo");//通过读取系统文件获取总内存大小
            BufferedReader bufferedReader=new BufferedReader(fileReader,8192);
            totalRAM=bufferedReader.readLine();//读取第一行的系统总内存大小
            arrayOfString=totalRAM.split("\\s+");
            convertSize=Integer.valueOf(arrayOfString[1]).intValue()/1024;
            fileReader.close();
            bufferedReader.close();

            //获取可用内存
            activityManager.getMemoryInfo(memoryInfo);
            long freeRAM= memoryInfo.availMem/(1024*1024);

            used_ram=convertSize-freeRAM;
        } catch (Exception e){
            e.printStackTrace();
        }


        return used_ram+"MB";
    }

    //获取可用运存大小
    public String getFree_ram() {
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem/(1024*1024)+"MB";
    }
}
