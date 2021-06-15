package com.xq.nestedbehaviordemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 浮层Adapter
 */
public class FloatAdapter extends RecyclerView.Adapter<FloatAdapter.BehaviorViewHolder> {

    private List<String> mItems;

    public void setItems(List<String> mItems) {
        this.mItems = mItems;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public BehaviorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BehaviorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.behavior_item_s, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BehaviorViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class BehaviorViewHolder extends RecyclerView.ViewHolder {

        public BehaviorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
