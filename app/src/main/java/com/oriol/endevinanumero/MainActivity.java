package com.oriol.endevinanumero;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Record>  records;
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
        records = new ArrayList<Record>();
        final int[] num = {(int) (Math.random() * 100)};
        num[0]=3;
        final boolean[] endevinat = {false};

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
                        if (numInt == num[0]) {
                            et.setText("");

                            endevinat[0] = false;
                            num[0] = (int)(Math.random()*100);
                            text = "Has encertat el numero";
                            final EditText input = new EditText(MainActivity.this);
                            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                            ad.setMessage(text+" en "+intents+" intents.")
                            .setTitle(text).setView(input)
                                    .setNegativeButton("Return", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    })
                                    .setPositiveButton("Add surname", new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Editable nom = input.getText();
                                    if (nom.equals("")){
                                        Toast.makeText(MainActivity.this,"Has d'introudir el teu nom",duration).show();

                                        Log.i("Error","NO NOMBRE"+nom);
                                    }else {
                                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                                        records.add(new Record(String.valueOf(nom),intents));
                                        startActivity(intent);
                                    }
                                }})

                            ;
                            intents = 0;
                            AlertDialog dialog = ad.create();
                            dialog.show();
                        } else if (numInt > num[0]) {
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



