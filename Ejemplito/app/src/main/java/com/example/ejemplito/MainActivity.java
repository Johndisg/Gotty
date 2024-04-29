package com.example.ejemplito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_inicio;

    EditText edt_usuario;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    public static final String dataUser = "dataUser";

    String dato;
    public static final int modo_private = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_inicio = findViewById(R.id.btn_inicio);
        edt_usuario = findViewById(R.id.edt_usuario);

        sharedPreferences = getSharedPreferences(dataUser, modo_private);

        editor = sharedPreferences.edit();

        dato = getApplicationContext().getSharedPreferences(dataUser, modo_private).getString("usuario", "0");

        if (!dato.equalsIgnoreCase("0")) {
            Intent i = new Intent(MainActivity.this, inicio.class);
            startActivity(i);
            finish();
        }

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("usuario", edt_usuario.getText().toString());
                editor.commit();
                Intent i = new Intent(MainActivity.this, inicio.class);
                startActivity(i);
                finish();
            }
        });

    }
}