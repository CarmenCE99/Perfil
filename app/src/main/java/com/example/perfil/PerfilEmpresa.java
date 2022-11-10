package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class PerfilEmpresa extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_empresa);

        //BOTÓN GUARDAR
        Button Bguardar = (Button) findViewById(R.id.Bguardar);
        // Así se enlaza el botón a el método
        Bguardar.setOnClickListener(this);

        //Botón ATRÁS
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button Btatras = (Button) findViewById(R.id.Btatras);
        Btatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Ajustes.class);
                startActivity(intent);
            }
        });


//------GUARDOS LOS TEXTVIEWS EN VARIABLES-------------------------------------------
        TextView Tnombre = (TextView) findViewById(R.id.nombre);
        String Nombre = (String) Tnombre.getText();

        TextView Tapellidos = (TextView) findViewById(R.id.apellidos);
        String Apellidos = (String) Tapellidos.getText();

        TextView Tbiografía = (TextView) findViewById(R.id.biografía);
        String Biografía = (String) Tbiografía.getText();

        TextView Tempresa = (TextView) findViewById(R.id.empresa);
        String Empresa = (String) Tempresa.getText();

        TextView Temail = (TextView) findViewById(R.id.email);
        String Email = (String) Temail.getText();

        TextView Ttelefono = (TextView) findViewById(R.id.telefono);
        String Telefono = (String) Ttelefono.getText();

        TextView Tdireccion = (TextView) findViewById(R.id.direccion);
        String Direccion = (String) Tdireccion.getText();

        TextView TWeb = (TextView) findViewById(R.id.Web);
        String Web = (String) TWeb.getText();

        TextView TFacebook = (TextView) findViewById(R.id.Facebook);
        String Facebook = (String) TFacebook.getText();

        TextView TInstagram = (TextView) findViewById(R.id.Instagram);
        String Instagram = (String) TInstagram.getText();

        TextView TTwitter = (TextView) findViewById(R.id.Twitter);
        String Twitter = (String) TTwitter.getText();



        //IMPRIME EN UN TEXTVIEW EL CONTENIDO DE UNA VARIABLE GUARDADA
        setContentView(R.layout.activity_ajustes_empresa);
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Nombre);

    }

    //https://es.stackoverflow.com/questions/13399/guardar-un-valor-en-android

    @Override
    public void onClick(View v) {
        // Método necesario de implementar
        // Para saber que botón se pulsa en caso de tener más de uno
        switch (v.getId()) {
            case R.id.Bguardar:
                // Añadir aquí el código que quieras que funcione cuando     se presione el botón
                break;
        }
    }
}