package com.example.brayandavid.homemedicines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_compra extends AppCompatActivity {
EditText txnombrecompleto;
EditText txdni;
EditText txnumerodecontacto;
EditText txemaildecompra;
EditText txnombretitulartarjeta;
EditText txnumerotarjeta;
EditText txfechaexpiraciontarjeta;
EditText txcodigoseguridadtarjeta;
EditText txnombreciudad;
EditText txnombrepais;
EditText txnombreestado;
EditText txnumerodetelefonousuario;
EditText txcodigopostal;
EditText txdireccion1;
EditText txdireccion2;
Button btncomprar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        txnombrecompleto =  findViewById(R.id.txnombrecompleto);
        txdni =  findViewById(R.id.txdni);
        txnumerodecontacto =  findViewById(R.id.txnumerodecontacto);
        txemaildecompra =  findViewById(R.id.txemaildecompra);
        txnombretitulartarjeta = findViewById(R.id.txnombretitulartarjeta);
        txnumerotarjeta = findViewById(R.id.txnumerotarjeta);
        txfechaexpiraciontarjeta = findViewById(R.id.txfechaexpiraciontarjeta);
        txcodigoseguridadtarjeta = findViewById(R.id.txcodigoseguridadtarjeta);
        txnombreciudad = findViewById(R.id.txnombreciudad);
        txnombrepais = findViewById(R.id.txnombrepais);
        txnombreestado = findViewById(R.id.txnombreestado);
        txnumerodetelefonousuario = findViewById(R.id.txnumerodetelefonousuario);
        txcodigopostal = findViewById(R.id.txcodigopostal);
        txdireccion1 = findViewById(R.id.txdireccion1);
        txdireccion2 = findViewById(R.id.txdireccion2);
        btncomprar = findViewById(R.id.btncomprar);
        btncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
