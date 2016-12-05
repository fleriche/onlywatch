package com.onlywatch.fleriche.onlywatch.heroes;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.HeroesFilterActivity;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import java.lang.reflect.Field;

public class HeroesListFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final int REQUEST_CODE_HEROES_FILTER = 1;
    private HeroesManager mHeroesManager;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.cardList);
        GridLayoutManager gridLayoutManager;
        mHeroesManager = new HeroesManager(getActivity());
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabHeroesList);

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

        // Floating Action Button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HeroesFilterActivity.class);
                startActivityForResult(intent, REQUEST_CODE_HEROES_FILTER);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_HEROES_FILTER) {
            if(resultCode == HeroesFilterActivity.RESULT_HEROES_FILTER_OK) {
                int progress = data.getIntExtra(HeroesFilterActivity.DIFFICULTY_FILTER, 0);
                int offense = data.getIntExtra(HeroesFilterActivity.OFFENSE_FILTER, 0);
                int tank = data.getIntExtra(HeroesFilterActivity.TANK_FILTER, 0);
                int defense = data.getIntExtra(HeroesFilterActivity.DEFENSE_FILTER, 0);
                int support = data.getIntExtra(HeroesFilterActivity.SUPPORT_FILTER, 0);
                HeroesManager heroesManager = new HeroesManager(getActivity());
                heroesManager.open();
                HeroesRecyclerAdapter hra;

                if (progress >= 0 && progress < 10) {
                    hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByRoles(offense == 1, tank == 1, defense == 1, support == 1), getActivity());
                } else if(progress >= 10 && progress < 30) {
                    hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByDifficultyAndRoles(1, offense == 1, tank == 1, defense == 1, support == 1), getActivity());
                } else if(progress >= 30 && progress < 50) {
                    hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByDifficultyAndRoles(2, offense == 1, tank == 1, defense == 1, support == 1), getActivity());
                } else {
                    hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByDifficultyAndRoles(3, offense == 1, tank == 1, defense == 1, support == 1), getActivity());
                }
                mRecyclerView.setAdapter(hra);
                heroesManager.close();
            }
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        try {
            MenuItem searchItem = menu.findItem(R.id.tlbSearch);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

            // Customiser le curseur
            AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            Field cursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            cursorDrawableRes.setAccessible(true);
            cursorDrawableRes.set(searchTextView, R.drawable.cursor);

            searchItem.setVisible(true);
            searchView.setOnQueryTextListener(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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
