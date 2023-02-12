package com.alphacab.models;

public class Driver extends User 
{
    private String driverName;
    private String licenseNumber;
    private String carType;
    private String carModel;
    
    public Driver()
    {
        
    }

    public Driver(String driverName, String licenseNumber, String carType, String carModel) {
        this.driverName = driverName;
        this.licenseNumber = licenseNumber;
        this.carType = carType;
        this.carModel = carModel;
    }

    public Driver(String driverName, String licenseNumber, String carType, String carModel, String username, String password, int accessLevel) {
        super(username, password, accessLevel);
        this.driverName = driverName;
        this.licenseNumber = licenseNumber;
        this.carType = carType;
        this.carModel = carModel;
    }
    
    
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    
}