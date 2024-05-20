package com.example.myproud.internetmodel.beans;
/*"data": {
        "zh": "未来可期。",
        "en": "There is more to come.",
        "pic": "https://staticedu-wps.cache.iciba.com/image/60c4b0b16daa6141b4dc1b9c9dc1b652.jpg"
}*/

public class Data {
    private String zh;
    private String en;
    private String pic;

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Data{" +
                "zh='" + zh + '\'' +
                ", en='" + en + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}