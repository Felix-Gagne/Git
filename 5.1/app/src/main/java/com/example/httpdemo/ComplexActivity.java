package com.example.httpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.httpdemo.http.RetrofitUtil;
import com.example.httpdemo.http.Service;
import com.example.httpdemo.transfert.User;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);

        TextView tvA = findViewById(R.id.a1);
        TextView tvB = findViewById(R.id.b1);
        TextView tvC = findViewById(R.id.c1);

        Service service = RetrofitUtil.get();
        service.user("Félix").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {

                if(response.isSuccessful())
                {
                    tvA.setText("Réponse a : " + response.body().a);
                    tvB.setText("Réponse b : " + response.body().b);
                    tvC.setText("Réponse c : " + response.body().c);
                }

                else
                {
                    Log.i("RETROFIT", response.code()+"");
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t)
            {
                Log.i("RETROFIT",t.getMessage());
            }
        });
    }
}