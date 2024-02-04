package com.example.route2route;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


            LatLng modelcoloney = new LatLng(24.90084814310277, 67.19397838652517);
            googleMap.addMarker(new MarkerOptions()
                    .position(modelcoloney)
                    .title("Model Coloney R1(RedBus)"));

            LatLng LalKhothi = new LatLng(24.861404786091683, 67.06953179912898);
            googleMap.addMarker(new MarkerOptions()
                    .position(LalKhothi)
                    .title("Lal Khothi R1(RedBus)"));

            Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                    .clickable(true)
                    .add(
                            new LatLng(24.90084814310277, 67.19397838652517),
                            new LatLng(24.861404786091683, 67.06953179912898)));

            // Position the map's camera near Alice Springs in the center of Australia,
            // and set the zoom factor so most of Australia shows on the screen.
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        }
    }
