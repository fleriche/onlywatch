package com.onlywatch.fleriche.onlywatch.settings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.drawer.NavigationDrawer;

import java.util.ArrayList;

/**
 * Created by florian on 24/12/16
 */

public class LanguagesRecyclerAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Language> mLanguagesList;

    public LanguagesRecyclerAdapter(Context context, ArrayList<Language> languagesList){
        this.mContext = context;
        this.mLanguagesList = languagesList;
    }

    @Override
    public int getCount() {
        return mLanguagesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mLanguagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int type = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.language_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.flagLanguage);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.titleLanguage);

        Language language = (Language) mLanguagesList.get(position);

        imgIcon.setImageResource(language.getFlag());
        txtTitle.setText(language.getTitle());

        return convertView;
    }

}
