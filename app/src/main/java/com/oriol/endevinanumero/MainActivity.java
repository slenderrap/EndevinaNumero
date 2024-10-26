package com.oriol.endevinanumero;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Record>  records = new ArrayList<>();
    private int intents;
    private int score;
    private int num;
    private int numInt;
    private Comparator<Record> comparator;
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
        num = (int) (Math.random() * 100);
        comparator = Comparator.comparing(Record::getScore).reversed().thenComparing(Record::getName);
        Log.i("INFO", "size " + records.size());
        Button button = findViewById(R.id.numAleatori);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    intents++;
                    int duration = Toast.LENGTH_SHORT;

                    CharSequence text = "";
                    EditText et = findViewById(R.id.textInputEditText);
                    String numStr = et.getText().toString();
                    try{
                        numInt = Integer.parseInt(numStr);}
                    catch (NumberFormatException e){
                        text = "Has d'introduir un numero";
                        Toast.makeText(MainActivity.this,text,duration).show();
                    }
                    if (numInt == num) {
                        et.setText("");
                        score = intents;

                        score = (int)(numInt * (float)(10/score) * 1000);
                        num = (int)(Math.random()*100);
                        text = "Has encertat el numero";
                        final EditText input = new EditText(MainActivity.this);
                        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                        try {
                            ad.setMessage(text + " en " + intents + " intents.")
                                    .setTitle(text).setView(input)
                                    .setNegativeButton("Return", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    })
                                    .setPositiveButton("Add surname", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Editable nom = input.getText();
                                            if (nom.isEmpty()) {
                                                Toast.makeText(MainActivity.this, "Has d'introudir el teu nom", duration).show();

                                                Log.i("Error", "NO NOMBRE" + nom);
                                            } else {
                                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                                records.add(new Record(String.valueOf(nom), score));
                                                if (records.size() > 1) {
                                                    records.sort(comparator);
                                                }
                                                startActivity(intent);
                                            }
                                        }
                                    })

                            ;
                        }catch (Exception e){
                            e.getCause();
                        }
                        intents = 0;
                        AlertDialog dialog = ad.create();
                        dialog.show();
                    } else if (numInt > num) {
                         text = "El numero es massa gran";

                    } else {
                         text = "El numero es molt petit";
                    }

                    Toast toast = Toast.makeText(MainActivity.this, text, duration);
                    toast.show();

                }
            });


        }
    }



