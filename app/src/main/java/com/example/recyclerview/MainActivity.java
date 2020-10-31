package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<String> data = new ArrayList<>();
    WordListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createIntialData();
        setUpAdapter();
        setUpFab();
    }

    private void setUpFab() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add("+ Word: " + data.size());
                Log.e("main", data.size() + "");
                adapter.notifyItemChanged(data.size() - 1);
                binding.recyclerView.smoothScrollToPosition(data.size() - 1);

            }
        });
    }

    private void setUpAdapter() {
        adapter = new WordListAdapter(MainActivity.this, data);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void createIntialData() {
        for (int i = 0; i < 20; i++) {
            data.add("Word " + i);
            Log.e("main", data + "");
        }
    }
}