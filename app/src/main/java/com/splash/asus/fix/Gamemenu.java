package com.splash.asus.fix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Gamemenu extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemenu);

        Button a = findViewById(R.id.btndrum);
        Button b = findViewById(R.id.btnguitar);
        Button c = findViewById(R.id.btnelectric);
        Button d = findViewById(R.id.btnflute);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btndrum:
                Toast.makeText(this,"You've Selected Drum",Toast.LENGTH_SHORT).show();
                Intent h = new Intent(Gamemenu.this,MainActivity.class);
                startActivity(h);
                break;
            case R.id.btnguitar:
                Toast.makeText(this,"You've Selected Guitar",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Gamemenu.this,guitar.class);
                startActivity(i);
                break;
            case R.id.btnelectric:
                Toast.makeText(this,"You've Selected ELectric Guitar",Toast.LENGTH_SHORT).show();
                Intent j = new Intent(Gamemenu.this,electric.class);
                startActivity(j);
                break;
            case R.id.btnflute:
                Toast.makeText(this,"You've Selected Flute",Toast.LENGTH_SHORT).show();
                Intent k = new Intent(Gamemenu.this,flute.class);
                startActivity(k);
                break;
             default:
        }
    }
}
