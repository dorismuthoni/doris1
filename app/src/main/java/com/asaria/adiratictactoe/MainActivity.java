package com.asaria.adiratictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void single (View v){
        startActivity(new Intent(this, Single3.class));


    }
    public void multi3(View v){
        startActivity(new Intent(this,Multi3.class));
    }
}
