package com.example.route2route;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BusRoutes extends AppCompatActivity implements RecyclerViewInterface{
    Connection connection;

    ArrayList<String> busname,startpoint,endpoint;

    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_routes);


        recyclerView = (RecyclerView) findViewById(R.id.dataView);



        busname = new ArrayList<>();
        startpoint = new ArrayList<>();
        endpoint = new ArrayList<>();

        storeDatainArrays();
        CustomeAdapterRecyclerView customeAdapterRecyclerView = new CustomeAdapterRecyclerView(BusRoutes.this,busname,startpoint,endpoint, this);
        recyclerView.setAdapter(customeAdapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(BusRoutes.this));

    }

    void storeDatainArrays(){
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM BusRoutes";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    busname.add(resultSet.getString(2));
                    startpoint.add(resultSet.getString(3));
                    endpoint.add(resultSet.getString(4));

                }
                connection.close();
            } catch (Exception ex) {
                Log.e("Error", ex.getMessage());
            }
        }
        else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(int position) {
        if(position == 0){
            Intent intent = new Intent(BusRoutes.this,R1Details.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "This is not Warda", Toast.LENGTH_SHORT).show();
        }
    }
}