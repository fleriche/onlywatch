package com.onlywatch.fleriche.onlywatch.drawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.R;

import java.util.ArrayList;

public class DrawerAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Object> mNavigationDrawers;
    private static final int ITEM_VIEW_TYPE_DRAWER = 0;
    private static final int ITEM_VIEW_TYPE_SEPARATOR = 1;
    private static final int ITEM_VIEW_TYPE_COUNT = 2;

    public DrawerAdapter(Context context, ArrayList<Object> NavigationDrawers){
        this.mContext = context;
        this.mNavigationDrawers = NavigationDrawers;
    }

    @Override
    public int getCount() {
        return mNavigationDrawers.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavigationDrawers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return (mNavigationDrawers.get(position) instanceof NavigationDrawer) ? ITEM_VIEW_TYPE_DRAWER : ITEM_VIEW_TYPE_SEPARATOR;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int type = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(type == ITEM_VIEW_TYPE_DRAWER ? R.layout.drawer_list : R.layout.drawer_separator, null);
        }

        if(type == ITEM_VIEW_TYPE_DRAWER) {
            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.drwIcon);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.drwTitle);

            NavigationDrawer navigationDrawer = (NavigationDrawer) mNavigationDrawers.get(position);

            imgIcon.setImageResource(navigationDrawer.getIcon());
            txtTitle.setText(navigationDrawer.getTitle());
        }

        return convertView;
    }
}
