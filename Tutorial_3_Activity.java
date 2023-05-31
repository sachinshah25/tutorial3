package com.example.image;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.image.databinding.ActivityTutorial3Binding;

import java.util.ArrayList;

public class Tutorial_3_Activity extends AppCompatActivity {

    ActivityTutorial3Binding binding; // For using Binding Features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Gallery and get Multiple Images
                // Code squence is important
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ArrayList<String> arrayList=new ArrayList<>();
        if (requestCode==10 && resultCode==RESULT_OK){
            if (data!=null){
                int imageCount=data.getClipData().getItemCount();
                Toast.makeText(this, ""+imageCount, Toast.LENGTH_SHORT).show();
                for (int i=0; i<imageCount; i++){
                    String uri=data.getClipData().getItemAt(i).getUri().toString();
                    arrayList.add(uri);

                }

                GridLayoutManager gridLayoutManager=new GridLayoutManager(Tutorial_3_Activity.this,2);
                binding.imageRecyclerView.setLayoutManager(gridLayoutManager);

                modelClass modelClass=new modelClass(arrayList,Tutorial_3_Activity.this);
                binding.imageRecyclerView.setAdapter(modelClass);
                // Let's run
                // Thanks For Watching 
            }
        }
        else {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}