package com.onlywatch.fleriche.onlywatch.general;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

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
    private ListView mDrwDrawerList;

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
        Button btnBuy = (Button) view.findViewById(R.id.btnBuy);
        mDrwDrawerList = (ListView) getActivity().findViewById(R.id.drwLvDrawerList);

        mSliderLayout = (SliderLayout)view.findViewById(R.id.slider);

        imgMap.put(getString(R.string.strSkills), R.drawable.skill);
        imgMap.put(getString(R.string.strMaps), R.drawable.cartes);
        imgMap.put(getString(R.string.strHeroes), R.drawable.heros);

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

        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage); //Animation lorsqu'on passe d'une image à l'autre
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom); //Le label qui apparaît sur l'image
        mSliderLayout.setCustomAnimation(new DescriptionAnimation()); //Animation du label qui s'affiche avec l'image, new DescriptionAnimation() par défaut
        mSliderLayout.setDuration(4000); //Durée avant changement automatique d'une image
        mSliderLayout.addOnPageChangeListener(this);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlBuy)));
                startActivity(browserIntent);
            }
        });

        return view;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment;
        if((slider.getBundle().get("extra")+"").equals(getString(R.string.strHeroes))) {
            fragment = new HeroesListFragment();
            mDrwDrawerList.setItemChecked(HomeActivity.MENU_HEROES, true);
        } else if((slider.getBundle().get("extra")+"").equals(getString(R.string.strMaps))) {
            fragment = new MapsListFragment();
            mDrwDrawerList.setItemChecked(HomeActivity.MENU_MAPS, true);
        } else {
            fragment = new HeroesListFragment();
            mDrwDrawerList.setItemChecked(HomeActivity.MENU_HEROES, true);
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
    public void onPageSelected(int position) {}

    @Override
    public void onPageScrollStateChanged(int state) {}
}
