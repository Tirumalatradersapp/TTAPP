package com.ttapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.ttapp.R;
import com.ttapp.activities.Products;

/**
 * Created by halya on 5/7/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;

    public HomeAdapter(Context context){
        this.context=context;
    }
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home,parent,
                false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.categoryLayout.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.adapter_home_layout:
                final ViewHolder viewHolder=new ViewHolder(view);
                final int position=viewHolder.getAdapterPosition();
                Intent products=new Intent(context,Products.class);
                context.startActivity(products);
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout categoryLayout;
        private ImageView categoryImage;
        private TextView categoryText;
        public ViewHolder(View itemView) {
            super(itemView);
            categoryLayout=(RelativeLayout)itemView.findViewById(R.id.adapter_home_layout);
            categoryImage=(ImageView)itemView.findViewById(R.id.adapter_home_image);
            categoryText=(TextView)itemView.findViewById(R.id.adapter_home_name);
        }
    }
}
