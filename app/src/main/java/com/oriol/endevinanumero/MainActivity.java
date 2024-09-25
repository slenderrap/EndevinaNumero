package com.oriol.endevinanumero;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        int num = (int)(Math.random()*100);
        boolean endevinat=false;

            Button button = findViewById(R.id.numAleatori);
            int numIntent;

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                        int duration = Toast.LENGTH_SHORT;

                        CharSequence text = "";
                        EditText et = findViewById(R.id.textInputEditText);
                        String numStr = et.getText().toString();
                        int numIntent = Integer.parseInt(numStr);
                        if (numIntent == num) {
                            text = "Has encertat el numero";
                            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                            ad.setMessage(text)
                            .setTitle(text);
                            AlertDialog dialog = ad.create();
                            dialog.show();
                        } else if (numIntent > num) {
                             text = "El numero es massa gran";

                        } else {
                             text = "El numero es molt petit";
                        }
                        System.out.println(text);

                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();

                    }
                });


        }
    }



