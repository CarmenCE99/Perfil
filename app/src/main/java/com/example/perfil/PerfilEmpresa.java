package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class PerfilEmpresa extends AppCompatActivity {

    private EditText Txnombre;
    private EditText apellido11;
    private EditText apellido22;
    private EditText biografía;
    private EditText empresa;
    private EditText Txemail;
    private EditText telefono;
    private EditText direccion;
    private EditText Web;
    private EditText Facebook;
    private EditText Instagram;
    private EditText Twitter;

    private TextView txtResultado;

    private Button Bguardar;
    private Button btnConsultar;

    private SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_empresa);

        //BOTÓN GUARDAR
        //Button Bguardar = (Button) findViewById(R.id.Bguardar);
        // Así se enlaza el botón a el método
        //Bguardar.setOnClickListener(this);

        //Botón ATRÁS
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button Btatras = (Button) findViewById(R.id.Btatras);
        Btatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Ajustes.class);
                startActivity(intent);
            }
        });


//------GUARDO LOS TEXTVIEWS EN VARIABLES-------------------------------------------
        //Obtenemos las referencias a los controles
        Txnombre = (EditText)findViewById(R.id.Txnombre);
        apellido11 = (EditText) findViewById(R.id.apellido1);
        apellido22 = (EditText)findViewById(R.id.apellido2);
        biografía = (EditText)findViewById(R.id.biografía);
        empresa = (EditText)findViewById(R.id.empresa);
        Txemail = (EditText)findViewById(R.id.Txemail);
        telefono = (EditText)findViewById(R.id.telefono);
        direccion = (EditText)findViewById(R.id.direccion);
        Web = (EditText)findViewById(R.id.Web);
        Facebook = (EditText)findViewById(R.id.Facebook);
        Instagram = (EditText)findViewById(R.id.Instagram);
        Twitter = (EditText)findViewById(R.id.Twitter);

        //txtResultado = (TextView)findViewById(R.id.txtResultado);

        Bguardar = (Button)findViewById(R.id.Bguardar);
        //btnConsultar = (Button)findViewById(R.id.btnConsultar);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        BDSQLiteHelper usdbh =
                new BDSQLiteHelper(this, null, null, null, null, null, null, null, null, null, null, null, null, null,1);

        db = usdbh.getWritableDatabase();

        Bguardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Recuperamos los valores de los campos de texto
                String nombre = Txnombre.getText().toString();
                String apellido1 = apellido11.getText().toString();
                String apellido2 = apellido22.getText().toString();
                String bio = biografía.getText().toString();
                String empre = empresa.getText().toString();
                String email = Txemail.getText().toString();
                String tel = telefono.getText().toString();
                String dir = direccion.getText().toString();
                String web = Web.getText().toString();
                String face = Facebook.getText().toString();
                String ig = Instagram.getText().toString();
                String tw = Twitter.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "INSERT INTO Usuarios (codigo,nombre) VALUES ('" + cod + "','" + nom + "') ";
                //db.execSQL(sql);

                //Alternativa 2: método insert()
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nombre);
                nuevoRegistro.put("apellido1", apellido1);
                nuevoRegistro.put("apellido2", apellido2);
                nuevoRegistro.put("biografia", bio);
                nuevoRegistro.put("empresa", empre);
                nuevoRegistro.put("email", email);
                nuevoRegistro.put("telefono", tel);
                nuevoRegistro.put("direccion", dir);
                nuevoRegistro.put("web", web);
                nuevoRegistro.put("facebook", face);
                nuevoRegistro.put("instagram", ig);
                nuevoRegistro.put("twitter", tw);
                db.insert("Perfil", null, nuevoRegistro);

//-------------------------------------------------------------------------------------------------
                Integer i = new Integer(nombre);
                StringBuilder sb = new StringBuilder(); // or StringBuffer
                sb.append(i);

                // Convertir esas String a números Int, porque no podemos sumar cadenas
                String nombree = Integer.toString(Integer.parseInt(nombre));

                // Crear un Intent para cambiar
                Intent intent = new Intent(PerfilEmpresa.this, MainActivity.class);
                // Agregarle los datos que le pasamos
                // Nota: "datos" es la clave con la que lo vamos a obtener "del otro lado"
                intent.putExtra("datos", (CharSequence) sb);

                // Y ahora que ya tiene datos, cambiamos de actividad
                // Nos vemos en MainActivity
                startActivity(intent);

                Integer a = new Integer(apellido1);
                StringBuilder aa = new StringBuilder();
                aa.append(a);
                String apellido11 = Integer.toString(Integer.parseInt(apellido1));
                Intent intenta = new Intent(PerfilEmpresa.this, MainActivity.class);
                intenta.putExtra("apellidoa", (CharSequence) aa);
                startActivity(intenta);

                Integer a2 = new Integer(apellido2);
                StringBuilder aaa = new StringBuilder();
                aaa.append(a2);
                String apellido22 = Integer.toString(Integer.parseInt(apellido2));
                Intent intentaa = new Intent(PerfilEmpresa.this, MainActivity.class);
                intentaa.putExtra("apellidoaa", (CharSequence) aaa);
                startActivity(intentaa);
//-------------------------------------------------------------------------------------------------
            }
        });



       /* Bguardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Alternativa 1: método rawQuery()
                Cursor c = db.rawQuery("SELECT nombre, apellido1, apellido2, biografia, empresa, email, telefono, direccion, web, facebook, instagram, twitter FROM Perfil", null);


                //Alternativa 2: método delete()
                //String[] campos = new String[] {"codigo", "nombre"};
                //Cursor c = db.query("Usuarios", campos, null, null, null, null, null);

                //Recorremos los resultados para mostrarlos en pantalla
//                txtResultado.setText("");
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String nombre = c.getString(0);
                        String apellidos = c.getString(1);
                        String bio = c.getString(2);
                        String empre = c.getString(3);
                        String email = c.getString(4);
                        String tel = c.getString(5);
                        String dir = c.getString(6);
                        String web = c.getString(7);
                        String face = c.getString(8);
                        String ig = c.getString(9);
                        String tw = c.getString(10);

                        txtResultado.append(" " + nombre + " - " + apellidos + " - " + bio + " - " + empre + " - " + email +" - " + tel + " - " + dir + " - " + web + " - " +  face + " - " +  ig + " - " +  tw + "\n");
                    } while(c.moveToNext());
                }
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
