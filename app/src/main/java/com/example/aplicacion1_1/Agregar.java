package com.example.aplicacion1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Agregar extends AppCompatActivity {

    TextView txtNombre, txtCapasidad, txtColor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            txtNombre = findViewById(R.id.txtNombre);
            txtCapasidad = findViewById(R.id.txtCapasidad);
            txtColor = findViewById(R.id.txtColor);

            return insets;
        });
    }
    public void lista(View view){
        String nombre = txtNombre.getText().toString().trim();
        String capacidad = txtCapasidad.getText().toString().trim();
        String color = txtColor.getText().toString().trim();

        if(nombre.isEmpty() || capacidad.isEmpty() || color.isEmpty()){
            Toast.makeText(Agregar.this, "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Agregar.this, "Se agrego correctamente", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Agregar.this, Lista.class);
            i.putExtra("nombre", nombre);
            i.putExtra("capacidad", capacidad);
            i.putExtra("color", color);
            startActivity(i);
        }


    }
    public void cancelar(View view){
        Intent i = new Intent(Agregar.this, Menu.class);
        startActivity(i);
    }

}