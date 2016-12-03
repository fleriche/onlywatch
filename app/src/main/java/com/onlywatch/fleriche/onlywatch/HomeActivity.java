package com.onlywatch.fleriche.onlywatch;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.onlywatch.fleriche.onlywatch.drawer.DrawerAdapter;
import com.onlywatch.fleriche.onlywatch.drawer.NavigationDrawer;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;
import com.onlywatch.fleriche.onlywatch.maps.MapsListFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ActionBarDrawerToggle mDrwDrawerToggle;
    private DrawerLayout mDrwDrawerLayout;
    private ListView mDrwDrawerList;
    private static final int MENU_GAME = 1;
    private static final int MENU_HEROES = 2;
    private static final int MENU_MAPS = 3;
    private static final int MENU_MEDIAS = 4;
    private static final int MENU_PROFILE = 6;
    private static final int MENU_FAVORITES = 7;
    private static final int MENU_PARAMETERS = 9;
    private static final int MENU_LANGUAGES = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*Déclarations*/
        Toolbar toolbar = (Toolbar)findViewById(R.id.heroToolbar);
        String[] drwMenuTitles = getResources().getStringArray(R.array.strArrDrawerList);
        TypedArray drwMenuIcons = getResources().obtainTypedArray(R.array.arrDrawerListIcon);
        ArrayList<Object> drwDrawerItems = new ArrayList<>();
        View header = getLayoutInflater().inflate(R.layout.drawer_header, null);
        DrawerAdapter drwDrawerAdapter;
        GameFragment fragment = new GameFragment();

        setSupportActionBar(toolbar);

        /*Construction du contenu du Menu Drawer*/
        for(int i = 0; i < drwMenuTitles.length; i++) {
            if(drwMenuTitles[i].equals(getResources().getString(R.string.strProfile)) || drwMenuTitles[i].equals(getResources().getString(R.string.strSettings)))
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
        mDrwDrawerToggle = new ActionBarDrawerToggle(this, mDrwDrawerLayout, toolbar, R.string.strOpenDrawer , R.string.strCloseDrawer);
        mDrwDrawerLayout.addDrawerListener(mDrwDrawerToggle);
        mDrwDrawerToggle.syncState();

        /*On charge le fragment game en premier pour l'accueil*/
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Toast toast;
        switch (menuItem.getItemId()) {
            case R.id.tlbSettings:
                toast = Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT);
                toast.show();
            case R.id.tlbHelp:
                toast = Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT);
                toast.show();
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

        private void selectItem(int position) {
            HeroesListFragment fragment = null;
            MapsListFragment mapFragment = null;
            GameFragment gameFragment = null;

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
                case MENU_MEDIAS:
                    Toast.makeText(getApplicationContext(), "Medias", Toast.LENGTH_SHORT).show();
                    break;
                case MENU_PROFILE:
                    Toast.makeText(getApplicationContext(), "Profil", Toast.LENGTH_SHORT).show();
                    break;
                case MENU_FAVORITES:
                    Toast.makeText(getApplicationContext(), "Favoris", Toast.LENGTH_SHORT).show();
                    break;
                case MENU_PARAMETERS:
                    Toast.makeText(getApplicationContext(), "Paramètres", Toast.LENGTH_SHORT).show();
                    break;
                case MENU_LANGUAGES:
                    getApplicationContext().deleteDatabase("onlywatch.db");
                    Toast.makeText(getApplicationContext(), "Langues", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if (fragment != null)
                fragmentTransaction.replace(R.id.frame, fragment);

            if (gameFragment != null)
                fragmentTransaction.replace(R.id.frame, gameFragment);

            if (mapFragment != null)
                fragmentTransaction.replace(R.id.frame, mapFragment);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            mDrwDrawerList.setItemChecked(position, true);
            mDrwDrawerLayout.closeDrawer(mDrwDrawerList);
        }
    }
}
