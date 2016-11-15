package com.example.myloggerreal;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;


public class Map extends Activity implements OnMapReadyCallback {

    static final LatLng SEOUL = new LatLng(37.56, 126.97);
    private GoogleMap googleMap;

    ArrayList<MarkerItem> mkArrayList;
    ArrayList<LatLng> latLng;

    @Override
    public void onMapReady(final GoogleMap map) {
        googleMap = map;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 0);

            Toast.makeText(getApplicationContext(),
                    "??", Toast.LENGTH_LONG).show();
        }


        googleMap.setMyLocationEnabled(true);

        latLng=new ArrayList<LatLng>();

        for(int i=0;i<mkArrayList.size();i++){
            double longitude=mkArrayList.get(i).getLon();
            double latitude=mkArrayList.get(i).getLat();
            LatLng position=new LatLng(latitude,longitude);

            latLng.add(position);


            googleMap.addMarker(
                    new MarkerOptions()
                        .position(new LatLng(latitude,longitude))
                        .title(mkArrayList.get(i).getContent())
            );

        }
        /*googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            public boolean onMarkerClick(Marker marker) {
                String text = "[마커 클릭 이벤트] latitude ="
                        + marker.getPosition().latitude + ", longitude ="
                        + marker.getPosition().longitude;
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG)
                        .show();
                return false;
            }
        });*/
        for(int i=0;i<latLng.size()-1;i++){

            googleMap.addPolyline(new PolylineOptions().add(latLng.get(i),latLng.get(i+1)).width(5).color(Color.RED));

        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom( SEOUL, 15));

        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapFrag);
        mapFragment.getMapAsync(this);

        final DBHelperReal dbHelper = new DBHelperReal(getApplicationContext(), "doing6.db", null, 1);

        mkArrayList=dbHelper.getMarker();

        //String s=mkArrayList.get(0).content+" "+mkArrayList.get(0).lat+" "+mkArrayList.get(0).lon;
        //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

}