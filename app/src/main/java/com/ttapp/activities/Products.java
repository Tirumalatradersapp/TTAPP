package com.ttapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.ttapp.R;
import com.ttapp.adapters.CartAdapter;
import com.ttapp.adapters.HomeAdapter;
import com.ttapp.adapters.ProductDetailsAdapter;
import com.ttapp.adapters.ProductsAdapter;

public class Products extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView,bottomRecyclerView;
    private RelativeLayout cartLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        initializeViews();
        initializeClickListeners();
    }

    private void initializeViews() {
        cartLayout=(RelativeLayout)findViewById(R.id.products_bottom_layout);
        recyclerView=(RecyclerView)findViewById(R.id.products_top_recyclerview);
        bottomRecyclerView=(RecyclerView)findViewById(R.id.products_bottom_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ProductsAdapter(this));

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        bottomRecyclerView.setHasFixedSize(true);
        bottomRecyclerView.setLayoutManager(layoutManager1);
        bottomRecyclerView.setAdapter(new ProductDetailsAdapter(this));
    }

    private void initializeClickListeners() {
        cartLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.products_bottom_layout:
                Intent mycart=new Intent(this,MyCart.class);
                startActivity(mycart);
                break;
        }
    }
}
