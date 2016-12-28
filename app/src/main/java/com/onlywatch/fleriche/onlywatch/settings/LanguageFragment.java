package com.onlywatch.fleriche.onlywatch.settings;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onlywatch.fleriche.onlywatch.R;

import java.util.ArrayList;
import java.util.Locale;

public class LanguageFragment extends Fragment {
    private static final int LANGUAGE_FR = 0;
    private static final int LANGUAGE_EN = 1;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language, container, false);
        ArrayList<Language> languageList = new ArrayList<>();
        mListView = (ListView) view.findViewById(R.id.languagesList);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleLanguageFragment));

        Language fr = new Language(getString(R.string.langFr), "fr", R.drawable.fr);
        Language en = new Language(getString(R.string.langEn), "en", R.drawable.en);
        languageList.add(fr);
        languageList.add(en);

        LanguagesRecyclerAdapter lra = new LanguagesRecyclerAdapter(getActivity(), languageList);
        if(mListView != null)
            mListView.setAdapter(lra);

        String currentLanguage = Locale.getDefault().getLanguage();
        selectItem(currentLanguage);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Locale locale;
                switch (position) {
                    case LANGUAGE_FR:
                        locale = new Locale("fr");
                        break;
                    case LANGUAGE_EN:
                        locale = new Locale("en");
                        break;
                    default:
                        locale = new Locale("en");
                        break;
                }
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getActivity().getApplicationContext().getResources().updateConfiguration(config, null);

                //On refresh l'activité pour mettre la langue à jour
                getActivity().finish();
                startActivity(getActivity().getIntent());
            }
        });
        return view;
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
                mListView.setItemChecked(LANGUAGE_EN, true);
                break;
        }
    }
}
