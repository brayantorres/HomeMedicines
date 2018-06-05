package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by Kevin Ortiz on 6/3/2018.
 */

public class Pay {
    Buyer buyer;
    Creditcard creditcard;
    private String paymentMethod;
    shippingAddress shippingAddress;
    String user;
    Boolean test;

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public Pay() {
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Creditcard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(Creditcard creditcard) {
        this.creditcard = creditcard;
    }

    public com.example.brayandavid.homemedicines.Objects.shippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(com.example.brayandavid.homemedicines.Objects.shippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
