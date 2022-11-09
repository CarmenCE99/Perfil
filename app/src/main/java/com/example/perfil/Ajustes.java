package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        //Botón del perfil personal
        Button Bpersonal = (Button) findViewById(R.id.Bpersonal);
        Bpersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent intent = new Intent (vi.getContext(), PerfilPersonal.class);
                startActivity(intent);
            }
        });

        //Botón del perfil de empresa
        Button Bempresa = (Button) findViewById(R.id.Bempresa);
        Bempresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vie) {
                Intent intent = new Intent (vie.getContext(), PerfilEmpresa.class);
                startActivity(intent);
            }
        });

        //Botón ATRÁS
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonAtras = (Button) findViewById(R.id.butonAtras);
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}