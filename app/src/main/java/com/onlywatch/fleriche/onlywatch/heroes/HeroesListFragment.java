package com.onlywatch.fleriche.onlywatch.heroes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlywatch.fleriche.onlywatch.R;

import java.util.ArrayList;
import java.util.List;

public class HeroesListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        recyclerView.setLayoutManager(gridLayoutManager);

        HeroesRecyclerAdapter hra = new HeroesRecyclerAdapter(createList(30), getActivity());
        recyclerView.setAdapter(hra);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private List createList(int size) {

        List result = new ArrayList();
        for (int i=1; i <= size; i++) {
            HeroesCardInfo heroesCardInfo = new HeroesCardInfo();
            heroesCardInfo.setName(HeroesCardInfo.NAME_PREFIX + i);
            result.add(heroesCardInfo);
        }

        return result;
    }
}
