package com.example.httpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.httpdemo.databinding.ActivityMainBinding;
import com.example.httpdemo.http.RetrofitUtil;
import com.example.httpdemo.http.Service;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        NumberPicker nombre = binding.nombre;

        nombre.setMaxValue(100);
        nombre.setMinValue(1);

        binding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newNumber();
            }
        });
    }

    public void newNumber(){

        TextView nombreDoubler = findViewById(R.id.nombreDoubler);
        NumberPicker nombre = binding.nombre;

        Service service = RetrofitUtil.get();
        service.listNombre(Integer.toString(nombre.getValue())).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                {
                    nombreDoubler.setText(response.body());
                }
                else
                {
                    Log.i("RETROFIT", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t)
            {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.demo:
                startActivity(new Intent(this, MainActivity.class));

            case R.id.complexe:
                startActivity(new Intent(this, ComplexActivity.class));

        }

        return super.onOptionsItemSelected(item);

    }
}