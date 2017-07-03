package com.example.pdg.e_bloodbank;

/**
 * Created by moon on 3/7/17.
 */

public class BankDetails {

    String bloodGroup,bankName,bankAddress,latitude,longitude,phoneNo;
    int units;


    public BankDetails(){


    }
    public BankDetails(String bankName,String bankAddress,String phoneNo,String bloodGroup,String latitude,String longitude,int units){
        this.bankAddress=bankAddress;
        this.bankName=bankName;
        this.bloodGroup=bloodGroup;
        this.latitude=latitude;
        this.longitude=longitude;
        this.phoneNo=phoneNo;
        this.units=units;

    }

    public int getUnits() {
        return units;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
