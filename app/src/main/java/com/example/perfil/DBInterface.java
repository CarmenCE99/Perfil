package com.example.perfil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBInterface {
    // Constantes
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "Nombre";
    public static final String CAMPO_APELLIDO1 = "Apellido1";
    public static final String CAMPO_APELLIDO2 = "Apellido2";
    public static final String CAMPO_BIOGRAFIA = "Biografia";
    public static final String CAMPO_EMPRESA = "Empresa";
    public static final String CAMPO_EMAIL = "Email";
    public static final String CAMPO_TELEFONO = "Telefono";
    public static final String CAMPO_DIRECCION = "Direccion";
    public static final String CAMPO_WEB = "Web";
    public static final String CAMPO_FACEBOOK = "Facebook";
    public static final String CAMPO_INSTAGRAM = "Instagram";
    public static final String CAMPO_TWITTER = "Twitter";
    public static final String TAG = "DBInterface";

    public static final String BD_NOMBRE = "BDUsuarios";
    public static final String BD_TABLA = "Usuarios";
    public static final int VERSION = 2;

    public static final String BD_CREATE =
            "create table " + BD_TABLA + "(" + CAMPO_ID +
                    " integer primary key autoincrement, "+
                    CAMPO_NOMBRE+"TEXT"+
                    CAMPO_APELLIDO1+"TEXT"+
                    CAMPO_APELLIDO2+"TEXT"+
                    CAMPO_BIOGRAFIA+"TEXT"+
                    CAMPO_EMPRESA+"TEXT"+
                    CAMPO_EMAIL+"TEXT"+
                    CAMPO_TELEFONO+"TEXT"+
                    CAMPO_DIRECCION+"TEXT"+
                    CAMPO_WEB+"TEXT"+
                    CAMPO_FACEBOOK+"TEXT"+
                    CAMPO_INSTAGRAM+"TEXT"+
                    CAMPO_TWITTER+"TEXT";

    private final Context contexto;
    private AyudaDB ayuda;
    private SQLiteDatabase bd;

    public DBInterface (Context con) {
        this.contexto = con;
        Log.w(TAG, "Creando ayuda" );
        ayuda = new AyudaDB(contexto);
    }

    // Abre la BD
    public DBInterface abre () throws SQLException {
        Log.w(TAG, "Abrimos base de datos" );
        bd = ayuda.getWritableDatabase();
        return this;
    }

    // Cierra la BD
    public void cierra () {
        ayuda.close();
    }

    public long insertarUsuario(long id, String Nombre, String Apellido1, String Apellido2, String Biografia, String Empresa, String Email, String  Telefono, String Direccion, String Web, String Facebook, String Instagram, String Twitter) {
        ContentValues initialValues = new ContentValues ();
        initialValues.put(BD_TABLA, "usuario");
        initialValues.put(CAMPO_ID, id);
        initialValues.put(CAMPO_NOMBRE, Nombre);
        initialValues.put(CAMPO_APELLIDO1, Apellido1);
        initialValues.put(CAMPO_APELLIDO2, Apellido2);
        initialValues.put(CAMPO_BIOGRAFIA, Biografia);
        initialValues.put(CAMPO_EMPRESA, Empresa);
        initialValues.put(CAMPO_EMAIL, Email);
        initialValues.put(CAMPO_TELEFONO, Telefono);
        initialValues.put(CAMPO_DIRECCION, Direccion);
        initialValues.put(CAMPO_WEB, Web);
        initialValues.put(CAMPO_FACEBOOK, Facebook);
        initialValues.put(CAMPO_INSTAGRAM, Instagram);
        initialValues.put(CAMPO_TWITTER, Twitter);

        return bd.insert(BD_TABLA, null, initialValues);
    }

    // Devuelve todos los usuarios
    public Cursor obtenerUsuarios(){
        return bd.query(BD_TABLA, new String []
                        { CAMPO_ID,CAMPO_NOMBRE, CAMPO_APELLIDO1, CAMPO_APELLIDO2,CAMPO_BIOGRAFIA,CAMPO_EMPRESA,CAMPO_EMAIL,CAMPO_TELEFONO,CAMPO_DIRECCION,CAMPO_WEB,CAMPO_FACEBOOK,CAMPO_INSTAGRAM,CAMPO_TWITTER},
                null,null, null, null, null);
    }

    public long modificaUsuarios(long id, String Nombre, String Apellido1, String Apellido2, String Biografia, String Empresa, String Email, String  Telefono, String Direccion, String Web, String Facebook, String Instagram, String Twitter)
    {
        ContentValues newValues = new ContentValues ();
        newValues.put(CAMPO_ID, id);
        newValues.put(CAMPO_NOMBRE, Nombre);
        newValues.put(CAMPO_APELLIDO1, Apellido1);
        newValues.put(CAMPO_APELLIDO2, Apellido2);
        newValues.put(CAMPO_BIOGRAFIA, Biografia);
        newValues.put(CAMPO_EMPRESA, Empresa);
        newValues.put(CAMPO_EMAIL, Email);
        newValues.put(CAMPO_TELEFONO, Telefono);
        newValues.put(CAMPO_DIRECCION, Direccion);
        newValues.put(CAMPO_WEB, Web);
        newValues.put(CAMPO_FACEBOOK, Facebook);
        newValues.put(CAMPO_INSTAGRAM, Instagram);
        newValues.put(CAMPO_TWITTER, Twitter);

        return bd.update(BD_TABLA, newValues, CAMPO_ID + "=" + id, null);
        /*return bd.update(BD_TABLA, newValues, CAMPO_ID + "=" + id, CAMPO_NOMBRE + "=" + Nombre, CAMPO_APELLIDO1 + "=" + Apellido1,
                CAMPO_APELLIDO2 + "=" + Apellido2, CAMPO_BIOGRAFIA + "=" + Biografia, CAMPO_EMPRESA + "=" + Empresa, CAMPO_EMAIL + "=" + Email, CAMPO_TELEFONO + "=" + Telefono,
                CAMPO_DIRECCION + "=" + Direccion, CAMPO_WEB + "=" + Web, CAMPO_FACEBOOK + "=" + Facebook, CAMPO_INSTAGRAM + "=" + Instagram, CAMPO_TWITTER + "=" + Twitter,  null);*/

    }

    public long borrarRegistro(long id) {

        return bd.delete(BD_TABLA, CAMPO_ID + "=" + id, null);
    }

    public class AyudaDB extends SQLiteOpenHelper {

        public AyudaDB(Context con){
            super (con, BD_NOMBRE, null, VERSION);
            Log.w(TAG, "constructor de ayuda");
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            try {
                Log.w(TAG, "creando la base de datos "+BD_CREATE );
                db.execSQL(BD_CREATE);
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        @Override
        public void onUpgrade (SQLiteDatabase db,
                               int VersionAntigua, int VersionNueva) {
            Log.w(TAG, "Actualizando Base de datos de la versión" +
                    VersionAntigua + "A" + VersionNueva + ". Destruirá todos los datos");
            db.execSQL("DROP TABLE IF EXISTS " + BD_TABLA);
            onCreate(db);
        }
    }
}
