package com.oriol.endevinanumero;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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
    private int intents=0;
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
            int numInt;

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        intents++;
                        int duration = Toast.LENGTH_SHORT;

                        CharSequence text = "";
                        EditText et = findViewById(R.id.textInputEditText);
                        String numStr = et.getText().toString();
                        int numInt = Integer.parseInt(numStr);
                        if (numInt == num) {
                            text = "Has encertat el numero";
                            final EditText input = new EditText(MainActivity.this);
                            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                            ad.setMessage(text+" en "+intents+" intents.")
                            .setTitle(text).setView(input)
                                    .setPositiveButton("Add surname", new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }})

                            ;



                            AlertDialog dialog = ad.create();
                            dialog.show();
                        } else if (numInt > num) {
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



