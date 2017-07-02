package com.ttapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by halya on 2/7/17.
 */

public class NavigationDrawerAdapter extends BaseAdapter {
    private Context context;
    private String[] drawerItems;
    private String[] drawerImages;
    private TypedArray menuIcons;
    public NavigationDrawerAdapter(){

    }

    public NavigationDrawerAdapter(Context context){
        this.context = context;
        Resources resources = context.getResources();
        drawerItems = resources.getStringArray(R.array.drawerItems);
//        drawerImages = resources.getStringArray(R.array.drawerImages);
    }

    @Override
    public int getCount() {
        return drawerItems.length;
    }

    @Override
    public Object getItem(int position) {
        return drawerItems[position];
    }

    public Object getDrawerIcon(int position) {
        return drawerImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nav_drawer_row, parent, false);
            holder = new ViewHolder();
            holder.notifDesc = (TextView)convertView.findViewById(R.id.nav_item_text);
//            holder.notifIcon = (ImageView)convertView.findViewById(R.id.nav_item_icon);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        try{
            holder.notifDesc.setText((String)getItem(position));
           /* String drawerIcon = (String)getDrawerIcon(position);
            if(!drawerIcon.isEmpty()) {
                holder.notifIcon.setImageResource(context.getResources().getIdentifier(drawerIcon.substring(0, drawerIcon.length()), "mipmap", context.getPackageName()));
            }*/

        }catch (Exception e){
            e.printStackTrace();
        }
        return convertView;
    }

    class ViewHolder{
        TextView notifDesc,notifName;
        ImageView notifIcon;
    }
}
