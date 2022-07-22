package com.apecssi.sqlitem4a.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.io.*;

public class TiendaSQLHelper extends SQLiteOpenHelper {
    private static final String BASE="tienda.db";
    private Context miContexto;
    public TiendaSQLHelper(@Nullable Context context) {
        super(context, BASE, null, 3);
        miContexto=context;

        File rutaArchivo= miContexto.getDatabasePath(BASE);
        if(!existeBase(rutaArchivo.getAbsolutePath()))
     copiarBD(rutaArchivo);
    }
    private boolean existeBase(String ruta){
        SQLiteDatabase siDB=null;
        siDB=SQLiteDatabase.openDatabase(ruta,null,SQLiteDatabase.OPEN_READONLY);
        if (siDB != null) {
            siDB.close();
            return true;
            }
    return false;

    };
    private void copiarBD(File rutaArchivo){
        try {
            InputStream inputStream=miContexto.getAssets().open(BASE);
            OutputStream outputStream=new FileOutputStream(rutaArchivo);
            byte[] buffer=new byte[1024];
            int largo;
            while ((largo=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,largo);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
