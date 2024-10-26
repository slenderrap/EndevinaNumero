package com.oriol.endevinanumero;

import static com.oriol.endevinanumero.MainActivity.records;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;

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
        TableRow fila = new TableRow(this);
        TextView txt1 = new TextView(this);
        TextView txt2 = new TextView(this);
        txt1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        txt2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        txt1.setText("Nom");
        txt2.setText("Score");
        txt1.setBackgroundColor(Color.rgb(245,245,220));
        txt2.setBackgroundColor(Color.rgb(245,245,220));
        txt1.setPadding(10,10,10,10);
        txt2.setPadding(10,10,10,10);
        fila.addView(txt1);
        fila.addView(txt2);
        fila.setGravity(Gravity.CENTER);
        tabla.addView(fila);
        for (int i = 0; i< records.size(); i++){
            fila = new TableRow(this);
            txt1 = new TextView(this);
            txt2 = new TextView(this);
            txt1.setBackgroundColor(Color.rgb(245,245,220));
            txt2.setBackgroundColor(Color.rgb(245,245,220));

            txt2.setText(String.valueOf(records.get(i).getScore()));
            txt1.setText(String.valueOf(records.get(i).getName()));

            txt1.setPadding(10,10,10,10);
            txt1.setTextColor(Color.BLACK);
            txt1.setGravity(Gravity.CENTER);

            txt2.setPadding(10,10,10,10);
            txt2.setTextColor(Color.BLACK);
            txt2.setGravity(Gravity.CENTER);


            fila.addView(txt1);
            fila.addView(txt2);
            fila.setGravity(Gravity.CENTER);
            tabla.addView(fila);
        }
        Button bButton = (Button) findViewById(R.id.bBack);
        bButton.setOnClickListener(new View.OnClickListener() { // from class: com.oriol.endevinanumero.MainActivity2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, (Class<?>) MainActivity.class);
                MainActivity2.this.startActivity(intent);
            }
        });

    }



}