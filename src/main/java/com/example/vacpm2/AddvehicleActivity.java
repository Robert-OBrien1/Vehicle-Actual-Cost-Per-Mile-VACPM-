package com.example.vacpm2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.vacpm2.databinding.ActivityMainBinding;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class AddvehicleActivity extends AppCompatActivity
{
    static int mpg;
    private Button submitvehicle;
    private ActivityMainBinding binding;
    private String selectedMake, selectedModel, selectedYear, selectedName;
    private Spinner makeSpinner, modelSpinner, yearSpinner;
    private ArrayAdapter<CharSequence> makeAdapter, modelAdapter, yearAdapter;
    String maketext, modeltext, yeartext, insurance, loanLease, maintenance, miscellaneous;
    private ArrayList <String> VehArr = new ArrayList<String>();
    private ArrayList<Vehicle> myvehicles =new ArrayList<>();
    private Intent intentvehicles = getIntent();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addvehicle_activity);
        // set top page title
        setTitle("Add a Vehicle");

        // get myvehicles ArrayList from MainActivity
        myvehicles = this.getIntent().getExtras().getParcelableArrayList("Vehicles Array");


        // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ ↓ Year Spinner ↓ ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
        // year spinner initialization
        yearSpinner = findViewById(R.id.spinner_year);
        // Populate arrayAdapter using string array and a spinner layout that we will define
        yearAdapter = ArrayAdapter.createFromResource(this, R.array.array_year, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appear
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set the adapter to the spinner that populates the year spinner
        yearSpinner.setAdapter(yearAdapter);
        // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ ↑ Year Spinner ↑ ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

        // ♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦

        // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ ↓ Make Spinner ↓ ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
        // make spinner initialization
        makeSpinner = findViewById(R.id.spinner_make);
        // Populate arrayAdapter using string array and a spinner layout that we will define
        makeAdapter = ArrayAdapter.createFromResource(this, R.array.array_make, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appear
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set the adapter to the spinner that populates the make spinner
        makeSpinner.setAdapter(makeAdapter);
        // when any item in the stateSpinner is selected
        makeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
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
                            modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_model, R.layout.spinner_layout);
                            break;
                        case "Audi": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Audi, R.layout.spinner_layout);
                            break;
                        case "BMW": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_BMW, R.layout.spinner_layout);
                            break;
                        case "Buick": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Buick, R.layout.spinner_layout);
                            break;
                        case "Cadillac": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Cadillac, R.layout.spinner_layout);
                            break;
                        case "Chevrolet": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Chevrolet, R.layout.spinner_layout);
                            break;
                        case "Chrysler": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Chrysler, R.layout.spinner_layout);
                            break;
                        case "Dodge": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Dodge, R.layout.spinner_layout);
                            break;
                        case "Fiat": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Fiat, R.layout.spinner_layout);
                            break;
                        case "Ford": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Ford, R.layout.spinner_layout);
                            break;
                        case "Geo": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Geo, R.layout.spinner_layout);
                            break;
                        case "GMC": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_GMC, R.layout.spinner_layout);
                            break;
                        case "Honda": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Honda, R.layout.spinner_layout);
                            break;
                        case "Hyundai": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Hyundai, R.layout.spinner_layout);
                            break;
                        case "Jaguar": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Jaguar, R.layout.spinner_layout);
                            break;
                        case "Jeep": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Jeep, R.layout.spinner_layout);
                            break;
                        case "Kia": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Kia, R.layout.spinner_layout);
                            break;
                        case "LandRover": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_LandRover, R.layout.spinner_layout);
                            break;
                        case "Lexus": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Lexus, R.layout.spinner_layout);
                            break;
                        case "Lincoln": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Lincoln, R.layout.spinner_layout);
                            break;
                        case "Mazda": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Mazda, R.layout.spinner_layout);
                            break;
                        case "MercedesBenz": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_MercedesBenz, R.layout.spinner_layout);
                            break;
                        case "Nissan": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Nissan, R.layout.spinner_layout);
                            break;
                        case "Porsche": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Porsche, R.layout.spinner_layout);
                            break;
                        case "Ram": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Ram, R.layout.spinner_layout);
                            break;
                        case "Subaru": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Subaru, R.layout.spinner_layout);
                            break;
                        case "Tesla": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Tesla, R.layout.spinner_layout);
                            break;
                        case "Toyota": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Toyota, R.layout.spinner_layout);
                            break;
                        case "Volkswagen": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Volkswagen, R.layout.spinner_layout);
                            break;
                        case "Volvo": modelAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Volvo, R.layout.spinner_layout);
                            break;
                        default:  break;
                    }
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

        // connect addvehicle button variable to addvehicle button on page 1
        submitvehicle = (Button) findViewById(R.id.button_submit);
        // when click addvehicle button, open AddvehicleActivity (Add vehicle page)
        submitvehicle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final EditText setName = (EditText) findViewById(R.id.editTextTextPersonName2);
                final EditText setInsurance = (EditText) findViewById(R.id.AddInsurance);
                final EditText setLoanLease = (EditText) findViewById(R.id.AddLoanLease);
                final EditText setMaintenance = (EditText) findViewById(R.id.AddMaintenance);
                final EditText setMiscellaneous = (EditText) findViewById(R.id.AddMiscellaneous);



                yeartext = yearSpinner.getSelectedItem().toString();
                maketext = makeSpinner.getSelectedItem().toString();
                modeltext = modelSpinner.getSelectedItem().toString();
                selectedName = (String) setName.getText().toString();
                insurance = (String) setInsurance.getText().toString();
                loanLease = (String) setLoanLease.getText().toString();
                maintenance = (String) setMaintenance.getText().toString();
                miscellaneous = (String) setMiscellaneous.getText().toString();


                try {
                    submitvehicle(selectedName,yeartext, maketext, modeltext, insurance, loanLease, maintenance, miscellaneous);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                try {
//                    save(v);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }

    public void submitvehicle(String nickName,String yeartext, String maketext, String modeltext, String insurance, String loanLease, String maintenance, String miscellaneous) throws IOException {
        int intyear;

        Vehicle newveh = new Vehicle();

        Intent i = new Intent(this, MainActivity.class);


        // create new vehicle object
        newveh.setYear(Integer.parseInt(yeartext));
        newveh.setMake(maketext);
        newveh.setModel(modeltext);
        newveh.setName(nickName);
        newveh.setInsuranceCost(insurance);
        newveh.setLoanLeaseCost(loanLease);
        newveh.setMaintenance(maintenance);
        newveh.setMiscellaneous(miscellaneous);


        // Robert's Truck
        if(newveh.getYear() == 2011 & newveh.getMake().equals("Ram") & newveh.getModel().equals("1500 2WD")) newveh.setMpg(14);

        // Jordan's Truck
        else if(newveh.getYear() == 2019 && newveh.getMake().equals("Ram") && newveh.getModel().equals("1500 4WD")) newveh.setMpg(15);
        // James' Truck
        else if(newveh.getYear() == 2020 && newveh.getMake().equals("Ford") && newveh.getModel().equals("F150 Pickup 4WD")) newveh.setMpg(16);
        // Dylan's Car
        else if(newveh.getYear() == 2012 && newveh.getMake().equals("Nissan") && newveh.getModel().equals("Altima")) newveh.setMpg(23);
        // The best vehicle of them all
        else if(newveh.getYear() == 1994 && newveh.getMake().equals("Geo") && newveh.getModel().equals("Metro")) newveh.setMpg(31);
        // Random picks
        else if(newveh.getYear() == 1984 && newveh.getMake().equals("Chevrolet") && newveh.getModel().equals("K20 Pickup 4WD")) newveh.setMpg(16);
        else if(newveh.getYear() == 2006 && newveh.getMake().equals("Audi") && newveh.getModel().equals("A8")) newveh.setMpg(16);
        else if(newveh.getYear() == 2008 && newveh.getMake().equals("BMW") && newveh.getModel().equals("M3")) newveh.setMpg(14);
        else if(newveh.getYear() == 2018 && newveh.getMake().equals("Cadillac") && newveh.getModel().equals("M3")) newveh.setMpg(22);
        else if(newveh.getYear() == 2016 && newveh.getMake().equals("Dodge") && newveh.getModel().equals("Challenger")) newveh.setMpg(16);
        mpg = newveh.getMpg();
        save();
        myvehicles.add(newveh);
        i.putExtra("Vehicles Array",myvehicles);
        startActivity(i);
    }
    public void save() throws IOException
    {
        VehArr.add(yeartext+","+maketext+","+modeltext+ " " +mpg + " "+ insurance + " "+ loanLease + " " + maintenance + " "+ miscellaneous+'\n');
        File dataFile = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        Log.d("dflkj",dataFile.toString());
        File file = new File(dataFile, "data.txt");
        FileWriter writer = new FileWriter(file, true);
        for (int i = 0; i < VehArr.size(); i++)
        {
            writer.append(VehArr.get(i).toString());
        }
        writer.close();
    }
}

