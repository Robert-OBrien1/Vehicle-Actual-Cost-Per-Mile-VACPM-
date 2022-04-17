package com.example.vacpm2;

public class Vehicle
{
    // attributes
    private String name;
    private String make;
    private String model;
    private String engine;
    private int year;
    private int mileage;

    // vehicle default constructor
    public Vehicle()
    {
         name = " ";
         make = " ";
         model = " ";
         engine = " ";
         year = 0;
         mileage = 0;
    }

    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Mutators ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
    public void setName(String name){ this.name = name; }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    public void setEngine(String engine) { this.engine = engine; }

    public void setYear(int year) { this.year = year; }

    public void setMileage(int mileage) { this.mileage = mileage; }

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

    public String getEngine()
    {
        return engine;
    }

    public int getYear()
    {
        return year;
    }

    public int getMileage()
    {
        return mileage;
    }
}
