package com.example.mario.concentreseapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class login extends AppCompatActivity {
    public static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }

    public void añadir(View view) {
        count++;
        if (count==5){
            Button btn= (Button) findViewById(R.id.fab);
            btn.setEnabled(false);
        }
        LinearLayout linear= (LinearLayout) findViewById(R.id.login);
        TextView newp= new TextView(this);
        EditText newpe=new EditText(this);
        newp.setText("Nombre");
        newpe.setId(count);
        linear.addView(newp);
        linear.addView(newpe);
    }
}
