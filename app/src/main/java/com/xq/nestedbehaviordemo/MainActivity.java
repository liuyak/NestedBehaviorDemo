package com.xq.nestedbehaviordemo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private SNBBottomSheetBehavior<View> behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        NestedRecycleView rv = findViewById(R.id.rv_nested);
        rv.setLayoutManager(new LinearLayoutManager(this));
        CommonRVAdapter adapter = new CommonRVAdapter();
        adapter.setItems(Collections.singletonList("1"));
        rv.setAdapter(adapter);

        RecyclerView float_content = findViewById(R.id.float_content);
        float_content.setLayoutManager(new LinearLayoutManager(this));
        FloatAdapter floatAdapter = new FloatAdapter();
        floatAdapter.setItems(Utils.getCommonItems(20));
        float_content.setAdapter(floatAdapter);

        LinearLayout behavior_contain = findViewById(R.id.behavior_contain);
        behavior = SNBBottomSheetBehavior.from(behavior_contain);
        behavior.setPeekHeight((int) Utils.dipToPix(this, 54f));
        behavior.setState(SNBBottomSheetBehavior.STATE_COLLAPSED);
        rv.post(() -> rv.bindSNBBottomSheetBehavior(behavior));
    }
}