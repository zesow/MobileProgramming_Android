package com.example.myloggerreal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Statistic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);

        PieChart pieChart = (PieChart) findViewById(R.id.chart);

        final DBHelperReal dbHelper = new DBHelperReal(getApplicationContext(), "doing6.db", null, 1);

        ArrayList<Integer> mArrayList;

        //Log.d("디버그","여기까지");

        mArrayList=dbHelper.getPosition();
        //Log.d("디버그","여기까지2");
        int p0=0,p1=0,p2=0,p3=0,p4=0,p5=0,p6=0;
        //Log.d("디버그","여기까3");
        Log.d("디버그","----------------");
        for(int i=0;i<mArrayList.size();i++){
            int position=mArrayList.get(i);

            if(position==0){
                p0++;
            }
            else if(position==1){
                p1++;
            }
            else if(position==2){
                p2++;
            }
            else if(position==3){
                p3++;
            }
            else if(position==4){
                p4++;
            }
            else if(position==5){
                p5++;
            }
            else
                p6++;
            }
        String s= p0+" "+p1+" "+p2+" "+p3+" "+p4+" "+p5+" "+p6;
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

        ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(p0,0));
        entries.add(new Entry(p1,1));
        entries.add(new Entry(p2,2));
        entries.add(new Entry(p3,3));
        entries.add(new Entry(p4,4));
        entries.add(new Entry(p5,5));
        entries.add(new Entry(p6,6));

        PieDataSet dataset = new PieDataSet(entries," ");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("밥먹기");
        labels.add("카페가기");
        labels.add("피씨방");
        labels.add("노래방");
        labels.add("당구장");
        labels.add("영화관");
        labels.add("술집");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        pieChart.setDescription("Description");
        pieChart.setData(data);

        pieChart.animateY(5000);

        pieChart.saveToGallery("/sd/mychart.jpg", 85); // 85 is the quality of the image



    }
}
