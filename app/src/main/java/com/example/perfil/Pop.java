package com.example.perfil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class Pop extends Activity {

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

//------------PopUp---------------------------------------------------------------------------------------
        setContentView(R.layout.popwindow);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //getWindow().setLayout((int)(width*.8),(int)(height*.6)); //determina las dimensiones del PopUp
        getWindow().setLayout(width,height);

//------------------------------------------------------------------------------------
        //Botón ATRÁS
        Button Batras = (Button) findViewById(R.id.Batras);
        Batras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
