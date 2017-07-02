package com.ttapp.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ttapp.adapters.NavigationDrawerAdapter;
import com.ttapp.R;
import com.ttapp.fragments.HomeFragment;
import com.ttapp.interfaces.NavDrawerCallback;

public class Home extends AppCompatActivity implements NavDrawerCallback,AdapterView.OnItemClickListener{
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private DrawerLayout drawer;
    private ListView drawerList;
    private TextView name,mobile;
    private RelativeLayout pickLocation;
    private boolean isHome = true;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();
        initializeDrawerAdapter();
        initializeEventListeners();
        loadDefaultFragment();
        fullScreen();
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

    private void initializeViews() {
        drawer = (DrawerLayout)findViewById(R.id.home_drawer_layout);
        drawerList = (ListView)findViewById(R.id.home_left_drawer);
        name = (TextView)findViewById(R.id.home_navHeaderTvName);
        mobile = (TextView)findViewById(R.id.home_navHeaderTvNumber);
        manager = getSupportFragmentManager();
        name.setText("Sagarika");
        mobile.setText("7207680006");
    }

    private void initializeDrawerAdapter(){
        drawerList.setAdapter(new NavigationDrawerAdapter(this));
    }

    private void initializeEventListeners(){
        drawerList.setOnItemClickListener(this);
    }

    @Override
    public void drawerOpen() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void hideDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void replaceFragment(int position) {
        replaceWithNewFragment(position);
    }

    private void loadDefaultFragment(){
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, new HomeFragment());
        transaction.commit();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        replaceWithNewFragment(position);
    }
    /* replace to another fragment */
    private void replaceWithNewFragment(int position) {
        transaction = manager.beginTransaction();
        switch (position){
            case 0:
                isHome = false;
                transaction.replace(R.id.content_frame, new HomeFragment());
                break;
            case 1:
                isHome = false;
                Intent intent = new Intent(this,MyCart.class);
                startActivity(intent);
//                overridePendingTransition(R.anim.anim_left_to_right, R.anim.anim_right_to_left);
                break;
            case 2:
                isHome = false;
              /*  Intent intent1 = new Intent(this,MyOrders.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.anim_left_to_right, R.anim.anim_right_to_left);*/
                break;
            case 3:
                startActivity(new Intent(this,Login.class));
                this.finish();
                break;

        }
        transaction.commit();
        hideDrawer();
    }
}
