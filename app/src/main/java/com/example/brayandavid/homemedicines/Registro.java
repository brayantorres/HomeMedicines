package com.example.brayandavid.homemedicines;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.brayandavid.homemedicines.Conection.TaskUserRegistry;
import com.example.brayandavid.homemedicines.Objects.User;
import com.example.brayandavid.homemedicines.View.ServicesListActivity;

import java.util.concurrent.ExecutionException;


public class Registro extends AppCompatActivity {
    private EditText gender;
    private EditText password;
    private EditText user;
    private EditText name;
    private EditText lasName;
    private EditText age;
    private EditText type;
    private EditText workingHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        gender = (EditText) findViewById(R.id.txtgender);
        password = (EditText) findViewById(R.id.txtpassword);
        user = (EditText) findViewById(R.id.txtuser);
        name = (EditText) findViewById(R.id.txtname);
        lasName = (EditText) findViewById(R.id.txtlastname);
        age = (EditText) findViewById(R.id.txtage);
        type = (EditText) findViewById(R.id.txt_type);
        workingHours = (EditText) findViewById(R.id.txt_hours);

    }

    public void btn_Registro_Click(View v) {

        ProgressDialog progressDialog = ProgressDialog.show(Registro.this, "Espera", "Processing...", false);
        progressDialog.dismiss();
        TaskUserRegistry usersRegistry = new TaskUserRegistry();
        User userRegistry = new User();
        userRegistry.setAge(age.getId());
        userRegistry.setGender(gender.getText().toString());
        userRegistry.setName(name.getText().toString());
        userRegistry.setLasName(lasName.getText().toString());
        userRegistry.setPassword((password.getText().toString()));
        userRegistry.setType(type.getText().toString());
        userRegistry.setUser(user.getText().toString());
        userRegistry.setWorkingHours(workingHours.getText().toString());

        try {
            String resul = usersRegistry.execute(userRegistry).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int code = TaskUserRegistry.getCode();
        if (code == 200) {
            //progressDialog = ProgressDialog.show(this, "Congratulations", "Registro exitoso, ahora puedes ingresar",false );
            Intent i = new Intent(Registro.this, ServicesListActivity.class);
            startActivity(i);
            finish();
        }else {
           // progressDialog = ProgressDialog.show(this, "Error", "Algo salió mal, por favor vuelve a intentar", false);
            Intent i = new Intent(Registro.this, Registro.class);
            startActivity(i);
            finish();
        }
    }


}

