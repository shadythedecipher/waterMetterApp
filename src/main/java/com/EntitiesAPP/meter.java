package com.EntitiesAPP;

import org.springframework.stereotype.Component;

@Component
public class meter {
    Long accNo;

    public meter() {
    }

    public meter(Long accNo, String ownerName, String phoneNumber, String readingType, String meterUser, String meterUserUsage) {
        this.accNo = accNo;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.readingType = readingType;
        this.meterUser = meterUser;
        this.meterUserUsage = meterUserUsage;
    }

    public Long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public String getMeterUser() {
        return meterUser;
    }

    public void setMeterUser(String meterUser) {
        this.meterUser = meterUser;
    }

    public String getMeterUserUsage() {
        return meterUserUsage;
    }

    public void setMeterUserUsage(String meterUserUsage) {
        this.meterUserUsage = meterUserUsage;
    }

    String ownerName;
    String phoneNumber;
    String readingType;
    String meterUser;
    String meterUserUsage;
}
