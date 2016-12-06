package com.onlywatch.fleriche.onlywatch.general;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.MapManager;
import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;
import com.onlywatch.fleriche.onlywatch.entity.Map;
import com.onlywatch.fleriche.onlywatch.heroes.HeroGeneralityFragment;
import com.onlywatch.fleriche.onlywatch.heroes.HeroHistoryFragment;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesRecyclerAdapter;
import com.onlywatch.fleriche.onlywatch.maps.MapRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConsultActivity extends AppCompatActivity {
    public static final String TYPE_ACTIVITY_EXTRA = "type";
    private int mHeroesId;
    private int mMapId;
    private ImageView mImgToolbarCollapsing;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        Toolbar toolbar = (Toolbar)findViewById(R.id.heroToolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        Intent intent = getIntent();
        String typeActivity = intent.getStringExtra(TYPE_ACTIVITY_EXTRA);
        mImgToolbarCollapsing = (ImageView) findViewById(R.id.imgToolbarCollapsing);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        if(collapsingToolbar != null)
            collapsingToolbar.setTitleEnabled(false);

        switch (typeActivity) {
            case "hero":
                setupHero(intent);
                break;
            case "map":
                setupMap(intent);
                break;
        }

        if(tabLayout != null)
            tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupHero(Intent intent) {
        Heroes heroes;
        HeroesManager heroesManager = new HeroesManager(getApplicationContext());
        mHeroesId = intent.getIntExtra(HeroesRecyclerAdapter.HEROES_ID_EXTRA, 0);
        heroesManager.open();
        heroes = heroesManager.getHero(mHeroesId);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(heroes.getNom());

        if(mImgToolbarCollapsing != null)
            mImgToolbarCollapsing.setImageResource(getDrawableIdentifier(getApplicationContext(), heroes.getCanonical_name()));

        heroesManager.close();

        if (mViewPager != null)
            setupHeroViewPager(mViewPager);
    }

    private void setupMap(Intent intent) {
        Map map;
        MapManager mapManager = new MapManager(getApplicationContext());
        mMapId = intent.getIntExtra(MapRecyclerAdapter.MAP_ID_EXTRA, 0);
        mapManager.open();
        map = mapManager.getMap(mMapId);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(map.getNom());

        if(mImgToolbarCollapsing != null)
            mImgToolbarCollapsing.setImageResource(getDrawableIdentifier(getApplicationContext(), map.getCanonical_name()));

        mapManager.close();

        if (mViewPager != null)
            setupMapViewPager(mViewPager);
    }

    private void setupHeroViewPager(ViewPager viewPager) {
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.addTab(HeroGeneralityFragment.newInstance(mHeroesId), "Généralités");
        tabLayoutAdapter.addTab(HeroHistoryFragment.newInstance(mHeroesId), "Histoire");
        viewPager.setAdapter(tabLayoutAdapter);
    }

    private void setupMapViewPager(ViewPager viewPager) {
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.addTab(HeroGeneralityFragment.newInstance(mMapId), "Généralités");
        tabLayoutAdapter.addTab(HeroHistoryFragment.newInstance(mMapId), "Histoire");
        viewPager.setAdapter(tabLayoutAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            case R.id.tlbSettings:
                Intent settingsIntent = new Intent(ConsultActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
                overridePendingTransition(R.anim.slide_up, R.anim.stay); //Animation transition slide down
                return true;
            case R.id.tlbHelp:
                Intent helpIntent = new Intent(ConsultActivity.this, HelpActivity.class);
                startActivity(helpIntent);
                overridePendingTransition(R.anim.slide_up, R.anim.stay); //Animation transition slide down
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private static int getDrawableIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

    private static class TabLayoutAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mTabTitles = new ArrayList<>();

        public TabLayoutAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public void addTab(Fragment fragment, String title) {
            mFragments.add(fragment);
            mTabTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
