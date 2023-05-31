package com.example.image;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.image.databinding.ImagelayoutBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class modelClass extends RecyclerView.Adapter<modelClass.ViewHolder>{

    public modelClass(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    ArrayList<String> arrayList;
    Context context;
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.imagelayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        holder.binding.img.setImageURI(Uri.parse(arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImagelayoutBinding binding; // Binding Features
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding=ImagelayoutBinding.bind(itemView);
        }
    }
}
