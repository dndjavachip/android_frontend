package com.example.mocha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    public ListAdapter() {

    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        public ListViewHolder(View view) {
            super(view);
        }
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notice, parent, false);
        ListViewHolder listviewholder = new ListViewHolder(holderView);
        return listviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }


}
