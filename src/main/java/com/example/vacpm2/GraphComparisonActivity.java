package com.example.vacpm2;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphComparisonActivity extends AppCompatActivity
{
    ArrayList<BarEntry> barArrayList;
    ArrayList<String> xAxisLables = new ArrayList<>();
    private ArrayList<Vehicle> myvehicles =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphcomparison_activity);

        myvehicles = this.getIntent().getExtras().getParcelableArrayList("Vehicles Array");

        setTitle("MPG Comparison");

        xAxisLables.add("");

        for(Vehicle vehicle:myvehicles)
        {
            xAxisLables.add(vehicle.getName());
        }


        BarChart barChart = findViewById(R.id.barChart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList,"Miles Per Gallon");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        //color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.BLACK);
        //setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLables));
        barChart.getDescription().setEnabled(true);
    }

    private void getData()
    {
        barArrayList = new ArrayList<>();

        for(int k = 0; k< myvehicles.size(); k++)
        {
            barArrayList.add(new BarEntry(k+1, myvehicles.get(k).getMpg())); // Jordan mpg

        }


    }
}