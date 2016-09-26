package com.onlywatch.fleriche.onlywatch;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
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
import com.onlywatch.fleriche.onlywatch.test.HeroesActivity;
import com.onlywatch.fleriche.onlywatch.test.HeroesFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ActionBarDrawerToggle mDrwDrawerToggle;
    public DrawerLayout mDrwDrawerLayout;
    private ListView mDrwDrawerList;
    private Boolean mShowingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tlbLyToolbar);
        String[] drwMenuTitles = getResources().getStringArray(R.array.strArrDrawerList);
        TypedArray drwMenuIcons = getResources().obtainTypedArray(R.array.arrDrawerListIcon);
        ArrayList<Object> drwDrawerItems = new ArrayList<>();
        View header = getLayoutInflater().inflate(R.layout.drawer_header, null);
        DrawerAdapter drwDrawerAdapter;

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
        mDrwDrawerList.addHeaderView(header); //Ajout d'un Header dans le Menu Drawer
        mDrwDrawerList.setAdapter(drwDrawerAdapter);
        mDrwDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        /*Toggle pour le bouton hamburger de la toolbar*/
        mDrwDrawerLayout = (DrawerLayout) findViewById(R.id.drwLyDrawerLayout);
        mDrwDrawerToggle = new ActionBarDrawerToggle(this, mDrwDrawerLayout, toolbar, R.string.strOpenDrawer , R.string.strCloseDrawer);
        mDrwDrawerLayout.addDrawerListener(mDrwDrawerToggle);
        mDrwDrawerToggle.syncState();
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
            case R.id.tlbSearch:
                toast = Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT);
                toast.show();
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

    private void flipCard() {
        if (mShowingBack) {
            getFragmentManager().popBackStack();
            return;
        }

        mShowingBack = true;

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .replace(R.id.frame, new HeroesListFragment())
                .addToBackStack(null)
                .commit();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

        private void selectItem(int position){
            HeroesListFragment fragment = null;
            HeroesFragment fragmentHeroes = null;

            switch (position) {
                case 1:
                    Toast.makeText(getApplicationContext(), "Jeu", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    fragment = new HeroesListFragment();
                    break;
                case 3:
                    fragmentHeroes = new HeroesFragment();
                    //Intent intent = new Intent(HomeActivity.this, HeroesActivity.class);
                    //startActivity(intent);
                    //Toast.makeText(getApplicationContext(), "Sons", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(getApplicationContext(), "Medias", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(getApplicationContext(), "Profil", Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    Toast.makeText(getApplicationContext(), "Favoris", Toast.LENGTH_SHORT).show();
                    break;
                case 9:
                    Toast.makeText(getApplicationContext(), "Paramètres", Toast.LENGTH_SHORT).show();
                    break;
                case 10:
                    Toast.makeText(getApplicationContext(), "Langues", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            if (fragmentHeroes != null) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragmentHeroes);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            mDrwDrawerList.setItemChecked(position, true);
            mDrwDrawerLayout.closeDrawer(mDrwDrawerList);
        }
    }
}
