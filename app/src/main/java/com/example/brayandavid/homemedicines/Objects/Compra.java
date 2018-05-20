package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by brayandavid on 20/05/2018.
 */

public class Compra {

    String contactPhone;
    String dniNumber;
    String emailAddress;
    String fullName;
    String merchantBuyerId;

    public Compra(String contactPhone, String dniNumbre, String emailAddress, String fullName, String merchantBuyerId) {
        this.contactPhone = contactPhone;
        this.dniNumber = dniNumbre;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.merchantBuyerId = merchantBuyerId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDniNumbre() {
        return dniNumber;
    }

    public void setDniNumbre(String dniNumbre) {
        this.dniNumber = dniNumbre;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMerchantBuyerId() {
        return merchantBuyerId;
    }

    public void setMerchantBuyerId(String merchantBuyerId) {
        this.merchantBuyerId = merchantBuyerId;
    }
}



