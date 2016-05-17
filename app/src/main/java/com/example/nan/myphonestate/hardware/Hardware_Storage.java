package com.example.nan.myphonestate.hardware;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by Nan on 2016/5/13.
 */
public class Hardware_Storage {
    public final String INTERNAL_STORAGE_TOTALSIZE="内部存储总量";
    public final String INTERNAL_STORAGE_USEDSIZE="内部存储已用";
    public final String INTERNAL_STORAGE_FREESIZE="内部存储剩余";
    public final String EXTERNAL_STORAGE_TOTALSIZE="外部存储总量";
    public final String EXTERNAL_STORAGE_USEDSIZE="外部存储已用";
    public final String EXTERNAL_SOTRAGE_FREESIZE="外部存储剩余";

    private String internalStorageSize;
    private String internalStorageUsed;
    private String internalStorageFree;
    private String externalStorageSize;
    private String externalStorageUsed;
    private String externalStorageFree;

    public Hardware_Storage() {
    }

    //获取内置存储的总大小
    public String getInternalStorageSize() {
        File filePath=Environment.getDataDirectory();
        long totalsize;
        StatFs statFs=new StatFs(filePath.getPath());
        if (statFs!=null){
            long blockSize=statFs.getBlockSize();
            long totalBlocks=statFs.getBlockCount();
            totalsize=blockSize*totalBlocks/(1024*1024);//返回MB大小
            internalStorageSize=totalsize+"MB";
        } else{
            internalStorageSize="获取失败";
        }
        return internalStorageSize;
    }

    //获取内置存储已用的大小
    public String getInternalStorageUsed() {
        File filePath=Environment.getDataDirectory();
        long totalsize;
        StatFs statFs=new StatFs(filePath.getPath());
        if (statFs!=null){
            long blockSize=statFs.getBlockSize();
            long totalBlocks=statFs.getBlockCount();
            long availableBlock=statFs.getAvailableBlocks();
            totalsize=blockSize*(totalBlocks-availableBlock)/(1024*1024);//返回MB大小
            internalStorageUsed=totalsize+"MB";
        } else{
            internalStorageUsed="获取失败";
        }
        return internalStorageUsed;
    }

    //获取可用的内置存储大小
    public String getInternalStorageFree() {
        File filePath=Environment.getDataDirectory();
        long totalsize;
        StatFs statFs=new StatFs(filePath.getPath());
        if (statFs!=null){
            long blockSize=statFs.getBlockSize();
            long availableBlock=statFs.getAvailableBlocks();
            totalsize=blockSize*availableBlock/(1024*1024);//返回MB大小
            internalStorageFree=totalsize+"MB";
        } else{
            internalStorageFree="获取失败";
        }
        return internalStorageFree;
    }

    //获取sd卡总大小
    public String getExternalStorageSize() {
        if (hasSDCard()){
            long totalsize;
            File filePath=Environment.getExternalStorageDirectory();
            StatFs statFs=new StatFs(filePath.getPath());
            if (statFs!=null){
                long blocSize=statFs.getBlockSize();
                long totalBlocks=statFs.getBlockCount();
                totalsize=blocSize*totalBlocks/(1024*1024);//返回MB大小
                externalStorageSize=totalsize+"MB";
            } else{
                externalStorageSize="获取失败";
            }
        }
        return externalStorageSize;
    }

    //获取sd卡已经使用的大小
    public String getExternalStorageUsed() {
        if (hasSDCard()){
            long usedSize;
            File filePath=Environment.getExternalStorageDirectory();
            StatFs statFs=new StatFs(filePath.getPath());
            if (statFs!=null){
                long blocSize=statFs.getBlockSize();
                long avaiableBlocks=statFs.getAvailableBlocks();
                long totalBlocks=statFs.getBlockCount();
                usedSize=blocSize*(totalBlocks-avaiableBlocks)/(1024*1024);//返回MB大小
                externalStorageUsed=usedSize+"MB";
            } else{
                externalStorageUsed="获取失败";
            }
        }
        return externalStorageUsed;
    }

    //获取sd卡剩余容量
    public String getExternalStorageFree() {
        if (hasSDCard()){
            long totalsize;
            File filePath=Environment.getExternalStorageDirectory();
            StatFs statFs=new StatFs(filePath.getPath());
            if (statFs!=null){
                long blocSize=statFs.getBlockSize();
                long avaiableBlocks=statFs.getAvailableBlocks();
                totalsize=blocSize*avaiableBlocks/(1024*1024);//返回MB大小
                externalStorageFree=totalsize+"MB";
            } else{
                externalStorageFree="获取失败";
            }
        }
        return externalStorageFree;
    }

    //检查是否有sd卡
    public static boolean hasSDCard(){
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }
}
