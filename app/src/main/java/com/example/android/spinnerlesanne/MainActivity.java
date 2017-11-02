package com.example.android.spinnerlesanne;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.SharedPreferences.Editor;

public class MainActivity extends AppCompatActivity {

    Button next;
    Spinner gender,android;
    Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=(Button) findViewById(R.id.next);
        setTitle("Intent 1");
        gender=(Spinner)findViewById(R.id.gender);
        android=(Spinner)findViewById(R.id.android);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);
        editor=pref.edit();
        gender.setOnItemSelectedListener(new com.example.android.spinnerlesanne.CustomOnItemSelectedListener());
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String gen=gender.getSelectedItem().toString();
                String and=android.getSelectedItem().toString();
                editor.putString("gender", gen);
                editor.putString("android", and);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Settings saved!", Toast.LENGTH_LONG ).show();
                Intent in=new Intent(MainActivity.this, com.example.android.spinnerlesanne.NextActivity.class);
                startActivity(in);
            }
        });
    }
}
