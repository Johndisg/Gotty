package com.example.ejemplito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inicio extends AppCompatActivity {

    TextView txt_usuario;

    public static final String dataUser = "dataUser";

    public static final int modo_private = Context.MODE_PRIVATE;

    String dato;

    Button btn_cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        txt_usuario = findViewById(R.id.txt_usuario);

        dato = getApplicationContext().getSharedPreferences(dataUser, modo_private).getString("usuario", "0");

        if (!dato.equals("0")) {
            txt_usuario.setText(dato);
        } else {
            txt_usuario.setText("No hay información");
        }

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuracion = getApplicationContext().getSharedPreferences(dataUser, modo_private);
                configuracion.edit().clear().commit();
                Intent i = new Intent(inicio.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}