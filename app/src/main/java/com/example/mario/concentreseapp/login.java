package com.example.mario.concentreseapp;

import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.mario.concentreseapp.Player;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {
    public static int count=0;
    public static int numplayers;
    Player p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }

    public void añadir(View view) {
        count++;
        if (count<=4) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.login);
            TextView newp = new TextView(this);
            EditText newpe = new EditText(this);
            newp.setText("Nombre");
            newpe.setId(count);
            linear.addView(newp);
            linear.addView(newpe);
            numplayers=count;
        }
        else{
            ImageButton btn= (ImageButton) findViewById(R.id.fab);
            btn.setEnabled(false);
        }

    }

    public void finalizar(View view) {
        Intent i= new Intent(getApplicationContext(),MainActivity.class);
        for (int k=1;k<=numplayers;k++){
            String ID=String.valueOf(k);
            EditText e= (EditText) findViewById(getResources().getIdentifier(ID,"id","com.example.mario.concentreseapp"));
            p= new Player(e.getText().toString(),0);
            i.putExtra("player"+String.valueOf(count),p);
        }
        startActivity(i);

    }
}
