package com.ttapp.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.ttapp.R;
import com.ttapp.adapters.CartAdapter;

public class MyCart extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView cartrecycler;
    private RelativeLayout cartBottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        initializeViews();
        initializeClickListeners();
//        fullScreen();
        showOrderDetails();
    }



    private void initializeViews() {
        cartrecycler=(RecyclerView)findViewById(R.id.cart_recycler);
        cartBottomLayout=(RelativeLayout)findViewById(R.id.cart_bottom_layout);
    }

    private void initializeClickListeners() {
        cartBottomLayout.setOnClickListener(this);
    }

    private void fullScreen() {
           /*to make the screen as full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.light_orange));
        }
    }

    private void showOrderDetails() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartrecycler.setLayoutManager(layoutManager);
        cartrecycler.setHasFixedSize(true);
        cartrecycler.setAdapter(new CartAdapter(this));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cart_bottom_layout:
                Intent checkout=new Intent(this,CheckOut.class);
                startActivity(checkout);
        }
    }
}
