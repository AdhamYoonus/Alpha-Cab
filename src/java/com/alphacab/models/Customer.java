package com.alphacab.models;

public class Customer extends User
{
    private String name;
    private String contactNumber;
    private String email;

    public Customer()
    {
        
    }
    public Customer(String name, String contactNumber, String email) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }
    public Customer(String name, String contactNumber, String email, String username, String password, int accessLevel) {
        super(username, password, accessLevel);
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    
}