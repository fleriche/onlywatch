package com.onlywatch.fleriche.onlywatch.maps;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
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

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.MapManager;
import com.onlywatch.fleriche.onlywatch.entity.Map;

import java.lang.reflect.Field;
import java.util.List;

public class MapsListFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final int REQUEST_CODE_MAPS_FILTER = 1;
    private static final String ONLY_FAVORITE = "only_favorite";
    private boolean mIsFavoriteList = false;
    private MapManager mMapManager;
    private RecyclerView mRecyclerView;

    public MapsListFragment() {}

    public static MapsListFragment newInstance(boolean onlyFavoriteHeroes) {
        MapsListFragment fragment = new MapsListFragment();
        Bundle args = new Bundle();
        args.putBoolean(ONLY_FAVORITE, onlyFavoriteHeroes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIsFavoriteList = getArguments().getBoolean(ONLY_FAVORITE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mapCardList);
        TextView noFavorites = (TextView) view.findViewById(R.id.tvNoFavoritesMaps);
        GridLayoutManager gridLayoutManager;
        mMapManager = new MapManager(getActivity());
        MapRecyclerAdapter mapRecyclerAdapter;
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabMapsList);
        List<Map> mapList;

        setHasOptionsMenu(true);
        if(mIsFavoriteList)
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleFavoritesListFragment));
        else
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleMapsListFragment));

        // 2 colones de Cardviews si mode portrait ou 3 si mode paysage
        gridLayoutManager = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? new GridLayoutManager(getActivity(), 2): new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mMapManager.open();
        if(!mIsFavoriteList)
            mapList = mMapManager.getMaps();
        else
            mapList = mMapManager.getFavoriteMaps();
        mapRecyclerAdapter = new MapRecyclerAdapter(mapList, getActivity());
        mRecyclerView.setAdapter(mapRecyclerAdapter);
        mMapManager.close();

        if(mapList.isEmpty() && mIsFavoriteList)
            noFavorites.setVisibility(View.VISIBLE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsFilterActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MAPS_FILTER);
            }
        });

        return view;
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
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MAPS_FILTER) {
            if(resultCode == MapsFilterActivity.RESULT_MAPS_FILTER_OK) {
                int assault = data.getIntExtra(MapsFilterActivity.ASSAULT_FILTER, 0);
                int control = data.getIntExtra(MapsFilterActivity.CONTROL_FILTER, 0);
                int escort = data.getIntExtra(MapsFilterActivity.ESCORT_FILTER, 0);
                int hybrid = data.getIntExtra(MapsFilterActivity.HYBRID_FILTER, 0);
                MapManager mapManager = new MapManager(getActivity());
                mapManager.open();
                MapRecyclerAdapter mra;
                mra = new MapRecyclerAdapter(mapManager.getMapsByGamemode(assault == 1, control == 1, escort == 1, hybrid == 1, mIsFavoriteList), getActivity());
                mRecyclerView.setAdapter(mra);
                mapManager.close();
            }
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mMapManager.open();
        MapRecyclerAdapter mra;
        if(mIsFavoriteList)
            mra = !query.isEmpty() ? new MapRecyclerAdapter(mMapManager.getFavoriteMap(query), getActivity()) : new MapRecyclerAdapter(mMapManager.getFavoriteMaps(), getActivity());
        else
            mra = !query.isEmpty() ? new MapRecyclerAdapter(mMapManager.getMap(query), getActivity()) : new MapRecyclerAdapter(mMapManager.getMaps(), getActivity());
        mRecyclerView.setAdapter(mra);
        mMapManager.close();
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
