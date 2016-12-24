package com.onlywatch.fleriche.onlywatch.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.onlywatch.fleriche.onlywatch.R;

public class MapsFilterActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int RESULT_MAPS_FILTER_OK = 1;
    private static final int RESULT_MAPS_FILTER_CANCELED = 2;
    public static final String ASSAULT_FILTER = "assault_filter";
    public static final String CONTROL_FILTER = "control_filter";
    public static final String ESCORT_FILTER = "escort_filter";
    public static final String HYBRID_FILTER = "hybrid_filter";
    private ViewFlipper mVfAssault;
    private ViewFlipper mVfControl;
    private ViewFlipper mVfEscort;
    private ViewFlipper mVfHybrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_filter);
        overridePendingTransition(R.anim.slide_up, R.anim.stay); //Animation transition slide up

        Toolbar toolbar = (Toolbar) findViewById(R.id.heroToolbar);
        final Button mapFilter = (Button) findViewById(R.id.btnMapFilter);
        mVfAssault = (ViewFlipper) findViewById(R.id.viewFlipperAssault);
        mVfControl = (ViewFlipper) findViewById(R.id.viewFlipperControl);
        mVfEscort = (ViewFlipper) findViewById(R.id.viewFlipperEscort);
        mVfHybrid = (ViewFlipper) findViewById(R.id.viewFlipperHybrid);
        if(mVfAssault != null)
            mVfAssault.setOnClickListener(this);
        if(mVfControl != null)
            mVfControl.setOnClickListener(this);
        if(mVfEscort != null)
            mVfEscort.setOnClickListener(this);
        if(mVfHybrid != null)
            mVfHybrid.setOnClickListener(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        }

        if (mapFilter != null)
            mapFilter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra(ASSAULT_FILTER, mVfAssault.getDisplayedChild());
                    intent.putExtra(CONTROL_FILTER, mVfControl.getDisplayedChild());
                    intent.putExtra(ESCORT_FILTER, mVfEscort.getDisplayedChild());
                    intent.putExtra(HYBRID_FILTER, mVfHybrid.getDisplayedChild());
                    setResult(RESULT_MAPS_FILTER_OK, intent);
                    finish();
                    overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
                }
            });
    }

    @Override
    public void onClick(View v) {
        ((ViewFlipper) v).showNext();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_MAPS_FILTER_CANCELED, intent);
        super.onBackPressed();
        overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent();
            setResult(RESULT_MAPS_FILTER_CANCELED, intent);
            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down); //Animation transition slide down
        }
        return super.onOptionsItemSelected(item);
    }
}
