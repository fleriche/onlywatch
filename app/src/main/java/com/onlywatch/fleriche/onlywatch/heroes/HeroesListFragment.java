package com.onlywatch.fleriche.onlywatch.heroes;

import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.HomeActivity;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import java.util.ArrayList;
import java.util.List;

public class HeroesListFragment extends Fragment implements SearchView.OnQueryTextListener {
    private HeroesManager mHeroesManager;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.cardList);
        GridLayoutManager gridLayoutManager;
        mHeroesManager = new HeroesManager(getActivity());

        setHasOptionsMenu(true);

        // 2 colones de Cardviews si mode portrait ou 3 si mode paysage
        gridLayoutManager = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? new GridLayoutManager(getActivity(), 2): new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        // Liste contenant tous les héros
        mHeroesManager.open();
        HeroesRecyclerAdapter hra = new HeroesRecyclerAdapter(mHeroesManager.getHeroes(), getActivity());
        mRecyclerView.setAdapter(hra);
        mHeroesManager.close();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem searchItem = menu.findItem(R.id.tlbSearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchItem.setVisible(true);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mHeroesManager.open();
        HeroesRecyclerAdapter hra;
        hra = !query.isEmpty() ? new HeroesRecyclerAdapter(mHeroesManager.getHeroes(query), getActivity()) : new HeroesRecyclerAdapter(mHeroesManager.getHeroes(), getActivity());
        mRecyclerView.setAdapter(hra);
        mHeroesManager.close();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
