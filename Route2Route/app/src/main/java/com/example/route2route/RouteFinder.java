package com.example.route2route;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RouteFinder extends AppCompatActivity {

    EditText from,to;
    Button button;
    String value1,value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_finder);


        button = findViewById(R.id.findroutes);

        from = findViewById(R.id.from);
        to = findViewById(R.id.to);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RouteFinder.this,Map.class);
                value1 = from.getText().toString();
                intent.putExtra("from",value1);
                value2 = from.getText().toString();
                intent.putExtra("to",value2);
                startActivity(intent);
                finish();
            }
        });
    }
}