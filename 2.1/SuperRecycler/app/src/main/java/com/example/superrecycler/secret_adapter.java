package com.example.superrecycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class secret_adapter extends RecyclerView.Adapter<secret_adapter.MyViewHolder>
{
    public List<Secret> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView objet;
        public TextView date;
        public TextView nombre;

        public MyViewHolder(LinearLayout v)
        {
            super(v);
            objet = v.findViewById(R.id.tvObjet);
            nombre = v.findViewById(R.id.tvNombre);
            date = v.findViewById(R.id.tvDate);
        }
    }

    public secret_adapter(){ list = new ArrayList<>(); }

    @Override
    public secret_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.secret_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Secret courant = new Secret();
        courant = list.get(position);
        holder.objet.setText(courant.nom);
        holder.date.setText(courant.date.toString());
        holder.nombre.setText(String.valueOf(courant.nbGrand));
    }

    @Override
    public int getItemCount() { return list.size(); }
}
