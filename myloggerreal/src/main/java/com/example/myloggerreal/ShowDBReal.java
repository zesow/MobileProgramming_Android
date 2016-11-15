package com.example.myloggerreal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDBReal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdbreal);
        //Log.d("디버그","여기까지3");
        final DBHelperReal dbHelper = new DBHelperReal(getApplicationContext(), "doing6.db", null, 1);
        //Log.d("디버그","여기까지4");
        Intent intent = getIntent();

        int position = intent.getExtras().getInt("position");
        //Log.d("디버그","여기까지5");
        String pReal;

        if(position==0){
            //Toast.makeText(getApplicationContext(), "밥먹기", Toast.LENGTH_SHORT).show();
            pReal="밥먹기";
        }
        else if(position==1){
            //Toast.makeText(getApplicationContext(), "카페가기", Toast.LENGTH_SHORT).show();
            pReal="카페가기";
        }
        else if(position==2){
            //Toast.makeText(getApplicationContext(), "PC방", Toast.LENGTH_SHORT).show();
            pReal="피씨방";
        }
        else if(position==3){
            //Toast.makeText(getApplicationContext(), "노래방", Toast.LENGTH_SHORT).show();
            pReal="노래방";
        }
        else if(position==4){
            //Toast.makeText(getApplicationContext(), "당구", Toast.LENGTH_SHORT).show();
            pReal="당구장";
        }
        else if(position==5){
            //Toast.makeText(getApplicationContext(), "영화", Toast.LENGTH_SHORT).show();
            pReal="영화관";
        }
        else{
            //Toast.makeText(getApplicationContext(), "술집", Toast.LENGTH_SHORT).show();
            pReal="술집";
        }
        //Log.d("디버그","여기까지6");
        String content = intent.getExtras().getString("content");
        double longitude=intent.getExtras().getDouble("longitude");
        double latitude=intent.getExtras().getDouble("latitude");
        //Log.d("디버그","여기까지7");
        dbHelper.insert(pReal,content,longitude,latitude,position);
        Log.d("디버그","여기까지");
        // 테이블에 있는 모든 데이터 출력
        final TextView result = (TextView) findViewById(R.id.result);
        // DB에 있는 데이터 조회
        result.setText(dbHelper.getResult());
        Log.d("디버그","여기까지2");
    }
}
