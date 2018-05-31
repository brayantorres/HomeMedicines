package com.example.brayandavid.homemedicines.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.brayandavid.homemedicines.Conection.TaskImages;
import com.example.brayandavid.homemedicines.Conection.TaskProducts;
import com.example.brayandavid.homemedicines.Objects.Product;
import com.example.brayandavid.homemedicines.R;

import java.util.ArrayList;
import java.util.List;

public class AgregarActivity extends AppCompatActivity {

    ListView milista;
    Button cart;
    TextView cantidadArticulos;
    List<Product> lista_compras = new ArrayList<>();
    List<Product> articulos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        cantidadArticulos = findViewById(R.id.tvCantArticulos);
        cart = findViewById(R.id.btnCart);

        milista = findViewById(R.id.MyList);


        TaskProducts task = new TaskProducts(this);
        try {
            List<Product> products = task.execute().get();

            ArticuloAdapter articuloAdapter = new ArticuloAdapter();
            milista.setAdapter(articuloAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }




        milista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AgregarActivity.this, DetalleActivity.class);
                intent.putExtra("producto", articulos.get(i));
                startActivityForResult(intent, 100);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgregarActivity.this, CartActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == 101) {
                Product resultArticulo = (Product) data.getSerializableExtra("returnArticulo");
                lista_compras.add(resultArticulo);
                cantidadArticulos.setText("(" + lista_compras.size() + ")");
                            }
            if (resultCode == 102) {
                ArrayList<Product> resultCarrito = (ArrayList<Product>) data.getSerializableExtra("returnCarrito");
                lista_compras.clear();
                for (Product articulo : resultCarrito) {
                    lista_compras.add(articulo);
                }
                cantidadArticulos.setText("(" + lista_compras.size() + ")");
            }
        }
    }

    public class ArticuloAdapter extends ArrayAdapter<Product> {
        ArticuloAdapter() {
            super(AgregarActivity.this, R.layout.list, articulos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View vista = getLayoutInflater().inflate(R.layout.list, parent, false);
            TaskProducts task = new TaskProducts(AgregarActivity.this);
            try {
                List<Product> products = task.execute().get();

                         } catch (Exception e) {
                e.printStackTrace();
            }
            Product miarticulo = articulos.get(position);

            TextView titulo = vista.findViewById(R.id.tvTitulo);
            titulo.setText(miarticulo.getName());

            TextView subtitulo = vista.findViewById(R.id.ev_name);
            subtitulo.setText(miarticulo.getDescription());

            TextView precio = vista.findViewById(R.id.ev_txt);
            precio.setText(Double.toString(miarticulo.getEachPrice()));

            ImageView imagen = vista.findViewById(R.id.iv_avatar);
            TaskImages taskImages = new TaskImages(imagen);
            taskImages.execute(miarticulo);
            return vista;
        }
    }
}
