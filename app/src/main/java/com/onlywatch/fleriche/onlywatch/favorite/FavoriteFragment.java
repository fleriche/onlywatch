package com.onlywatch.fleriche.onlywatch.favorite;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.general.ConsultActivity;
import com.onlywatch.fleriche.onlywatch.general.HelpActivity;
import com.onlywatch.fleriche.onlywatch.general.SettingsActivity;

public class FavoriteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        ActionBar toolbar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        //toolbar.setDisplayHomeAsUpEnabled(true);
        //toolbar.setDisplayShowHomeEnabled(true);
        return view;
    }
}
