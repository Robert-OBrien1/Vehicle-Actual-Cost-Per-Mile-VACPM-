package com.example.vacpm2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.io.Serializable;



public class MainActivity extends AppCompatActivity
{
    // instance of addvehicle button on page 1
    ImageButton addvehiclebutton, graphcomparisonbutton;
    String year, make, model;
    // array list of vehicles
    public static ArrayList<Vehicle> myvehicles = new ArrayList<Vehicle>();
//    public static Vehicle mycar = new Vehicle();
//    public static Vehicle mycar2 = new Vehicle();
//    public static Vehicle mycar3 = new Vehicle();



    // Used to load the 'vacpm2' library on application startup.
    static
    {
        System.loadLibrary("vacpm2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getvehiclesfromAddactivity();
        fillspinner();

        // connect addvehicle button variable to addvehicle button on page 1
        addvehiclebutton = (ImageButton) findViewById(R.id.addvehiclebutton);
        // when click addvehicle button, open AddvehicleActivity (Add vehicle page)
        addvehiclebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openAddvehicleActivity();
            }
        });

        graphcomparisonbutton = (ImageButton) findViewById(R.id.graphbutton);
        graphcomparisonbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){openGraphComparisonActivity();}
        });

    }

    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ ↓ Functions  ↓ ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

    // Name: openAddvehicleActivity
    // Parameters: None
    // Description: open add vehicle page upon add vehicle button click
    // Returns : None
    public void openAddvehicleActivity()
    {
        Intent intent = new Intent(this, AddvehicleActivity.class);
        intent.putExtra("Vehicles Array",myvehicles);
        startActivity(intent);
    }

    public void openGraphComparisonActivity()
    {

        Intent intent = new Intent(this, GraphComparisonActivity.class);
        intent.putExtra("Vehicles Array",myvehicles);
        startActivity(intent);
    }

    public void getvehiclesfromAddactivity()
    {
        try
        {
            myvehicles = this.getIntent().getExtras().getParcelableArrayList("Vehicles Array");
            Log.d("Size of Array", String.valueOf(myvehicles.size()));
            for(Vehicle car: myvehicles)
            {
                Log.d("Bullshit",car.getName().toString());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void fillspinner()
    {
        ArrayList<String> strings = new ArrayList<String>();
        for(Vehicle vehicle:myvehicles)
        {
            strings.add(vehicle.getName());
        }

        Spinner spinner = findViewById(R.id.listofvehiclesspinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strings);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


    }
    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ ↑ Functions  ↑ ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
};





