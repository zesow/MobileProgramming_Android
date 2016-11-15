package com.example.mylogger2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        final DBHelperReal dbHelper = new DBHelperReal(getApplicationContext(), "doing3.db", null, 1);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("position");
        String content = intent.getExtras().getString("content");

        double longitude=intent.getExtras().getDouble("longitude");
        double latitude=intent.getExtras().getDouble("latitude");



        dbHelper.insert(position, content,longitude,latitude);

        // 테이블에 있는 모든 데이터 출력
        final TextView result = (TextView) findViewById(R.id.result);
        // DB에 있는 데이터 조회
        result.setText(dbHelper.getResult());

    }
}
