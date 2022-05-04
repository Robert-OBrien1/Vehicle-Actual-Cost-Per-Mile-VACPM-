package com.example.vacpm2;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable
{
    // attributes
    private String name;
    private String make;
    private String model;
    private int year;
    private int mpg;
    private String insuranceCost, loanLeaseCost, maintenance, miscellaneous;

    // vehicle default constructor
    public Vehicle()
    {
         name = " ";
         make = " ";
         model = " ";
         year = 0;
         mpg = 0;
         insuranceCost = loanLeaseCost = maintenance = miscellaneous =" ";
    }

    protected Vehicle(Parcel in)
    {
        name = in.readString();
        make = in.readString();
        model = in.readString();
        year = in.readInt();
        mpg = in.readInt();
        insuranceCost = in.readString();
        loanLeaseCost = in.readString();
        maintenance = in.readString();
        miscellaneous = in.readString();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in)
        {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size)
        {
            return new Vehicle[size];
        }
    };

    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Mutators ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
    public void setName(String name){ this.name = name; }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    public void setYear(int year) { this.year = year; }

    public void setMpg(int mpg) { this.mpg = mpg; }

    public void setInsuranceCost(String insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public void setLoanLeaseCost(String loanLeaseCost) {
        this.loanLeaseCost = loanLeaseCost;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public void setMiscellaneous(String miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Accessors ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
    public String getName() { return name; }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }

    public int getMpg() { return mpg; }
    public String getInsuranceCost() {
        return insuranceCost;
    }

    public String getLoanLeaseCost(){return loanLeaseCost;}

    public String getMaintenance() {
        return maintenance;
    }

    public String getMiscellaneous() {
        return miscellaneous;
    }


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(make);
        parcel.writeString(model);
        parcel.writeInt(year);
        parcel.writeInt(mpg);
        parcel.writeString(insuranceCost);
        parcel.writeString(loanLeaseCost);
        parcel.writeString(maintenance);
        parcel.writeString(miscellaneous);
    }




}
