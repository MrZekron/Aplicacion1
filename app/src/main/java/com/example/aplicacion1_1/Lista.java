package com.example.aplicacion1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lista extends AppCompatActivity {

    TextView tv1;
    String [] nombres = {"Tanque 1", "Tanque 2", "Tanque 3"};
    String[] color = {"Rojo", "Verde", "Azul"};
    String[] capasidad = {"1000 litros", "2000 litros", "3000 litros"};
    ListView[] lv1 = new ListView[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            tv1 = findViewById(R.id.tv1);

            lv1[0] = findViewById(R.id.listTanque);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombres);
            lv1[0].setAdapter(adapter);
            Intent intent = new Intent(this, Informacion.class);

            lv1[0].setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    intent.putExtra("nombres", nombres[i]);
                    intent.putExtra("capasidad", capasidad[i]);
                    intent.putExtra("color", color[i]);
                    startActivity(intent);
                }
            });

            return insets;
        });
    }
}