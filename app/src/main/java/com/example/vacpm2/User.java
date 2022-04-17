package com.example.vacpm2;

public class User
{
    // attributes
    private Vehicle vehicle;


    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Mutators ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    // ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Accessors ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
    public Vehicle getVehicle()
    {
        return vehicle;
    }
}

