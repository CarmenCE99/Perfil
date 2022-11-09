package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button B = (Button) findViewById(R.id.Btarjeta);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Pop.class));
            }
        });

//---------------------------------------------------------------------------------------------------------------------

        //Código: https://codea.app/blog/lanzar-un-link
        //Botón Página Web
            Button Bweb = (Button) findViewById(R.id.Bweb);
            String url = "https://llorenteod.com/?gclid=EAIaIQobChMIoITIm_mJ-wIVRuztCh1IEwSaEAAYASAAEgIcHvD_BwE";

                Bweb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick (View v){
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            });

//-------------- AJUSTES ------------------------

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ImgAjustes = (ImageView) findViewById(R.id.ImgAjustes);
        ImgAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Ajustes.class);
                startActivity(intent);
            }
        });

//------------------------------------------------------------------------------------------------------------------------------
          //Botón de Llamadas
        ImageView ImgTelefono = (ImageView) findViewById(R.id.ImgTelefono);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText mPhoneNoEt = (EditText) findViewById(R.id.nmbr);

        ImgTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (view.getContext(), Telefono.class);
                startActivity(intent);

                /*String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }else {
                    Toast.makeText(MainActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    //..........................................................................................

        PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);

                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE:
                        Toast.makeText(MainActivity.this, "CALL_STATE_IDLE", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        Toast.makeText(MainActivity.this, "CALL_STATE_RINGING", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        Toast.makeText(MainActivity.this, "CALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };


//--------------------------------------------------------------------------------------------------------------------------

//Botón SMS
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imgSMS = (ImageView) findViewById(R.id.imgSMS);
        imgSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                Intent intent = new Intent (s.getContext(), SMS.class);
                startActivity(intent);
            }
        });

//--------------------------------------------------------------------------------------------------------------------------

//Botón Email
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView IMGemail = (ImageView) findViewById(R.id.IMGemail);
        IMGemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                Intent intent = new Intent (s.getContext(), Email.class);
                startActivity(intent);
            }
        });

        }
//------------------------------------------------------------------------------------------------------------------------------------------------------
    }




