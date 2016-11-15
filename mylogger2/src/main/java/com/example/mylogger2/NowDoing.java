package com.example.mylogger2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class NowDoing extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    Position p=new Position();
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowdoing);
        EditText editText = (EditText) findViewById(R.id.editText) ;


        //1.하고 있는 일
        Spinner s = (Spinner) findViewById(R.id.spinner1);



        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                p.setPosition(position);

                if(position==0){
                    Toast.makeText(getApplicationContext(), "밥먹기", Toast.LENGTH_SHORT).show();

                }
                else if(position==1){
                    Toast.makeText(getApplicationContext(), "카페가기", Toast.LENGTH_SHORT).show();

                }
                else if(position==2){
                    Toast.makeText(getApplicationContext(), "PC방", Toast.LENGTH_SHORT).show();

                }
                else if(position==3){
                    Toast.makeText(getApplicationContext(), "노래방", Toast.LENGTH_SHORT).show();

                }
                else if(position==4){
                    Toast.makeText(getApplicationContext(), "당구", Toast.LENGTH_SHORT).show();

                }
                else if(position==5){
                    Toast.makeText(getApplicationContext(), "영화", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "술집", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //2.메모

        content = editText.getText().toString() ;
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();

        //3.전송버튼
        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        //Toast.makeText(getApplicationContext(), "선택한 일, 좌표 데이터베이스에 저장.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                ShowDBReal.class); // 다음 넘어갈 클래스 지정
                        intent.putExtra("position",p.getPosition());
                        intent.putExtra("content",content);
                        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }
                }
        );


    }
}
