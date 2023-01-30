package com.example.superrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    secret_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
        remplacer();
    }

    private void initRecycler()
    {
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);

        //Linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new secret_adapter();
        recyclerView.setAdapter(adapter);
    }


    //Populate the RecyclerView
    private void remplacer()
    {
        adapter.list.clear();

        for(int i = 1; i <= 1000; i++)
        {
            Secret secret = new Secret();
            secret.id = i;
            secret.nom = "Objet #" + i;
            secret.date = new Date(2023, 1, 30);
            secret.nbGrand = i * 2;
            adapter.list.add(secret);
        }

        adapter.notifyDataSetChanged();
    }
}