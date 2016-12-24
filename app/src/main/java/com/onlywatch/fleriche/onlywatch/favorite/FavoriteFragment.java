package com.onlywatch.fleriche.onlywatch.favorite;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.general.ConsultActivity;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;

public class FavoriteFragment extends Fragment {
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayoutFavorite);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPagerFavorite);

        ConsultActivity.TabLayoutAdapter tabLayoutAdapter = new ConsultActivity.TabLayoutAdapter(getChildFragmentManager()); // magie ancestral de stackoverflow pour le bug de l'ouverture seconde fois
        tabLayoutAdapter.addTab(HeroesListFragment.newInstance(true), getString(R.string.strHeroes));
        tabLayoutAdapter.addTab(HeroesListFragment.newInstance(true), getString(R.string.strMaps));
        mViewPager.setAdapter(tabLayoutAdapter);

        if(tabLayout != null)
            tabLayout.setupWithViewPager(mViewPager);

        return view;
    }
}
