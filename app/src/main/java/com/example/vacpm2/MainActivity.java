/*
This is the main first page of the phone application
*/

package com.example.vacpm2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.vacpm2.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{

    // Used to load the 'vacpm2' library on application startup.
    static
    {
        System.loadLibrary("vacpm2");
    }

    private ActivityMainBinding binding;

    private String selectedMake, selectedModel;
    private TextView tvMakeSpinner, tvModelSpinner;
    private Spinner makeSpinner, modelSpinner;
    public ArrayAdapter<CharSequence> makeAdapter, modelAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make spinner initialization
        makeSpinner = findViewById(R.id.spinner_make);
        // Populate arrayAdapter using string array and a spinner layout that we will define
        makeAdapter = ArrayAdapter.createFromResource(this, R.array.array_make, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appear
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set the adapter to the spinner that populates the make spinner
        makeSpinner.setAdapter(makeAdapter);
        // when any item in the stateSpinner is selected
        makeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                // define model spinner but we will populate the options through the selection make
                modelSpinner = findViewById(R.id.spinner_model);
                // get/obtain the selected make
                selectedMake = makeSpinner.getSelectedItem().toString();

                int parentID = parent.getId();
                if (parentID == R.id.spinner_make) {
                    switch(selectedMake)
                    {

                        case "Select Your Vehicles Make":

                            Log.d("BULLSHIT", "BULLSHIT");

                            modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_model, R.layout.spinner_layout);

                            break;


                        case "Chevrolet": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Chevrolet, R.layout.spinner_layout);

                            break;
                        case "Dodge": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Dodge, R.layout.spinner_layout);
                            break;

                        default:  break;
                    }
                    Log.d("BULLSHIT", "BULLSHIT2");
                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    // populate the selected models according to the selected make
                    modelSpinner.setAdapter(modelAdapter);
                    // To get the selected model from the modelSpinner
                    modelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedModel = modelSpinner.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}


 //   }
/*
    public void openActivity2()
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);*/
    //}

