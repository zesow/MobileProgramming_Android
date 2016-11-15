package com.example.myloggerreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                NowDoing.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }
                }
        );

        findViewById(R.id.button2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                Statistic.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }
                }
        );

        findViewById(R.id.button3).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                Map.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }
                }
        );

        findViewById(R.id.button4).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        final DBHelperReal dbHelper = new DBHelperReal(getApplicationContext(), "doing6.db", null, 1);
                        dbHelper.delete();
                        Toast.makeText(getApplicationContext(), "데이터베이스 초기화 완료.", Toast.LENGTH_LONG).show();
                    }
                }
        );

        findViewById(R.id.button5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                ShowDBReal.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }
                }
        );
    }
}
