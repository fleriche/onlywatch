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

public class MapsListFragment extends Fragment {
    private MapManager mMapManager;
    private RecyclerView mRecyclerView;

    public MapsListFragment() {}

    /*public static MapsListFragment newInstance(String param1, String param2) {

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mapCardList);
        GridLayoutManager gridLayoutManager;
        mMapManager = new MapManager(getActivity());

        setHasOptionsMenu(true);

        // 2 colones de Cardviews si mode portrait ou 3 si mode paysage
        gridLayoutManager = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? new GridLayoutManager(getActivity(), 2): new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mMapManager.open();
        MapRecyclerAdapter mapRecyclerAdapter = new MapRecyclerAdapter(mMapManager.getMaps(), getActivity());
        mRecyclerView.setAdapter(mapRecyclerAdapter);
        mMapManager.close();

        return view;
    }
}
