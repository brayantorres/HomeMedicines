package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by Kevin Ortiz on 6/4/2018.
 */

public class Item  {
    Product product;
    int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Item() {
    }
}
