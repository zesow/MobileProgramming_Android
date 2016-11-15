package com.example.myloggerreal;

/**
 * Created by YooMoonSang on 2016. 11. 15..
 *
 * 지도에 뿌려주기 위한 위도,경도 및 메모내용을 저장하기 위한 클래스.
 */

public class MarkerItem {


    double lat;
    double lon;
    String content;

    public MarkerItem(double lon, double lat, String content) {
        this.lat = lat;
        this.lon = lon;
        this.content = content;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
