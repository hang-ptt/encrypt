package com.example.encrypt.dto;


public class UserDTO {
    String phoneNumber;
    String region;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
