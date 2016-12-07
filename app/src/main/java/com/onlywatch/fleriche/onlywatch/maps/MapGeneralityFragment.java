package com.onlywatch.fleriche.onlywatch.maps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlywatch.fleriche.onlywatch.R;

public class MapGeneralityFragment extends Fragment {
    private int mMapId;
    private static final String MAP_ID_ARG = "map_id";

    public MapGeneralityFragment() {
        // Required empty public constructor
    }

    public static MapGeneralityFragment newInstance(int mapId) {
        MapGeneralityFragment fragment = new MapGeneralityFragment();
        Bundle args = new Bundle();
        args.putInt(MAP_ID_ARG, mapId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMapId = getArguments().getInt(MAP_ID_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map_generality, container, false);
    }
}
