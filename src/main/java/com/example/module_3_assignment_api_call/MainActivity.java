package com.example.module_3_assignment_api_call;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView ;
    public connectingAdapter adapter ;
    public List<countryModel> countryModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.country_with_flag);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new connectingAdapter(countryModelList, this);

        apiCall ApiCall = clientInterface.getClient().create(apiCall.class);
        Call<List<countryModel>> call = ApiCall.getCountry();

        assert call != null;

//        using async method so that image wont stop other activity
        call.enqueue(new Callback<List<countryModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<countryModel>> call, @NonNull Response<List<countryModel>> response) {
                if(response.isSuccessful()){
                    countryModelList = response.body();

                    adapter = new connectingAdapter(countryModelList, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Toast.makeText(MainActivity.this, "Api Call Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<countryModel>> call, @NonNull Throwable t) {
                Log.e("MainActivity", "Error getting countries", t);
                Toast.makeText(MainActivity.this, "Failed to get countries and flags", Toast.LENGTH_SHORT).show();

            }
        });

    }
}