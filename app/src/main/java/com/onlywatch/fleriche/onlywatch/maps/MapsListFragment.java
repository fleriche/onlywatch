package com.onlywatch.fleriche.onlywatch.maps;

import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.MapManager;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;

public class MapsListFragment extends Fragment {
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
        GridLayoutManager gridLayoutManager;
        mMapManager = new MapManager(getActivity());
        MapRecyclerAdapter mapRecyclerAdapter;

        setHasOptionsMenu(true);

        // 2 colones de Cardviews si mode portrait ou 3 si mode paysage
        gridLayoutManager = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? new GridLayoutManager(getActivity(), 2): new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mMapManager.open();
        if(!mIsFavoriteList)
            mapRecyclerAdapter = new MapRecyclerAdapter(mMapManager.getMaps(), getActivity());
        else
            mapRecyclerAdapter = new MapRecyclerAdapter(mMapManager.getFavoriteMaps(), getActivity());
        mRecyclerView.setAdapter(mapRecyclerAdapter);
        mMapManager.close();

        return view;
    }
}
