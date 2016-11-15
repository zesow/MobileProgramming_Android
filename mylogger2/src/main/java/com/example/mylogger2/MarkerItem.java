package com.example.mylogger2;

/**
 * Created by YooMoonSang on 2016. 11. 12..
 */

public class MarkerItem {


    double lat;
    double lon;
    int position;
    String content;

    public MarkerItem(double lat, double lon, int position,String content) {
        this.lat = lat;
        this.lon = lon;
        this.position=position;
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

    public int getPrice() {
        return position;
    }

    public void setPrice(int position) {
        this.position = position;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content=content;
    }

}
