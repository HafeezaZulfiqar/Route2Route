package com.example.route2route;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class R1Details extends AppCompatActivity {
    Connection connection;
    TextView busname,startpoint,endpoint;

    RecyclerView recyclerView;
    ArrayList<String> area,rent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1_details);

        busname = findViewById(R.id.Busname);

        storeDatainTextViews();



        recyclerView = (RecyclerView) findViewById(R.id.BusStops);

        area = new ArrayList<>();
        rent = new ArrayList<>();


        storeDatainArrays();
        BusStopRecyclerViewAdapter busStopRecyclerViewAdapter = new BusStopRecyclerViewAdapter(R1Details.this, area,rent);
        recyclerView.setAdapter(busStopRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(R1Details.this));

    }

    void storeDatainTextViews(){
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM BusRoutes";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    busname.setText(resultSet.getString(2));
                    startpoint.setText(resultSet.getString(3));
                    endpoint.setText(resultSet.getString(4));

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

    void storeDatainArrays(){
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM Busstop";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    area.add(resultSet.getString(3));
                    rent.add(resultSet.getString(4));

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
}