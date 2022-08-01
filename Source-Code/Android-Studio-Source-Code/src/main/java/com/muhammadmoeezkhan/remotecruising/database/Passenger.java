package com.muhammadmoeezkhan.remotecruising.database;

import com.google.gson.annotations.SerializedName;

public class Passenger {

    //All Fields of the Database

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("passport_number")
    private int passportNumber;

    @SerializedName("birthdate")
    private String birthDate;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;


    public Passenger(String firstName, String lastName, int passportNumber, String birthDate, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.birthDate = birthDate;
        this.city = city;
        this.state = state;
    }

    public int getId() {

        return id;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public int getPassportNumber() {

        return passportNumber;
    }

    public String getBirthDate() {

        return birthDate;
    }

    public String getCity() {

        return city;
    }

    public String getState() {

        return state;
    }

    @Override
    public String toString() {
        return  "Passenger ID : " + id + "\r\n" +
                "First Name : " + firstName + "\r\n" +
                "Last Name : " + lastName + "\r\n" +
                "Passport Number : " + passportNumber + "\r\n" +
                "Birth Date : " + birthDate + "\r\n" +
                "Location : " + city +  ", " + state
                ;
    }
}
