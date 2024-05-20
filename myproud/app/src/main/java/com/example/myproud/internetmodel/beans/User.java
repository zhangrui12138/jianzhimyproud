package com.example.myproud.internetmodel.beans;

import android.text.Html;
import android.text.SpannableString;
/*{
        "success": true,
        "data": {
        "zh": "未来可期。",
        "en": "There is more to come.",
        "pic": "https://staticedu-wps.cache.iciba.com/image/60c4b0b16daa6141b4dc1b9c9dc1b652.jpg"
        }
    }*/
public class User {
    private boolean success;
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
