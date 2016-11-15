package com.example.myloggerreal;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NowDoing extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    Position p=new Position();
    String content=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowdoing);
        final EditText editText = (EditText) findViewById(R.id.editText) ;

        final MyLocationListener ml = new MyLocationListener();
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        try {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, ml);
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, ml);
        } catch (SecurityException se) {
        }

        //1.하고 있는 일
        Spinner s = (Spinner) findViewById(R.id.spinner1);



        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                p.setPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //3.전송버튼
        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        //Toast.makeText(getApplicationContext(), "선택한 일, 좌표 데이터베이스에 저장.", Toast.LENGTH_LONG).show();
                        content=editText.getText().toString() ;
                        /*
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                ShowDBReal.class); // 다음 넘어갈 클래스 지정
                        intent.putExtra("position",p.getPosition());
                        intent.putExtra("content",content);
                        intent.putExtra("longitude",ml.longitude);
                        intent.putExtra("latitude",ml.latitude);
                        startActivity(intent); // 다음 화면으로 넘어간다
                        */
                        double longitude=ml.longitude;
                        double latitude=ml.latitude;
                        String pReal;
                        int position=p.getPosition();
                        if(position==0){
                            pReal="밥먹기";
                        }
                        else if(position==1){
                            pReal="카페가기";
                        }
                        else if(position==2){
                            pReal="피씨방";
                        }
                        else if(position==3){
                            pReal="노래방";
                        }
                        else if(position==4){
                            pReal="당구장";
                        }
                        else if(position==5){
                            pReal="영화관";
                        }
                        else{
                            pReal="술집";
                        }

                        final DBHelperReal dbHelper = new DBHelperReal(getApplicationContext(), "doing6.db", null, 1);

                        dbHelper.insert(pReal,content,longitude,latitude,position);

                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                MainActivity.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }
                }
        );


    }
}
