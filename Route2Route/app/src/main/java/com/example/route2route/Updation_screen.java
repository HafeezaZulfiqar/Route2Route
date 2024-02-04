package com.example.route2route;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Updation_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updation_screen);
    }
    public void onClick(View view){
        if(view.getId() == R.id.update){
            Intent intent = new Intent (this, Login.class);
            startActivity(intent);
        }
    }
}