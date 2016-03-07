package com.example.mario.concentreseapp;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TintResources;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int count=0;
    public static int anteriorButton;
    public static int anteriorButtoncolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        Player listp = (Player) i.getSerializableExtra("player"+"1");
        LinearLayout lin= (LinearLayout) findViewById(R.id.linear1);
        TextView nombre=new TextView(this);
        nombre.setText(listp.name+listp.score);
        lin.addView(nombre);



        dinamicallygrid(7, 7);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }



    public void dinamicallygrid(int row,int column){
        GridLayout grid= (GridLayout) findViewById(R.id.gridLayout);
        grid.setRowCount(row);
        grid.setColumnCount(column);
        for (int i=0,r=0,c=0;i<row*column;i++,c++){
            if (c==column){
                c=0;
                r++;
            }
            Button button=new Button(this);
            button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Gray));
            button.setId(i);
            GridLayout.LayoutParams params=new GridLayout.LayoutParams();
            params.setGravity(Gravity.CENTER);
            params.rightMargin=5;
            params.leftMargin=5;
            params.bottomMargin=5;
            params.topMargin=5;
            if (column>=5){
                params.width= (int) getResources().getDimension(R.dimen.botonm);
                params.height= (int) getResources().getDimension(R.dimen.botonm);
            }
            if (column>=7){
                params.width= (int) getResources().getDimension(R.dimen.botonp);
                params.height= (int) getResources().getDimension(R.dimen.botonp);
            }


            button.setLayoutParams(params);
            grid.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    Button btn = (Button) findViewById(v.getId());
                    switch (v.getId()) {
                        case 0:
                            btn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Green));
                            break;
                        case 1:
                            btn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Green));
                            break;
                        case 2:
                            btn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Rojo));
                            break;
                        case 3:
                            btn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Rojo));
                            break;

                    }
                    if(count%2==0 & ((ColorDrawable) v.getBackground()).getColor()!=anteriorButtoncolor ){
                        btn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.Gray));
                        Button btnanterior= (Button) findViewById(anteriorButton);
                        btnanterior.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Gray));
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),"te equivocaste", Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                    if (count%2==0 &((ColorDrawable) v.getBackground()).getColor()==anteriorButtoncolor ){
                        Button btnanterior= (Button) findViewById(anteriorButton);
                        btn.setEnabled(false);
                        btnanterior.setEnabled(false);

                    }

                    anteriorButtoncolor =( (ColorDrawable) btn.getBackground()).getColor();
                    anteriorButton=v.getId();
                }
            });

        }
    }

}

