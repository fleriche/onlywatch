package com.onlywatch.fleriche.onlywatch.heroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.ViewFlipper;

import com.onlywatch.fleriche.onlywatch.R;

public class HeroesFilterActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String DIFFICULTY_FILTER = "difficulty_filter";
    public static final String OFFENSE_FILTER = "offense_filter";
    public static final String TANK_FILTER = "tank_filter";
    public static final String DEFENSE_FILTER = "defense_filter";
    public static final String SUPPORT_FILTER = "support_filter";
    public static final int RESULT_HEROES_FILTER_OK = 1;
    private static final int RESULT_HEROES_FILTER_CANCELED = 2;
    private ViewFlipper mViewFlipperEasy;
    private ViewFlipper mViewFlipperMedium;
    private ViewFlipper mViewFlipperHard;
    private ViewFlipper mVfOffense;
    private ViewFlipper mVfTank;
    private ViewFlipper mVfDefense;
    private ViewFlipper mVfSupport;
    private SeekBar mSeekBar;
    private int mProgressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_filter);
        overridePendingTransition(R.anim.slide_up, R.anim.stay); //Animation transition slide up

        Toolbar toolbar = (Toolbar) findViewById(R.id.heroToolbar);
        mSeekBar = (SeekBar) findViewById(R.id.seekBarHeroFilter);
        mViewFlipperEasy = (ViewFlipper) findViewById(R.id.viewFlipperDifficulty1);
        mViewFlipperMedium = (ViewFlipper) findViewById(R.id.viewFlipperDifficulty2);
        mViewFlipperHard = (ViewFlipper) findViewById(R.id.viewFlipperDifficulty3);
        final Button heroFilter = (Button) findViewById(R.id.btnHeroFilter);

        mViewFlipperEasy.setOnClickListener(this);
        mViewFlipperMedium.setOnClickListener(this);
        mViewFlipperHard.setOnClickListener(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        }

        if (mSeekBar != null)
            mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int progressValue = 0;

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    progressValue = progress;

                    if (progress >= 0 && progress < 10) {
                        mViewFlipperEasy.setDisplayedChild(0);
                        mViewFlipperMedium.setDisplayedChild(0);
                        mViewFlipperHard.setDisplayedChild(0);
                    } else if (progress >= 10 && progress < 30) {
                        if (mViewFlipperEasy.getDisplayedChild() == 0)
                            mViewFlipperEasy.showNext();
                        if (mViewFlipperMedium.getDisplayedChild() == 1)
                            mViewFlipperMedium.showNext();
                        if (mViewFlipperHard.getDisplayedChild() == 1)
                            mViewFlipperHard.showNext();
                    } else if (progress >= 30 && progress < 50) {
                        if (mViewFlipperEasy.getDisplayedChild() == 0)
                            mViewFlipperEasy.showNext();
                        if (mViewFlipperMedium.getDisplayedChild() == 0)
                            mViewFlipperMedium.showNext();
                        if (mViewFlipperHard.getDisplayedChild() == 1)
                            mViewFlipperHard.showNext();
                    } else {
                        if (mViewFlipperEasy.getDisplayedChild() == 0)
                            mViewFlipperEasy.showNext();
                        if (mViewFlipperMedium.getDisplayedChild() == 0)
                            mViewFlipperMedium.showNext();
                        if (mViewFlipperHard.getDisplayedChild() == 0)
                            mViewFlipperHard.showNext();
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
                    intent.putExtra(OFFENSE_FILTER, mVfOffense.getDisplayedChild());
                    intent.putExtra(TANK_FILTER, mVfTank.getDisplayedChild());
                    intent.putExtra(DEFENSE_FILTER, mVfDefense.getDisplayedChild());
                    intent.putExtra(SUPPORT_FILTER, mVfSupport.getDisplayedChild());
                    setResult(RESULT_HEROES_FILTER_OK, intent);
                    finish();
                    overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
                }
            });

        mVfOffense = (ViewFlipper) findViewById(R.id.viewFlipperOffense);
        mVfTank = (ViewFlipper) findViewById(R.id.viewFlipperTank);
        mVfDefense = (ViewFlipper) findViewById(R.id.viewFlipperDefense);
        mVfSupport = (ViewFlipper) findViewById(R.id.viewFlipperSupport);
        if(mVfOffense != null)
            mVfOffense.setOnClickListener(this);
        if(mVfTank != null)
            mVfTank.setOnClickListener(this);
        if(mVfDefense != null)
            mVfDefense.setOnClickListener(this);
        if(mVfSupport != null)
            mVfSupport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ((ViewFlipper) v).showNext();
        if(v == mViewFlipperEasy) {
            mProgressValue = 20;
            mSeekBar.setProgress(mProgressValue);
        } else if(v == mViewFlipperMedium) {
            mViewFlipperEasy.showNext();
            mProgressValue = 40;
            mSeekBar.setProgress(mProgressValue);
        } else if(v == mViewFlipperHard) {
            mViewFlipperEasy.showNext();
            mViewFlipperMedium.showNext();
            mProgressValue = 60;
            mSeekBar.setProgress(mProgressValue);
        }
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
