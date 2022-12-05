package com.example.perfil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Transporte
    String sqlCreate = "CREATE TABLE Perfil (codigo INTEGER, nombre TEXT, apellido1 TEXT, apellido2 TEXT, biografia TEXT, empresa TEXT, email TEXT, telefono TEXT, direccion TEXT, web TEXT, facebook TEXT, instagram TEXT, twitter TEXT)";

    public BDSQLiteHelper(Context contexto, String nombre, String apellido1, String apellido2, String biografia, String empresa, String email, String telefono, String direccion, String web, String facebook, String instagram, String twitter, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente
        //      la opción de eliminar la tabla anterior y crearla de nuevo
        //      vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la
        //      tabla antigua a la nueva, por lo que este método debería
        //      ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Perfil");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}