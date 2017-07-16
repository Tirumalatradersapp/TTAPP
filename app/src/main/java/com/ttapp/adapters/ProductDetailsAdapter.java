package com.ttapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ttapp.R;

/**
 * Created by halya on 10/7/17.
 */

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder>
        implements View.OnClickListener {
    private Context context;

    public ProductDetailsAdapter(Context context){
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_details,parent,
                false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.addLayout.setOnClickListener(this);
        viewHolder.addLayout.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View view) {
        final ViewHolder holder=(ViewHolder)view.getTag();
        final int position=holder.getAdapterPosition();
        switch (view.getId()){
            case R.id.adapter_prod_details_add:
                holder.addLayout.setVisibility(View.GONE);
                holder.incDecLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout adapterLayout,addLayout,incDecLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            adapterLayout=(RelativeLayout)itemView.findViewById(R.id.adapter_prod_details_layout);
            addLayout=(RelativeLayout)itemView.findViewById(R.id.adapter_prod_details_add);
            incDecLayout=(RelativeLayout)itemView.findViewById(R.id.adapter_prod_details_inc_dec_layout);

        }
    }
}
