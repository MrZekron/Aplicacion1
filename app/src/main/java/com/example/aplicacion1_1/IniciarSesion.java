package com.example.aplicacion1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IniciarSesion extends AppCompatActivity {

    TextView tvCorreo, tvContraseña;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciar_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            tvCorreo = findViewById(R.id.tvCorreo);
            tvContraseña = findViewById(R.id.tvContraseña);
            btnIngresar = findViewById(R.id.btnIngresar);

            // Configura un Listener para el botón btnIngresar que escucha los clics.
            btnIngresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { // Método que se llama cuando se hace clic en el botón.
                    // Obtiene el texto ingresado en los campos de correo y contraseña y los recorta para eliminar espacios en blanco.
                    String correoUser = tvCorreo.getText().toString().trim();
                    String contraseñaUser = tvContraseña.getText().toString().trim();

                    // Verifica si alguno de los campos está vacío.
                    if (correoUser.isEmpty() || contraseñaUser.isEmpty()) {
                        // Muestra un mensaje de advertencia si los campos están vacíos.
                        Toast.makeText(IniciarSesion.this, "Por favor ingrese su correo y contraseña", Toast.LENGTH_SHORT).show();
                    } else {
                        // Si ambos campos tienen datos, crea un Intent para navegar a la actividad Menu.
                        Intent i = new Intent(IniciarSesion.this, Menu.class);
                        startActivity(i); // Inicia la actividad Menu.
                    }
                }
            });

            return insets;
        });
    }

}