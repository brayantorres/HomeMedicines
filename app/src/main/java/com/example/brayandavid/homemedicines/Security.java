package com.example.brayandavid.homemedicines;

/**
 * Created by Kevin Ortiz on 16/03/2018.
 */

public class Security {

    private static String token;
    private static String usuario;
    private static String pedido;
    private static String contraseña;

    public static String getContraseña() {
        return contraseña;
    }

    public static void setContraseña(String contraseña) {
        Security.contraseña = contraseña;
    }

    public static String getPedido() {
        return pedido;
    }

    public static void setPedido(String pedido) {
        Security.pedido = pedido;
    }

    public Security() {
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Security.usuario = usuario;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Security.token = token;
    }

}
