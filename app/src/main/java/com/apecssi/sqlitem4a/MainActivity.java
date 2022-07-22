package com.apecssi.sqlitem4a;

import android.database.Cursor;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.apecssi.sqlitem4a.model.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonGuardar=(Button) findViewById(R.id.buttonCrear);
        buttonGuardar.setOnClickListener(guardarListener);
        Button buttonListar=(Button) findViewById(R.id.buttonListar);
        buttonListar.setOnClickListener(listarListener);
    }

    View.OnClickListener listarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ListView listView=(ListView) findViewById(R.id.listPersonas);
            Cursor cursor=Persona.listaPersonas(getApplicationContext());
            String[] desde = new String[]{"id","nombre","estado_civil","tipo_sangre"};
            int[] hasta = new int[]{R.id.txtID,R.id.txtNombre,R.id.txtEstadoCivil,R.id.txtTipoSangre};

            CursorAdapter cursorAdapter= new SimpleCursorAdapter(
                    getApplicationContext(),
                    R.layout.detalle_persona,
                    cursor,
                    desde,
                    hasta,0
            );
            listView.setAdapter(cursorAdapter);
        }
    };
    View.OnClickListener guardarListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText txtID=(EditText) findViewById(R.id.editID);
            EditText txtNombre=(EditText) findViewById(R.id.editNombre);
            EditText txtEstadoCivil=(EditText) findViewById(R.id.editEstadoCivil);
            EditText txtTipoSangre=(EditText) findViewById(R.id.editTipoSangre);

            Persona persona= new Persona();
            persona.setId(txtID.getText().toString());
            persona.setNombre(txtNombre.getText().toString());
            persona.setEstadoCivil(txtEstadoCivil.getText().toString());
            persona.setTipoSangre(txtTipoSangre.getText().toString());

            persona.guardaPersona(getApplicationContext());
            Toast.makeText(getApplicationContext(),"Creado.",Toast.LENGTH_LONG).show();
        }
    };
}