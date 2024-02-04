package com.example.route2route;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
   public void onClick(View view){
        if(view.getId() == R.id.loginbtn){
            Intent intent = new Intent(this, User_DashBoard.class);
            startActivity(intent);
        }
   }
}