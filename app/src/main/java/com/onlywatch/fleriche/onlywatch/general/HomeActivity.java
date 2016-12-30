package com.onlywatch.fleriche.onlywatch.general;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.drawer.DrawerAdapter;
import com.onlywatch.fleriche.onlywatch.drawer.NavigationDrawer;
import com.onlywatch.fleriche.onlywatch.favorite.FavoriteFragment;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;
import com.onlywatch.fleriche.onlywatch.maps.MapsListFragment;
import com.onlywatch.fleriche.onlywatch.medias.MediasFragment;
import com.onlywatch.fleriche.onlywatch.settings.HelpActivity;
import com.onlywatch.fleriche.onlywatch.settings.LanguageFragment;
import com.onlywatch.fleriche.onlywatch.settings.SettingsFragment;
import com.onlywatch.fleriche.onlywatch.skills.SkillsListFragment;

import java.util.ArrayList;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrwDrawerLayout;
    private ListView mDrwDrawerList;
    private static final int MENU_GAME = 1;
    protected static final int MENU_HEROES = 2;
    protected static final int MENU_MAPS = 3;
    protected static final int MENU_ABILITIES = 4;
    private static final int MENU_FAVORITES = 6;
    private static final int MENU_MEDIAS = 7;
    private static final int MENU_PARAMETERS = 9;
    private static final int MENU_LANGUAGES = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // On set la langue en récupérant dans les préférences utilisateurs sinon on garde par défaut
        SharedPreferences settings = getSharedPreferences(LanguageFragment.MYPREFERENCES, Context.MODE_PRIVATE);
        String language = settings.getString(LanguageFragment.LANGUAGE, "");
        if(!language.equals(""))
            setLocale(language);

        /*Déclarations*/
        Toolbar toolbar = (Toolbar)findViewById(R.id.heroToolbar);
        String[] drwMenuTitles = getResources().getStringArray(R.array.strArrDrawerList);
        TypedArray drwMenuIcons = getResources().obtainTypedArray(R.array.arrDrawerListIcon);
        ArrayList<Object> drwDrawerItems = new ArrayList<>();
        View header = getLayoutInflater().inflate(R.layout.drawer_header, null);
        DrawerAdapter drwDrawerAdapter;
        GameFragment fragment = new GameFragment();
        ActionBarDrawerToggle mDrwDrawerToggle;

        // On set l'ActionBar
        setSupportActionBar(toolbar);

        /*Construction du contenu du Menu Drawer*/
        for(int i = 0; i < drwMenuTitles.length; i++) {
            if(drwMenuTitles[i].equals(getResources().getString(R.string.strFavorites)) || drwMenuTitles[i].equals(getResources().getString(R.string.strSettings)))
                drwDrawerItems.add("separator");
            drwDrawerItems.add(new NavigationDrawer(drwMenuTitles[i], drwMenuIcons.getResourceId(i, -1)));
        }
        drwMenuIcons.recycle();
        drwDrawerAdapter = new DrawerAdapter(getApplicationContext(), drwDrawerItems);

        mDrwDrawerList = (ListView) findViewById(R.id.drwLvDrawerList);
        if(mDrwDrawerList != null) {
            mDrwDrawerList.addHeaderView(header); //Ajout d'un Header dans le Menu Drawer
            mDrwDrawerList.setAdapter(drwDrawerAdapter);
        }
        mDrwDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        /*Toggle pour le bouton hamburger de la toolbar*/
        mDrwDrawerLayout = (DrawerLayout) findViewById(R.id.drwLyDrawerLayout);
        mDrwDrawerToggle = new ActionBarDrawerToggle(this, mDrwDrawerLayout, toolbar, R.string.strOpenDrawer, R.string.strCloseDrawer);
        mDrwDrawerLayout.addDrawerListener(mDrwDrawerToggle);
        mDrwDrawerToggle.syncState();

        /*Si on est entrain de recréer l'activité (genre après changement orientation) on garde le fragment actuel sinon on charge Game pour l'accueil*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
            mDrwDrawerList.setItemChecked(MENU_GAME, true);
        }

        /*Listener sur le backstack pour mettre à jour l'item selectionner dans le drawer
        Quand un fragment est ajouté au backstack et donc que le backstack change, on met à jour l'item*/
        fragmentManager.addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        //Si y'a encore qqch dans le backstack sinon ça veut dire qu'on est revenu sur l'accueil
                        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
                            String position = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
                            if(position != null)
                                mDrwDrawerList.setItemChecked(Integer.parseInt(position), true);
                        } else {
                            mDrwDrawerList.setItemChecked(MENU_GAME, true);
                        }
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.tlbSettings:
                SettingsFragment settingsFragment = new SettingsFragment();
                settingsFragment.show(getSupportFragmentManager(), "settings");
                return true;
            case R.id.tlbHelp:
                Intent helpIntent = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(helpIntent);
                overridePendingTransition(R.anim.slide_up, R.anim.stay); //Animation transition slide down
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

        private void selectItem(int position) {
            HeroesListFragment fragment = null;
            MapsListFragment mapFragment = null;
            SkillsListFragment skillsFragment = null;
            GameFragment gameFragment = null;
            FavoriteFragment favoriteFragment = null;
            MediasFragment mediasFragment = null;
            LanguageFragment languageFragment = null;
            SettingsFragment settingsFragment = null;

            switch (position) {
                case MENU_GAME:
                    gameFragment = new GameFragment();
                    break;
                case MENU_HEROES:
                    fragment = new HeroesListFragment();
                    break;
                case MENU_MAPS:
                    mapFragment = new MapsListFragment();
                    break;
                case MENU_ABILITIES:
                    skillsFragment = new SkillsListFragment();
                    break;
                case MENU_FAVORITES:
                    favoriteFragment = new FavoriteFragment();
                    break;
                case MENU_MEDIAS:
                    mediasFragment = new MediasFragment();
                    break;
                case MENU_PARAMETERS:
                    settingsFragment = new SettingsFragment();
                    settingsFragment.show(getSupportFragmentManager(), "settings");
                    break;
                case MENU_LANGUAGES:
                    languageFragment = new LanguageFragment();
                    break;
                default:
                    break;
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if (fragment != null)
                fragmentTransaction.replace(R.id.frame, fragment);

            if (gameFragment != null)
                fragmentTransaction.replace(R.id.frame, gameFragment);

            if (mapFragment != null)
                fragmentTransaction.replace(R.id.frame, mapFragment);

            if (skillsFragment != null)
                fragmentTransaction.replace(R.id.frame, skillsFragment);

            if (favoriteFragment != null)
                fragmentTransaction.replace(R.id.frame, favoriteFragment);

            if (mediasFragment != null)
                fragmentTransaction.replace(R.id.frame, mediasFragment);

            if (languageFragment != null)
                fragmentTransaction.replace(R.id.frame, languageFragment, "TAG_LANGUAGE");

            /*on fait passer la position pour la récupérer dans le onBackStackChange pour mettre à jour l'item selectionné dans le drawer
              et on check si settingsFragment est null sinon pas besoin d'add au backstack car c'est une modal*/
            if(settingsFragment == null) {
                fragmentTransaction.addToBackStack(Integer.toString(position));
                fragmentTransaction.commit();
            }

            mDrwDrawerList.setItemChecked(position, true);
            mDrwDrawerLayout.closeDrawer(mDrwDrawerList);
        }
    }
}
