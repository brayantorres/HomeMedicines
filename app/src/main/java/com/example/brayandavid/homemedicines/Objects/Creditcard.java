package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by brayandavid on 20/05/2018.
 */

public class Creditcard {

    String expirationDate;
    String name;
    String number;
    String securityCode;
    String paymentMethod;

    public Creditcard(String expirationDate, String name, String number, String securityCode, String paymentMethod) {
        this.expirationDate = expirationDate;
        this.name = name;
        this.number = number;
        this.securityCode = securityCode;
        this.paymentMethod = paymentMethod;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
