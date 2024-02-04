package com.example.route2route;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusStopRecyclerViewAdapter extends RecyclerView.Adapter<BusStopRecyclerViewAdapter.myViewHolder> {

    private Context context;
    private ArrayList<String> area,rent;

    BusStopRecyclerViewAdapter(Context context, ArrayList area, ArrayList rent){
        this.context = context;
        this.area = area;
        this.rent = rent;

    }

    @NonNull
    @Override
    public BusStopRecyclerViewAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.busstop,parent,false);
        return new BusStopRecyclerViewAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusStopRecyclerViewAdapter.myViewHolder holder, int position) {
        holder.area.setText(String.valueOf(area.get(position)));
        holder.rent.setText(String.valueOf(rent.get(position)));

    }

    @Override
    public int getItemCount() {
        return area.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView area,rent;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            area = itemView.findViewById(R.id.stopname);
            rent = itemView.findViewById(R.id.rent);


        }
    }
}
