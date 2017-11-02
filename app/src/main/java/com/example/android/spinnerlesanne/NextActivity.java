package com.example.android.spinnerlesanne;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends ActionBarActivity {
    Button show;
    TextView optiondisplay;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        optiondisplay=(TextView)findViewById(R.id.spinnerdisplay);
        setTitle("Intent 2");
        show=(Button)findViewById(R.id.show);
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String gen=pref.getString("gender", "");
                String and=pref.getString("android", "");
                optiondisplay.setText("Gender: "+gen+"\nAndroid: "+and);
            }
        });
    }
}