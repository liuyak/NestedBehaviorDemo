package com.xq.nestedbehaviordemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommonRVAdapter extends RecyclerView.Adapter<CommonRVAdapter.BehaviorViewHolder> {

    private List<String> mItems;

    public void setItems(List<String> mItems) {
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public BehaviorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.w("CommonRVAdapter", "onCreateViewHolder");
        return new BehaviorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.behavior_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BehaviorViewHolder holder, int position) {
        Log.w("CommonRVAdapter", "onBindViewHolder: " + position);
        holder.tv.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    static class BehaviorViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public BehaviorViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_behavior);
        }
    }
}
