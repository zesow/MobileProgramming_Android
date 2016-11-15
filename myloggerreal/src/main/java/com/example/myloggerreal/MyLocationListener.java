package com.example.myloggerreal;

import android.location.*;
import android.os.Bundle;

/**
 * Created by YooMoonSang on 2016. 11. 15..
 */

class MyLocationListener implements LocationListener {

    double longitude;
    double latitude;
    public void onLocationChanged(android.location.Location loc) {

        longitude = loc.getLongitude();
        latitude = loc.getLatitude();
        String msg = "Longtitude : " + longitude + "\nLatitude : " + latitude;
        //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

}
