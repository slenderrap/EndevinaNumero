package com.oriol.endevinanumero;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TableLayout tabla = findViewById(R.id.tabla);
        for (int i =0;i<=3;i++){
            TableRow fila = new TableRow(this);
            TextView txt1 = new TextView(this);
            TextView txt2 = new TextView(this);
            txt1.setText(String.valueOf(MainActivity.records.get(0).getName()));
            txt2.setText(String.valueOf(MainActivity.records.get(0).getScore()));
            fila.addView(txt1);
            fila.addView(txt2);
            tabla.addView(fila);
        }
    }



}