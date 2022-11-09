package com.example.perfil;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.perfil.databinding.ActivityTelefonoBinding;

public class Telefono extends AppCompatActivity {

    //private AppBarConfiguration appBarConfiguration;
    private ActivityTelefonoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button cbtn = (Button)findViewById(R.id.cbtn);
        TextView nmbr = (TextView) findViewById(R.id.nmbr);

        binding = ActivityTelefonoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar2);

        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_telefono);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);*/

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btras = (Button) findViewById(R.id.btras);
        btras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        binding.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                cbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String num = nmbr.getText().toString(); // Guardamos el numero de telefono en un string
                        if(num!="") { // Verificamos si el numero de telefono no esta vacio
                            Uri number = Uri.parse("tel:" + num); // Creamos una uri con el numero de telefono
                            Intent dial = new Intent(Intent.ACTION_DIAL, number); // Creamos una llamada al Intent de llamadas
                            startActivity(dial); // Ejecutamos el Intent
                        }else{ // Si el numero esta vacio
                            // Mostramos una alerta de que debemos escribir un numero
                            AlertDialog.Builder alert1 = new AlertDialog.Builder(Telefono.this);
                            alert1.setTitle("No hay numero"); // Titulo de la alerta
                            alert1.setMessage("Debes escribir un Numero!"); // Contenido de la alerta
                            alert1.show(); // mostrar alerta
                        }
                    }
                });
            }
        });
    }

    /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_telefono);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}