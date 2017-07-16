package com.ttapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ttapp.R;

public class CheckOut extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout bottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        initializeViews();
        initializeClickListeners();
    }

    private void initializeViews() {
        bottomLayout=(RelativeLayout)findViewById(R.id.checkout_bottom_layout);
    }

    private void initializeClickListeners() {
        bottomLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.checkout_bottom_layout:
                startActivity(new Intent(this,ThankYou.class));
                break;
        }
    }
}
