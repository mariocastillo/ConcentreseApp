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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    public static int count=0;
    public static int anteriorButton;
    public static int anteriorButtoncolor;
    public static int end;
    Player p;
    public static int turno=0;
    ArrayList<Player> listp= new ArrayList<>();
    public TextView jugador;
    public List<String> colores= Arrays.asList("red", "blue", "green", "black","cyan", "magenta","yellow","aqua","red", "blue", "green", "black","cyan", "magenta","yellow","aqua");
    /*,"fuchsia", "lime", "maroon","navy", "olive", "purple", "silver", "teal",*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        final int row=4;
        final int column=4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        int nume= i.getIntExtra("numplayers",0);
        for (int h=0;h<=nume;h++){
            p = (Player) i.getSerializableExtra("player"+h);
            listp.add(p);
            LinearLayout lin= (LinearLayout) findViewById(R.id.linear1);
            TextView nombre=new TextView(this);
            nombre.setText(getResources().getString(R.string.name)+": "+p.name+"\n"+getResources().getString(R.string.score) +": "+p.score);
            nombre.setId(h+100);
            lin.addView(nombre);
        }



        dinamicallygrid(4, 4,listp);


        final ImageButton restart = (ImageButton) findViewById(R.id.restart);
        final TextView pw = new TextView(this);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(colores);
                for (int i = 0; i < row * column; i++) {
                    Button button= (Button) findViewById(i);
                    button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Gray));
                    button.setEnabled(true);
                    if (i < listp.size()) {
                        listp.get(i).score = 0;
                        LinearLayout linear= (LinearLayout) findViewById(R.id.linear2);
                        TextView pw= (TextView) findViewById(1001);
                        pw.setText("");
                        jugador= (TextView) findViewById(100+i);
                        jugador.setText(getResources().getString(R.string.name)+": "+ listp.get(i).name + "\n" + getResources().getString(R.string.score)+": " + listp.get(i).score);
                    }
                }
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



    public void dinamicallygrid(final int row, final int column, final ArrayList<Player> lplayers){
        final TextView pw = new TextView(this);
        pw.setId(1001);
        final int grilla=column*row;
        end=grilla;
        Collections.shuffle(colores);
        GridLayout grid= (GridLayout) findViewById(R.id.gridLayout);
        grid.setRowCount(row);
        grid.setColumnCount(column);
        for (int i=0,r=0,c=0;i<grilla;i++,c++){
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
                    if (count % 2 == 0 & count != 0) {
                        turno++;
                        if (turno == lplayers.size()) {
                            turno = 0;
                        }
                    }
                    count++;
                    final Button btn = (Button) findViewById(v.getId());
                    switch (v.getId()) {
                        case 0:
                            btn.setBackgroundColor(Color.parseColor(colores.get(0)));
                            break;
                        case 1:
                            btn.setBackgroundColor(Color.parseColor(colores.get(1)));
                            break;
                        case 2:
                            btn.setBackgroundColor(Color.parseColor(colores.get(2)));
                            break;
                        case 3:
                            btn.setBackgroundColor(Color.parseColor(colores.get(3)));
                            break;
                        case 4:
                            btn.setBackgroundColor(Color.parseColor(colores.get(4)));
                            break;
                        case 5:
                            btn.setBackgroundColor(Color.parseColor(colores.get(5)));
                            break;
                        case 6:
                            btn.setBackgroundColor(Color.parseColor(colores.get(6)));
                            break;
                        case 7:
                            btn.setBackgroundColor(Color.parseColor(colores.get(7)));
                            break;
                        case 8:
                            btn.setBackgroundColor(Color.parseColor(colores.get(8)));
                            break;
                        case 9:
                            btn.setBackgroundColor(Color.parseColor(colores.get(9)));
                            break;
                        case 10:
                            btn.setBackgroundColor(Color.parseColor(colores.get(10)));
                            break;
                        case 11:
                            btn.setBackgroundColor(Color.parseColor(colores.get(11)));
                            break;
                        case 12:
                            btn.setBackgroundColor(Color.parseColor(colores.get(12)));
                            break;
                        case 13:
                            btn.setBackgroundColor(Color.parseColor(colores.get(13)));
                            break;
                        case 14:
                            btn.setBackgroundColor(Color.parseColor(colores.get(14)));
                            break;
                        case 15:
                            btn.setBackgroundColor(Color.parseColor(colores.get(15)));
                            break;
                    }
                    if (count % 2 == 0 & ((ColorDrawable) v.getBackground()).getColor() != anteriorButtoncolor) {
                        btn.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Gray));

                            }
                        }, 1000);

                        final Button btnanterior = (Button) findViewById(anteriorButton);
                        btnanterior.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnanterior.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Gray));
                            }
                        }, 1000);
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(), "te equivocaste", Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                    if (count % 2 == 0 & ((ColorDrawable) v.getBackground()).getColor() == anteriorButtoncolor) {
                        end = end - 2;
                        listp.get(turno).score = listp.get(turno).score + 10;
                        jugador = (TextView) findViewById(100 + turno);
                        jugador.setText(getResources().getString(R.string.name)+": " + listp.get(turno).name + "\n" + getResources().getString(R.string.score)+": " + listp.get(turno).score);
                        Button btnanterior = (Button) findViewById(anteriorButton);
                        btn.setEnabled(false);
                        btnanterior.setEnabled(false);
                        if (end == 0) {
                            Collections.sort(listp, new Comparator<Player>() {
                                @Override
                                public int compare(Player p1, Player p2) {
                                    return new Integer(p2.score).compareTo(p1.score);
                                }
                            });
                            LinearLayout linear = (LinearLayout) findViewById(R.id.linear2);
                            pw.setText(getResources().getString(R.string.ganador)+"\n"+getResources().getString(R.string.name)+": " + listp.get(0).name + "\n" + getResources().getString(R.string.score)+": " + listp.get(0).score);
                            linear.addView(pw);
                            end=column*row;

                        }

                    }

                    anteriorButtoncolor = ((ColorDrawable) btn.getBackground()).getColor();
                    anteriorButton = v.getId();
                }
            });

        }
    }

}

