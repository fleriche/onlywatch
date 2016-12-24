package com.onlywatch.fleriche.onlywatch.maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.MapManager;
import com.onlywatch.fleriche.onlywatch.entity.Map;

public class MapEasterEggFragment extends Fragment {
    private int mMapId;
    private static final String MAP_ID_ARG = "map_id";

    public MapEasterEggFragment() {
        // Required empty public constructor
    }

    public static MapEasterEggFragment newInstance(int mapId) {
        MapEasterEggFragment fragment = new MapEasterEggFragment();
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
        View view = inflater.inflate(R.layout.fragment_map_easter_egg, container, false);
        WebView webViewEasterEggs = (WebView) view.findViewById(R.id.webViewEasterEggs);
        MapManager mapManager = new MapManager(getActivity());
        String easterEggs;
        Map map;

        mapManager.open();
        map = mapManager.getMap(mMapId);
        easterEggs = map.getEaster_eggs();
        String html = "<html><head>"
                + "<style type=\"text/css\">body{color: #fff; background-color: rgba(19, 43, 78, 0.8);}"
                + "</style></head>"
                + "<body>"
                + easterEggs
                + "</body></html>";
        webViewEasterEggs.getSettings().setJavaScriptEnabled(true);
        webViewEasterEggs.loadData(html, "text/html", "UTF-8");
        mapManager.close();
        return view;
    }
}
