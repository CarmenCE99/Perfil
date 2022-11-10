package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Button sendMessageBtn = (Button) findViewById(R.id.btn_send_message);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText messagetEt = (EditText) findViewById(R.id.et_message); //mensaje que se envía
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText mPhoneNoEt = (EditText) findViewById(R.id.nmbr); //número desde el que se envía
        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messagetEt.getText().toString();//mensaje que se envía
                String phoneNo = mPhoneNoEt.getText().toString(); //número desde el que se envía
                if(!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
                    smsIntent.putExtra("sms_body", message);
                    startActivity(smsIntent);
                }
            }
        });

        //Botón Atrás
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}