package com.xq.nestedbehaviordemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv_nested);
        rv.setLayoutManager(new LinearLayoutManager(this));
        CommonRVAdapter adapter = new CommonRVAdapter();
        adapter.setItems(Utils.getCommonItems(30));
        rv.setAdapter(adapter);
    }
}