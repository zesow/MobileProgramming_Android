package com.example.myloggerreal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by YooMoonSang on 2016. 11. 11..
 */

public class DBHelperReal extends SQLiteOpenHelper {

    private static ArrayList<Integer> mArrayList;

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelperReal(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 DOING이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        position 정수형 컬럼, content 문자열 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
        db.execSQL("CREATE TABLE DOING6 (_id INTEGER PRIMARY KEY AUTOINCREMENT, position TEXT, content TEXT,longitude DOUBLE,latitude DOUBLE,pNumber INTEGER);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String position, String content,double longitude,double latitude,int pNumber) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        String s="INSERT INTO DOING6 VALUES(null, '" + position + "','" + content + "','" + longitude + "','" + latitude + "','" + pNumber + "');";
        Log.d("디버그",s);
        db.execSQL(s);
        db.close();
    }


    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM DOING6", null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + cursor.getString(2)
                    + " | "
                    + cursor.getDouble(3)
                    + " | "
                    + cursor.getDouble(4)
                    + " | "
                    + cursor.getInt(5)
                    + "\n";
        }

        return result;
    }

    public ArrayList<Integer> getPosition(){

        SQLiteDatabase db = getReadableDatabase();

        mArrayList=new ArrayList<Integer>();

        Cursor cursor = db.rawQuery("SELECT pNumber FROM DOING6", null);
        while(cursor.moveToNext()){
            mArrayList.add(cursor.getInt(0));
            //Log.d("디버그",mArrayList.get(i));

        }
        return mArrayList;
    }

    public String getContent(){

        SQLiteDatabase db = getReadableDatabase();
        String content="";
        Cursor cursor = db.rawQuery("SELECT content FROM DOING6", null);
        return content;
    }
}

