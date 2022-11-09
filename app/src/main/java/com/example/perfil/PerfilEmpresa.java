package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class PerfilEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_empresa);


        //Botón ATRÁS
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button Btatras = (Button) findViewById(R.id.Btatras);
        Btatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Ajustes.class);
                startActivity(intent);
            }
        });
    }
}