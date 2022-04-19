package com.example.shoppingapp.models;

public class User {
    public String fullName, emailAddress, shippingAddress, phoneNumber, registerPassword;

    public User (String mfullName, String memailAddress, String mshippingAddress, String mphoneNumber, String mregisterPassword )
    {
        this.fullName = mfullName;
        this.emailAddress = memailAddress;
        this.shippingAddress = mshippingAddress;
        this.phoneNumber = mphoneNumber;
        this.registerPassword = mregisterPassword;
    }
}
