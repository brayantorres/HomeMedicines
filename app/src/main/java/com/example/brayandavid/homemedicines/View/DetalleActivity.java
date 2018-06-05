package com.example.brayandavid.homemedicines.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskAddCar;
import com.example.brayandavid.homemedicines.Conection.TaskImages;
import com.example.brayandavid.homemedicines.Objects.Item;
import com.example.brayandavid.homemedicines.Objects.Product;
import com.example.brayandavid.homemedicines.R;

public class DetalleActivity extends AppCompatActivity {

    TextView thisTitulo;
    TextView thisSubtitulo;
    TextView thisPrecio;
    TextView thiscategory;
    TextView thisCharacteristic;
    ImageView firstImage;
    TextView thisDescripcion;
    Button agregar;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getIntent();
        try {


            product = (Product) getIntent().getSerializableExtra("articulo");
            thisTitulo = findViewById(R.id.tvThisTitulo);
            thisSubtitulo = findViewById(R.id.tvThisSubtitulo);
            thisPrecio = findViewById(R.id.tvThisPrecio);
            firstImage = findViewById(R.id.ivFirstImage);
            thisDescripcion = findViewById(R.id.tvThisDescripcion);
            agregar = findViewById(R.id.btnAgregar);
            thisCharacteristic = findViewById(R.id.tvcategoria);
            thiscategory = findViewById(R.id.tvThisvolumen);

            agregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("returnArticulo", product);
                    setResult(101, intent);
                    Toast.makeText(DetalleActivity.this, "¡Agregado! ",
                            Toast.LENGTH_LONG).show();
                    TaskAddCar taskAddCar = new TaskAddCar();
                    Item item = new Item();
                    item.setProduct(product);
                    item.setCantidad(1);
                   int code=  taskAddCar.getCode();
                    String  resul = null;
                    try {

                        resul = taskAddCar.execute(item).get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thisTitulo.setText(product.getName());
            thisSubtitulo.setText(product.getDescription());
            thisPrecio.setText(Double.toString(product.getEachPrice()));
            TaskImages taskImages = new TaskImages(firstImage);
            taskImages.execute(product);
            thiscategory.setText((CharSequence) product.getCategory());
            thisCharacteristic.setText(product.getMedicalCharacteristics());
            thisDescripcion.setText(product.getVolume());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    }

