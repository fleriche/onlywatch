package com.onlywatch.fleriche.onlywatch.settings;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onlywatch.fleriche.onlywatch.R;

import java.util.ArrayList;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    private static final int LANGUAGE_FR = 0;
    private static final int LANGUAGE_EN = 1;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Toolbar toolbar = (Toolbar) findViewById(R.id.heroToolbar);
        ArrayList<Language> languageList = new ArrayList<>();
        mListView = (ListView) findViewById(R.id.languagesList);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.strLanguages);
        }

        Language fr = new Language("Français", "fr", R.drawable.ic_game);
        Language en = new Language("Anglais", "en", R.drawable.ic_game);
        languageList.add(fr);
        languageList.add(en);

        LanguagesRecyclerAdapter lra = new LanguagesRecyclerAdapter(this, languageList);
        if(mListView != null)
            mListView.setAdapter(lra);

        String currentLanguage = Locale.getDefault().getLanguage();
        selectItem(currentLanguage);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case LANGUAGE_FR:
                        Locale locale = new Locale("fr_FR");
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getApplicationContext().getResources().updateConfiguration(config, null);
                        break;
                    case LANGUAGE_EN:
                        Locale locales = new Locale("en");
                        Locale.setDefault(locales);
                        Configuration configs = new Configuration();
                        configs.locale = locales;
                        getApplicationContext().getResources().updateConfiguration(configs, null);
                        break;
                    default:
                        break;
                }
            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
    }
}
