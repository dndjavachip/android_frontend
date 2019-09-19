package com.example.mocha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


    public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        List<CardModel> datas;

        public ListAdapter(Context context, List<CardModel> datas) {
            this.context = context;
            this.datas = datas;
        }



    public  class ListViewHolder extends RecyclerView.ViewHolder {

        public ListViewHolder(View view) {
            super(view);
        }

    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView mainname;
        public MainViewHolder(View view) {
            super(view);
            mainname = view.findViewById(R.id.main_name);

        }

        void onBind(CardModel data) {
            mainname.setText(data.getText());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main,parent,false);
            return new MainViewHolder(view);
        }
        else if(viewType ==3) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_gps,parent,false);
            return new ListViewHolder(view);
        }

        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notice, parent, false);
            return new ListViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            CardModel model = datas.get(position);


            switch(model.getViewType()) {
                case 0:
                    ((MainViewHolder) holder).onBind(datas.get(0));


            }






    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {

        return datas.get(position).viewType;


    }


}
