package com.onlywatch.fleriche.onlywatch.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.general.HomeActivity;

import java.util.ArrayList;
import java.util.Locale;

public class LanguageFragment extends Fragment {
    private static final int LANGUAGE_FR = 0;
    private static final int LANGUAGE_EN = 1;
    private ListView mListView;
    public static final String LANGUAGE = "LANGUAGE";
    public static final String MYPREFERENCES = "PREFS" ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language, container, false);
        ArrayList<Language> languageList = new ArrayList<>();
        mListView = (ListView) view.findViewById(R.id.languagesList);
        SharedPreferences settings = getActivity().getSharedPreferences(LanguageFragment.MYPREFERENCES, Context.MODE_PRIVATE);
        String currentLanguage = settings.getString(LanguageFragment.LANGUAGE, "");
        Language fr = new Language(getString(R.string.langFr), "fr", R.drawable.fr);
        Language en = new Language(getString(R.string.langEn), "en", R.drawable.en);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleLanguageFragment));

        languageList.add(fr);
        languageList.add(en);

        LanguagesRecyclerAdapter lra = new LanguagesRecyclerAdapter(getActivity(), languageList);
        if(mListView != null)
            mListView.setAdapter(lra);

        selectItem(currentLanguage);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences settings = getActivity().getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                switch (position) {
                    case LANGUAGE_FR:
                        setLocale("fr");
                        editor.putString(LANGUAGE, "fr");
                        break;
                    case LANGUAGE_EN:
                        setLocale("en");
                        editor.putString(LANGUAGE, "en");
                        break;
                    default:
                        setLocale("en");
                        break;
                }
                editor.apply();
            }
        });
        return view;
    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = getActivity().getIntent();
        getActivity().finish();
        startActivity(refresh);
    }

    private void selectItem(String item) {
        switch (item) {
            case "fr":
                mListView.setItemChecked(LANGUAGE_FR, true);
                break;
            case "en":
                mListView.setItemChecked(LANGUAGE_EN, true);
                break;
            default:
                break;
        }
    }
}
