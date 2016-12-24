package com.onlywatch.fleriche.onlywatch.favorite;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.general.ConsultActivity;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;
import com.onlywatch.fleriche.onlywatch.maps.MapsListFragment;

public class FavoriteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayoutFavorite);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPagerFavorite);

        setHasOptionsMenu(true); //fix le bug du searview qui disparaissait

        ConsultActivity.TabLayoutAdapter tabLayoutAdapter = new ConsultActivity.TabLayoutAdapter(getChildFragmentManager()); // magie ancestral de stackoverflow pour le bug de l'ouverture seconde fois
        tabLayoutAdapter.addTab(HeroesListFragment.newInstance(true), getString(R.string.strHeroes)); //1er onglet liste héros
        tabLayoutAdapter.addTab(MapsListFragment.newInstance(true), getString(R.string.strMaps)); //2ème onglet liste cartes
        mViewPager.setAdapter(tabLayoutAdapter);

        if(tabLayout != null)
            tabLayout.setupWithViewPager(mViewPager);

        return view;
    }
}
