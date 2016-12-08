package com.onlywatch.fleriche.onlywatch.general;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;
import com.onlywatch.fleriche.onlywatch.maps.MapsListFragment;

import java.util.HashMap;

public class GameFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout mSliderLayout;

    public GameFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game, container, false);
        HashMap<String, Integer> imgMap = new HashMap<>();

        mSliderLayout = (SliderLayout)view.findViewById(R.id.slider);

        imgMap.put("D.Va", R.drawable.dva);
        imgMap.put("Tracer", R.drawable.tracer);
        imgMap.put(getString(R.string.strMaps), R.drawable.hanamura);
        imgMap.put(getString(R.string.strHeroes), R.drawable.heroes);

        for(String name : imgMap.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(name)
                    .image(imgMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this)
            ;

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            mSliderLayout.addSlider(textSliderView);
        }

        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion); //Animation lorsqu'on passe d'une image à l'autre
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom); //Le label qui apparaît sur l'image
        mSliderLayout.setCustomAnimation(new DescriptionAnimation()); //Animation du label qui s'affiche avec l'image, new DescriptionAnimation() par défaut
        mSliderLayout.setDuration(4000); //Durée avant changement automatique d'une image
        mSliderLayout.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment;
        if((slider.getBundle().get("extra")+"").equals(getString(R.string.strHeroes))) {
            fragment = new HeroesListFragment();
        } else if((slider.getBundle().get("extra")+"").equals(getString(R.string.strMaps))) {
            fragment = new MapsListFragment();
        } else {
            fragment = new HeroesListFragment();
        }

        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onStop() {
        mSliderLayout.stopAutoCycle(); // Pour éviter fuite mémoire
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
