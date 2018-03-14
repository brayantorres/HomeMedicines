package com.example.brayandavid.homemedicines.View.dummy;

import com.example.brayandavid.homemedicines.View.Producto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */

public class ProductResponseDto implements Serializable {

    private  List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
