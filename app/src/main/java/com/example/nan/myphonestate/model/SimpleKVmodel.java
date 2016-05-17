package com.example.nan.myphonestate.model;

/**
 * Created by Nan on 2016/5/7.
 */
public class SimpleKVmodel {
    private String item_key;
    private String item_value;

    public SimpleKVmodel() {
    }

    public SimpleKVmodel(String item_key, String item_value) {
        this.item_key = item_key;
        this.item_value = item_value;
    }

    public String getItem_key() {
        return item_key;
    }

    public void setItem_key(String item_key) {
        this.item_key = item_key;
    }

    public String getItem_value() {
        return item_value;
    }

    public void setItem_value(String item_value) {
        this.item_value = item_value;
    }

    @Override
    public String toString() {
        return "SimpleKVmodel{" +
                "item_key='" + item_key + '\'' +
                ", item_value='" + item_value + '\'' +
                '}';
    }
}
