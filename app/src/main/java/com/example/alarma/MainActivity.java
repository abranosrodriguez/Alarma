package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAlarma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlarma = findViewById(R.id.btnAlarma);

        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "Esto es el aviso actual de la alarma";
                int hora = 10;
                int minuto = 03;
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, mensaje);
                intent.putExtra(AlarmClock.EXTRA_HOUR, hora);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minuto);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "ERROR - NO SE HA CARGADO LA ALARMA", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}