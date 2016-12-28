package com.onlywatch.fleriche.onlywatch.skills;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.SkillManager;
import com.onlywatch.fleriche.onlywatch.entity.Skill;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;

import java.lang.reflect.Field;
import java.util.List;

public class SkillsListFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final int REQUEST_CODE_SKILL_FILTER = 1;
    private static final String ONLY_FAVORITE = "only_favorite";
    private boolean mIsFavoriteList = false;
    private SkillManager mSkillManager;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.skillsCardList);
        GridLayoutManager gridLayoutManager;
        mSkillManager = new SkillManager(getActivity());
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabSkillsList);
        TextView noFavorites = (TextView) view.findViewById(R.id.tvNoFavoritesSkills);
        List<Skill> skillList;

        setHasOptionsMenu(true);
        if(mIsFavoriteList)
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleFavoritesListFragment));
        else
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleAbilitiesListFragment));

        gridLayoutManager = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? new GridLayoutManager(getActivity(), 2): new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);


        mSkillManager.open();
        if(!mIsFavoriteList)
            skillList = mSkillManager.getSkills();
        else
            skillList = mSkillManager.getFavoriteSkills();
        SkillRecyclerAdapter sra = new SkillRecyclerAdapter(skillList ,getActivity());
        mSkillManager.close();

        if(skillList.isEmpty() && mIsFavoriteList)
            noFavorites.setVisibility(View.VISIBLE);

        mRecyclerView.setAdapter(sra);

        // Floating Action Button
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SkillsFilterActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SKILL_FILTER);
            }
        });*/

        return view;
    }

    public static SkillsListFragment newInstance(boolean onlyFavoriteHeroes) {
        SkillsListFragment fragment = new SkillsListFragment();
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
        mSkillManager.open();
        SkillRecyclerAdapter sra;
        if(mIsFavoriteList)
            sra = !query.isEmpty() ? new SkillRecyclerAdapter(mSkillManager.getFavoriteSkills(query), getActivity()) : new SkillRecyclerAdapter(mSkillManager.getFavoriteSkills(), getActivity());
        else
            sra = !query.isEmpty() ? new SkillRecyclerAdapter(mSkillManager.getSkills(query), getActivity()) : new SkillRecyclerAdapter(mSkillManager.getSkills(), getActivity());
        mRecyclerView.setAdapter(sra);
        mSkillManager.close();

        // Permet de cacher le clavier virtuel après avoir submit la query
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_SKILL_FILTER) {
            /*if(resultCode == SkillsFilterActivity.RESULT_SKILLS_FILTER_OK) {

            }*/
        }
    }
}
