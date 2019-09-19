package com.example.mocha;

import android.content.Context;
import android.content.Intent;
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



    public  class SearchViewHolder extends RecyclerView.ViewHolder {
        public final View mainView;

        public SearchViewHolder(View view) {
            super(view);
            mainView = view;

        }
        }



        public  class ListViewHolder extends RecyclerView.ViewHolder {

            public ListViewHolder(View view) {
                super(view);
            }

        }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public final View mainView;
        public TextView mainname;
        public TextView maingps;

        public MainViewHolder(View view) {
            super(view);
            mainView = view;
            mainname = view.findViewById(R.id.main_name);
            maingps = view.findViewById(R.id.main_gps);

        }


        void onBind(CardModel data) {
            mainname.setText(data.getArray()[1]);
            maingps.setText(data.getArray()[0]);
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
            return new SearchViewHolder(view);
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
                    ((MainViewHolder) holder).mainView.findViewById(R.id.infomartion_main).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO : process click event.

                                    Context context = v.getContext();
                                    Intent intentInfo = new Intent(context, InformationActivity.class);
                                    context.startActivity(intentInfo);

                            }

                    });
                    break;
                case 3:
                    ((SearchViewHolder) holder).mainView.findViewById(R.id.search_cafe).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO : process click event.

                            Context context = v.getContext();
                            Intent intentInfo = new Intent(context, SearchActivity.class);
                            context.startActivity(intentInfo);

                        }

                    });
                    break;



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
