package com.example.route2route;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class User_DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash_board1);

    }
    public void onClick(View view) {
        if (view.getId() == R.id.imageView33) {
            Intent intent = new Intent(this, User_profile.class);
            startActivity(intent);
        }
    }
}