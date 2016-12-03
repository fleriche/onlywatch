package com.onlywatch.fleriche.onlywatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.ViewFlipper;

public class HeroesFilterActivity extends AppCompatActivity implements View.OnTouchListener {
    public static final String DIFFICULTY_FILTER = "difficulty_filter";
    public static final String OFFENSE_FILTER = "offense_filter";
    public static final String TANK_FILTER = "tank_filter";
    public static final String DEFENSE_FILTER = "defense_filter";
    public static final String SUPPORT_FILTER = "support_filter";
    public static final int RESULT_HEROES_FILTER_OK = 1;
    private static final int RESULT_HEROES_FILTER_CANCELED = 2;
    private ViewFlipper viewFlipperEasy;
    private ViewFlipper viewFlipperMedium;
    private ViewFlipper viewFlipperHard;
    private ViewFlipper vfOffense;
    private ViewFlipper vfTank;
    private ViewFlipper vfDefense;
    private ViewFlipper vfSupport;
    private int mProgressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_filter);
        overridePendingTransition(R.anim.slide_up, R.anim.stay); //Animation transition slide up

        Toolbar toolbar = (Toolbar) findViewById(R.id.heroToolbar);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBarHeroFilter);
        viewFlipperEasy = (ViewFlipper) findViewById(R.id.viewFlipperDifficulty1);
        viewFlipperMedium = (ViewFlipper) findViewById(R.id.viewFlipperDifficulty2);
        viewFlipperHard = (ViewFlipper) findViewById(R.id.viewFlipperDifficulty3);
        final Button heroFilter = (Button) findViewById(R.id.btnHeroFilter);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        }

        if (seekBar != null)
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int progressValue = 0;

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    progressValue = progress;

                    if (progress == 0) {
                        viewFlipperEasy.setDisplayedChild(0);
                        viewFlipperMedium.setDisplayedChild(0);
                        viewFlipperHard.setDisplayedChild(0);
                    } else if (progress > 0 && progress < 20) {
                        if (viewFlipperEasy.getDisplayedChild() == 0)
                            viewFlipperEasy.showNext();
                        if (viewFlipperMedium.getDisplayedChild() == 1)
                            viewFlipperMedium.showNext();
                        if (viewFlipperHard.getDisplayedChild() == 1)
                            viewFlipperHard.showNext();
                    } else if (progress >= 20 && progress < 40) {
                        if (viewFlipperEasy.getDisplayedChild() == 0)
                            viewFlipperEasy.showNext();
                        if (viewFlipperMedium.getDisplayedChild() == 0)
                            viewFlipperMedium.showNext();
                        if (viewFlipperHard.getDisplayedChild() == 1)
                            viewFlipperHard.showNext();
                    } else {
                        if (viewFlipperEasy.getDisplayedChild() == 0)
                            viewFlipperEasy.showNext();
                        if (viewFlipperMedium.getDisplayedChild() == 0)
                            viewFlipperMedium.showNext();
                        if (viewFlipperHard.getDisplayedChild() == 0)
                            viewFlipperHard.showNext();
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    mProgressValue = progressValue;
                }
            });

        if (heroFilter != null)
            heroFilter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra(DIFFICULTY_FILTER, mProgressValue);
                    intent.putExtra(OFFENSE_FILTER, vfOffense.getDisplayedChild());
                    intent.putExtra(TANK_FILTER, vfTank.getDisplayedChild());
                    intent.putExtra(DEFENSE_FILTER, vfDefense.getDisplayedChild());
                    intent.putExtra(SUPPORT_FILTER, vfSupport.getDisplayedChild());
                    setResult(RESULT_HEROES_FILTER_OK, intent);
                    finish();
                    overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
                }
            });

        vfOffense = (ViewFlipper) findViewById(R.id.viewFlipperOffense);
        vfTank = (ViewFlipper) findViewById(R.id.viewFlipperTank);
        vfDefense = (ViewFlipper) findViewById(R.id.viewFlipperDefense);
        vfSupport = (ViewFlipper) findViewById(R.id.viewFlipperSupport);
        if(vfOffense != null)
            vfOffense.setOnTouchListener(this);
        if(vfTank != null)
            vfTank.setOnTouchListener(this);
        if(vfDefense != null)
            vfDefense.setOnTouchListener(this);
        if(vfSupport != null)
            vfSupport.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ((ViewFlipper) v).showNext();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_HEROES_FILTER_CANCELED, intent);
        super.onBackPressed();
        overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent();
            setResult(RESULT_HEROES_FILTER_CANCELED, intent);
            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
        }
        return super.onOptionsItemSelected(item);
    }
}
