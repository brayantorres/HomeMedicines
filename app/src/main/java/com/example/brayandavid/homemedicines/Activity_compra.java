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

import org.json.JSONObject;

public class Activity_compra extends AppCompatActivity {
    EditText txdni;
    EditText txnumerodecontacto;
    EditText txnombretitulartarjeta;
    EditText txnumerotarjeta;
    EditText txfechaexpiraciontarjeta;
    EditText txcodigoseguridadtarjeta;
    EditText txnombreciudad;
    EditText txdireccion1;
    Button btncomprar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        txdni = findViewById(R.id.txdni);
        txnumerodecontacto = findViewById(R.id.txnumerodecontacto);
        txnombreciudad = findViewById(R.id.txnombreciudad);
        txdireccion1 = findViewById(R.id.txdireccion1);
        txnombretitulartarjeta = findViewById(R.id.txnombretitulartarjeta);
        txnumerotarjeta = findViewById(R.id.txnumerotarjeta);
        txfechaexpiraciontarjeta = findViewById(R.id.txfechaexpiraciontarjeta);
        txcodigoseguridadtarjeta = findViewById(R.id.txcodigoseguridadtarjeta);
        btncomprar = findViewById(R.id.btncomprar);


        btncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskBuy taskBuy = new TaskBuy();
                Pay pay = new Pay();
                Buyer buyer = new Buyer();
                buyer.setContactPhone(txnumerodecontacto.getText().toString());
                buyer.setDniNumber(txdni.getText().toString());
                buyer.setEmailAddress(Security.getUsuario());
                buyer.setMerchantBuyerId("--");
                buyer.setFullName(Security.getUsuario());
                pay.setBuyer(buyer);
                shippingAddress adress = new shippingAddress();
                adress.setCity(txnombreciudad.getText().toString());
                adress.setCountry("Colombia");
                adress.setPhone(txnumerodecontacto.getText().toString());
                adress.setPostalCode("--");
                adress.setState("--");
                adress.setStreet1(txdireccion1.getText().toString());
                adress.setStreet2(txdireccion1.getText().toString());
                buyer.setShippingAddress(adress);
                pay.setShippingAddress(adress);
                Creditcard creditcard = new Creditcard();
                creditcard.setExpirationDate(txfechaexpiraciontarjeta.getText().toString());
                creditcard.setName(txnombretitulartarjeta.getText().toString());
                creditcard.setNumber(txnumerotarjeta.getText().toString());
                creditcard.setSecurityCode(txcodigoseguridadtarjeta.getText().toString());
                pay.setCreditcard(creditcard);
                pay.setPaymentMethod("PSE");
                pay.setUser(Security.getUsuario());
                pay.setTest(true);
                int code = TaskBuy.getCode();
                String result = null;
                try {
                    result = taskBuy.execute(pay).get();
                    JSONObject compra = new JSONObject(result);
                    Security.setPedido(compra.getString("message"));
                    String tracking = Security.getPedido();
                    Toast.makeText(Activity_compra.this, " ¡Compra Exitosa! ",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Activity_compra.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

}