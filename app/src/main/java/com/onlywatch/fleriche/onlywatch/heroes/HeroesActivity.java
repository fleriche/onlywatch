package com.onlywatch.fleriche.onlywatch.heroes;

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
import com.onlywatch.fleriche.onlywatch.HeroesGeneralityFragment;
import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import java.util.ArrayList;
import java.util.List;

public class HeroesActivity extends AppCompatActivity {
    public int heroesId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tlbLyToolbar);
        ImageView imgToolbar = (ImageView) findViewById(R.id.imgToolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        Intent intent = getIntent();
        heroesId = intent.getIntExtra(HeroesRecyclerAdapter.HEROES_ID_EXTRA, 0);
        HeroesManager heroesManager = new HeroesManager(getApplicationContext());
        Heroes heroes;

        heroesManager.open();
        heroes = heroesManager.getHeroe(heroesId);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(heroes.getNom());
        }

        if(collapsingToolbar != null)
            collapsingToolbar.setTitleEnabled(false);

        if(imgToolbar != null)
            imgToolbar.setImageResource(R.drawable.dva);

        heroesManager.close();

        if (viewPager != null)
            setupViewPager(viewPager);

        if(tabLayout != null)
            tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.addTab(HeroesGeneralityFragment.newInstance(heroesId), "Généralités");
        tabLayoutAdapter.addTab(HeroesGeneralityFragment.newInstance(heroesId), "Histoire");
        viewPager.setAdapter(tabLayoutAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
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
}
