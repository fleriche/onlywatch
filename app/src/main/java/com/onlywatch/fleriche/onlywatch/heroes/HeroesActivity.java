package com.onlywatch.fleriche.onlywatch.heroes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.graphics.Palette;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import static android.R.id.primary;

public class HeroesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tlbLyToolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        Intent intent = getIntent();
        int heroesId = intent.getIntExtra(HeroesRecyclerAdapter.HEROES_ID_EXTRA, 0);
        HeroesManager heroesManager = new HeroesManager(getApplicationContext());
        Heroes heroes = new Heroes();

        heroesManager.open();
        heroes = heroesManager.getHeroe(heroesId);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if(collapsingToolbar != null)
            collapsingToolbar.setTitle(heroes.getNom());

        ImageView imgToolbar = (ImageView) findViewById(R.id.imgToolbar);
        if(imgToolbar != null)
            imgToolbar.setImageResource(R.drawable.dva);

        heroesManager.close();
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
}
