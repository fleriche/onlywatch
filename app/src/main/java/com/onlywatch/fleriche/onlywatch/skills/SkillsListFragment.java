package com.onlywatch.fleriche.onlywatch.skills;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.SkillManager;

public class SkillsListFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mapCardList);
        GridLayoutManager gridLayoutManager;
        SkillManager skillManager = new SkillManager(getActivity());

        gridLayoutManager = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? new GridLayoutManager(getActivity(), 2): new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        skillManager.open();
        SkillRecyclerAdapter sra = new SkillRecyclerAdapter(skillManager.getSkills() ,getActivity());
        skillManager.close();

        mRecyclerView.setAdapter(sra);

        return view;
    }
}
