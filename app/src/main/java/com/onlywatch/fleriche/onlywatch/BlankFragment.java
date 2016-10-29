package com.onlywatch.fleriche.onlywatch;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.database.DatabaseHandler;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        TextView tv = (TextView) view.findViewById(R.id.singe);
        //getActivity().deleteDatabase("onlywatch.db");
        HeroesManager hm = new HeroesManager(getActivity());
        hm.open();
        Heroes heroes = hm.getHeroe(19);
        tv.setText(heroes.getNom());
        hm.close();
        return view;
    }
}

