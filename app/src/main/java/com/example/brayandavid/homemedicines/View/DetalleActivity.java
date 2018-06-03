package com.example.brayandavid.homemedicines.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskImages;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getIntent();
        try {


            final Product thisArticulo = (Product) getIntent().getSerializableExtra("articulo");
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
                    intent.putExtra("returnArticulo", thisArticulo);
                    setResult(101, intent);
                    Toast.makeText(DetalleActivity.this, "¡Agregado! ",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
            });
            thisTitulo.setText(thisArticulo.getName());
            thisSubtitulo.setText(thisArticulo.getDescription());
            thisPrecio.setText(Double.toString(thisArticulo.getEachPrice()));
            TaskImages taskImages = new TaskImages(firstImage);
            taskImages.execute(thisArticulo);
            thiscategory.setText((CharSequence) thisArticulo.getCategory());
            thisCharacteristic.setText(thisArticulo.getMedicalCharacteristics());
            thisDescripcion.setText(thisArticulo.getVolume());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    }

