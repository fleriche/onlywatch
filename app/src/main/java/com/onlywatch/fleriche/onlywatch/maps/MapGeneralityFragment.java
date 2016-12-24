package com.onlywatch.fleriche.onlywatch.maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.MapManager;
import com.onlywatch.fleriche.onlywatch.entity.Map;

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
        View view = inflater.inflate(R.layout.fragment_map_generality, container, false);

        TextView tvMapName = (TextView) view.findViewById(R.id.mapNameMapGenerality);
        TextView tvLocation = (TextView) view.findViewById(R.id.locationMapGenerality);
        TextView tvGameMode = (TextView) view.findViewById(R.id.gameModeMapGenerality);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescriptionMapGenerality);
        TextView tvBackground = (TextView) view.findViewById(R.id.tvBackgroundMapGenerality);
        MapManager mapManager = new MapManager(getActivity());
        Map map;

        mapManager.open();
        map = mapManager.getMap(mMapId);
        tvMapName.setText(map.getNom());
        tvLocation.setText(map.getLocation());
        tvGameMode.setText(map.getGamemode());
        tvDescription.setText(map.getDescription());
        tvBackground.setText(map.getBackground());
        mapManager.close();

        return view;
    }
}
