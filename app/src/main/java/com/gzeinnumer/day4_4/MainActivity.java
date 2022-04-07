package com.gzeinnumer.day4_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //todo 5
    private ArrayList<User> list = new ArrayList<>();
    private RecyclerView rvData ;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 6
        rvData = findViewById(R.id.rv);

        list = User.generateDataItem();
        adapter = new RvAdapter(getApplicationContext(), list);
        rvData.setAdapter(adapter);
        rvData.hasFixedSize();
        rvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}