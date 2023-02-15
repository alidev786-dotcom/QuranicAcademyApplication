package com.example.quranicacademyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterLayout extends AppCompatActivity {

    ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_layout);

        list_view = findViewById(R.id.list_view);
        String[] str = new QDH().urduSurahNames;
        ArrayList<String> mylist = new ArrayList<>();
        for(int i = 0; i < str.length; i++) {
            mylist.add(str[i]);
        }


        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d("Console", "onItemClick: "+i);
//                adp.notifyDataSetChanged();
                Intent intent = new Intent(ArrayAdapterLayout.this, DataDisplay.class);
                intent.putExtra("ParahNum", i);

                startActivity(intent);
            }
        });

        list_view.setAdapter(adp);
    }
}