package com.onlywatch.fleriche.onlywatch;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ClipDrawable;
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
import android.widget.ViewFlipper;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.database.DatabaseHandler;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroesGeneralityFragment extends android.support.v4.app.Fragment {
    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;

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
        ViewFlipper viewFlipperDifficulty2 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty2);
        ViewFlipper viewFlipperDifficulty3 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty3);
        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());
        Heroes heroes;

        hm.open();
        heroes = hm.getHeroe(heroesId);
        tvRole.setText(heroes.getRole().toUpperCase());

        switch (heroes.getDifficulty()) {
            case EASY:
                viewFlipperDifficulty2.showNext();
                viewFlipperDifficulty3.showNext();
                break;
            case MEDIUM:
                viewFlipperDifficulty3.showNext();
                break;
            default:
                break;
        }
        hm.close();
        return view;
    }
}

