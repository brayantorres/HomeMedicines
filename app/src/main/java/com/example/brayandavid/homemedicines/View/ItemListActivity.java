package com.example.brayandavid.homemedicines.View;

import android.media.Image;
import android.support.v4.app.FragmentManager;

/**
 * Created by Kevin Ortiz on 11/03/2018.
 */

class ItemListActivity {
    String Nombre;
    String Descripción;
    String Caracteristicas;
    Integer cantidad;
    Image imagen;

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public FragmentManager getSupportFragmentManager() {
        return null;
    }
}
