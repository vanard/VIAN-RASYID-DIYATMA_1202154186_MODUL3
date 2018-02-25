package com.studycase.vanard.vianrasyiddiyatma_1202154186_modul3;

/**
 * Created by viani on 25/02/2018.
 */

public class Galon {
    //varaible
    String title, subtitle, desc;
    int imgGalon;

    //konstruktor
    public Galon(String title, String subtitle, String desc, int imgGalon) {
        this.title = title;
        this.subtitle = subtitle;
        this.desc = desc;
        this.imgGalon = imgGalon;
    }

    //getter
    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDesc() {
        return desc;
    }

    public int getImgGalon() {
        return imgGalon;
    }
}
