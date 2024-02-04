package com.example.route2route;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class CustomeAdapterRecyclerView extends RecyclerView.Adapter<CustomeAdapterRecyclerView.myViewHolder> {

    private Context context;
    private ArrayList<String> busname,startpoint,endpont;
    Button detailbtn;
    private final RecyclerViewInterface recyclerViewInterface;



    CustomeAdapterRecyclerView(Context context, ArrayList busname, ArrayList startpoint, ArrayList endpont, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.busname = busname;
        this.startpoint = startpoint;
        this.endpont = endpont;

        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public CustomeAdapterRecyclerView.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow,parent,false);
        return new myViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapterRecyclerView.myViewHolder holder, int position) {
        holder.busname.setText(String.valueOf(busname.get(position)));
        holder.startpoint.setText(String.valueOf(startpoint.get(position)));
        holder.endpoint.setText(String.valueOf(endpont.get(position)));
    }

    @Override
    public int getItemCount() {

        return busname.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView busname,startpoint,endpoint;

        public myViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            busname = itemView.findViewById(R.id.busnametxt);
            startpoint = itemView.findViewById(R.id.startpointtxt);
            endpoint = itemView.findViewById(R.id.endpointtxt);

            detailbtn = itemView.findViewById(R.id.detailbtn);

               detailbtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent intent = new Intent(context, R1Details.class);
                       context.startActivity(intent);
                   }
               });

               itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if(recyclerViewInterface != null){
                           int pos = getAdapterPosition();
                              if(pos != RecyclerView.NO_POSITION){
                                  recyclerViewInterface.onItemClick(pos);
                              }
                       }
                   }
               });

        }
    }
}
