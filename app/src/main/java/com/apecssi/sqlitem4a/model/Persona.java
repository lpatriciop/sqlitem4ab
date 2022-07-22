package com.apecssi.sqlitem4a.model;

import android.content.Context;
import android.database.Cursor;

public class Persona {
    private String id;
    private String nombre;
    private String estadoCivil;
    private String tipoSangre;

    public static Cursor listaPersonas(Context mc){
        TiendaSQLHelper tiendaSQLHelper=new TiendaSQLHelper(mc);
        String sql="select _rowid_ as _id,* from persona";
        return
        tiendaSQLHelper.getReadableDatabase().rawQuery(sql,null);
    }
    public void guardaPersona(Context mc){
        TiendaSQLHelper tiendaSQLHelper=new TiendaSQLHelper(mc);
        String sql;
        sql="INSERT INTO persona (id,nombre,estado_civil,tipo_sangre)";
        sql+="VALUES ('"+ getId()+"','"+ getNombre()+"','" + getEstadoCivil() + "','"+getTipoSangre()+"')";
        tiendaSQLHelper.getWritableDatabase().execSQL(sql);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
