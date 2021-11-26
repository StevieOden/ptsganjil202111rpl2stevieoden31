package com.example.thirdact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdact.DetailActivity;
import com.example.thirdact.R;
import com.example.thirdact.models.SportModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.MyViewHolder> {

    ArrayList<SportModel> sportModels;
    Context context;
    Callback callback;

    public interface Callback{
    void onClick(int position);
    }

    public FavAdapter(Callback callback, Context context, ArrayList<SportModel> sportModels){
        this.sportModels = sportModels;
        this.context = context;
        this.callback = callback;
    }

    public FavAdapter(ArrayList<SportModel> item_list, Callback callback) {
        this.sportModels = item_list;
    }

    @NonNull
    @Override
    public FavAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SportModel sportModel = sportModels.get(position);
        holder.strSport.setText(sportModel.getStrSport());
        holder.strFormat.setText(sportModel.getStrFormat());
        Picasso.get()
                .load(sportModel.getStrSportThumb())
                .into(holder.strSportThumb);
        holder.itemcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("poster", sportModel.getStrSportThumb());
                intent.putExtra("title", sportModel.getStrSport());
                intent.putExtra("description", sportModel.getStrSportDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sportModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView strSport, strFormat;
        private ImageView strSportThumb;
        private CardView itemcv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            strSport = itemView.findViewById(R.id.txt_title);
            strFormat = itemView.findViewById(R.id.txt_format);
            strSportThumb = itemView.findViewById(R.id.poster_path);
            itemcv = itemView.findViewById(R.id.item_cv);
        }
    }
}
