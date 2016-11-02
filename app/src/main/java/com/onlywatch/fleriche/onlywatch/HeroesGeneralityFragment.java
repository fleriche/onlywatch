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
public class HeroesGeneralityFragment extends android.support.v4.app.Fragment {
    public HeroesGeneralityFragment() {}

    public static HeroesGeneralityFragment newInstance(int heroesid) {
        HeroesGeneralityFragment fragment = new HeroesGeneralityFragment();
        Bundle args = new Bundle();
        args.putInt("heroesId", heroesid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        TextView tvRole = (TextView) view.findViewById(R.id.role);
        TextView tvDifficulty = (TextView) view.findViewById(R.id.difficulty);
        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());
        Heroes heroes;

        hm.open();
        heroes = hm.getHeroe(heroesId);
        tvRole.setText(heroes.getRole().toUpperCase());
        tvDifficulty.setText(""+heroes.getDifficulty());
        hm.close();
        return view;
    }
}

