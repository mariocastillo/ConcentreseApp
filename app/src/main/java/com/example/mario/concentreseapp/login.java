package com.example.mario.concentreseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        LinearLayout linear = (LinearLayout) findViewById(R.id.login);
        TextView newp = new TextView(this);
        EditText newpe = new EditText(this);
        newp.setText(R.string.name);
        newpe.setId(0);
        linear.addView(newp);
        linear.addView(newpe);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id==R.id.creadores) {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Mario Castillo Ramirez"+"\n"+"marioe.castillo93@gmail.com", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER,0,0);
            toast1.show();
        }

        return super.onOptionsItemSelected(item);
    }



    public void añadir(View view) {
        count++;
        if (count<=4) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.login);
            TextView newp = new TextView(this);
            EditText newpe = new EditText(this);
            newp.setText(R.string.name);
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
        for (int k=0;k<=numplayers;k++){
            String ID=String.valueOf(k);
            EditText e= (EditText) findViewById(getResources().getIdentifier(ID,"id","com.example.mario.concentreseapp"));
            p= new Player(e.getText().toString(),0);
            i.putExtra("player"+k,p);
            i.putExtra("numplayers", numplayers);
        }
        startActivity(i);

    }
}
