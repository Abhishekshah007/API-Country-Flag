package com.example.module_3_assignment_api_call;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// This is adapter file which bind recycler view and data
public class connectingAdapter extends RecyclerView.Adapter<connectingAdapter.ViewHolder> {

    private final List<countryModel> countryModelList;
    private final Context context;

    public connectingAdapter(List<countryModel> countryModelList, Context context){
        this.countryModelList = countryModelList;
        this.context = context;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.country_list, parent,false);
        return new ViewHolder(view);
    }

    public void  onBindViewHolder(ViewHolder holder, int position) {
        countryModel CountryModelList = countryModelList.get(position);
        holder.country_name.setText(CountryModelList.getName());
        holder.country_flag.setImageDrawable(null);

//        PictureDrawable drawable = CountryModelList.getFlagImage();
//        if (drawable != null) {
//            countryModel.setImageDrawable(drawable);
//        } else {
        Glide.with(context)
                .load(CountryModelList.getFlag()).into(holder.country_flag);
//    }


//        if (CountryModelList == null) {

//            Glide.with(context).load(CountryModelList.getFlag()).into(holder.country_flag);
//        }
//        else {
//            Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/5/5c/Flag_of_the_Taliban.svg").into(holder.country_flag);

//        }


    }

    public int getItemCount(){
        return countryModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView country_name;
        private final ImageView country_flag;

        public ViewHolder(View itemView){
            super(itemView);
            country_name = itemView.findViewById(R.id.country_name);
            country_flag = itemView.findViewById(R.id.country_flag);
        }
    }

}