package com.example.brayandavid.homemedicines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskBuy;
import com.example.brayandavid.homemedicines.Objects.Buyer;
import com.example.brayandavid.homemedicines.Objects.Creditcard;
import com.example.brayandavid.homemedicines.Objects.Pay;
import com.example.brayandavid.homemedicines.Objects.shippingAddress;

import java.util.concurrent.ExecutionException;

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
                TaskBuy taskBuy = new TaskBuy();
                Pay pay = new Pay();
                Buyer buyer = new Buyer();
                buyer.setContactPhone(buyer.getContactPhone());
                buyer.setDniNumber(buyer.getDniNumber());
                buyer.setEmailAddress(buyer.getEmailAddress());
                buyer.setShippingAddress(buyer.getShippingAddress());
                buyer.setMerchantBuyerId(buyer.getMerchantBuyerId());
                buyer.setFullName(buyer.getFullName());
                pay.setBuyer(buyer);
                shippingAddress adress = new shippingAddress();
                adress.setCity(adress.getCity());
                adress.setCountry(adress.getCountry());
                adress.setPhone(adress.getPhone());
                adress.setPostalCode(adress.getPostalCode());
                adress.setState(adress.getState());
                adress.setStreet1(adress.getStreet1());
                adress.setStreet2(adress.getStreet2());
                pay.setShippingAddress(adress);
                Creditcard creditcard = new Creditcard();
                creditcard.setExpirationDate(creditcard.getExpirationDate());
                creditcard.setName(creditcard.getName());
                creditcard.setNumber(creditcard.getNumber());
                creditcard.setSecurityCode(creditcard.getSecurityCode());
                pay.setCreditcard(creditcard);
                pay.setPaymentMethod(pay.getPaymentMethod());
                pay.setUser(pay.getUser());
                int code = TaskBuy.getCode();
                String result = null;
                try {
                    result = taskBuy.execute(pay).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                Toast.makeText(Activity_compra.this, code+" ¡Compra Exitosa! ",
                            Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_compra.this,MapsActivity.class );
                startActivity(intent);

                Intent map = new Intent(Activity_compra.this,MapsActivity.class);
                startActivity(map);

            }
        });
    }

}
