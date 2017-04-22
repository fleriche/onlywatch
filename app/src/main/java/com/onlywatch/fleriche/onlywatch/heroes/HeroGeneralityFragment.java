package com.onlywatch.fleriche.onlywatch.heroes;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.entity.Skill;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import java.util.ArrayList;

public class HeroGeneralityFragment extends android.support.v4.app.Fragment {

    private static final int EASY = 1;

    private static final int MEDIUM = 2;

    private static final String HERO_ID_ARG = "hero_id";

    private LinearLayout mSkillsLayout;

    private int mHeroesId;

    private TextView mTvRole;

    private ViewFlipper mViewFlipperDifficulty2;

    private ViewFlipper mViewFlipperDifficulty3;

    private TextView mTvHeroSummary;

    public HeroGeneralityFragment() {}

    public static HeroGeneralityFragment newInstance(int heroId) {
        HeroGeneralityFragment fragment = new HeroGeneralityFragment();
        Bundle args = new Bundle();
        args.putInt(HERO_ID_ARG, heroId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeroesId = getArguments().getInt(HERO_ID_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generality_hero, container, false);
        initView(view);
        updateView();
        return view;
    }

    private void initView(View view) {
        mTvRole = (TextView) view.findViewById(R.id.role);
        mViewFlipperDifficulty2 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty2);
        mViewFlipperDifficulty3 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty3);
        mTvHeroSummary = (TextView) view.findViewById(R.id.heroSummary);
        mSkillsLayout = (LinearLayout) view.findViewById(R.id.skillsRelativeLayout);
    }

    private void updateView() {
        HeroesManager hm = new HeroesManager(getActivity());
        hm.open();
        Heroes hero = hm.getHero(mHeroesId);
        String heroRole = "str" + hero.getRole().substring(0, 1).toUpperCase() + hero.getRole().substring(1);

        mTvRole.setText(getString(getStringIdentifier(getActivity(), heroRole)).toUpperCase());
        mTvHeroSummary.setText(getStringIdentifier(getActivity(), hero.getCanonical_name()+"_summary"));

        switch (hero.getDifficulty()) {
            case EASY:
                mViewFlipperDifficulty2.showNext();
                mViewFlipperDifficulty3.showNext();
                break;
            case MEDIUM:
                mViewFlipperDifficulty3.showNext();
                break;
            default:
                break;
        }

        buildSkills(hm.getHeroSkills(hero.getId()));
        hm.close();
    }

    private void buildSkills(ArrayList<Skill> skillsList) {
        for (Skill skill : skillsList) {

            // Linear parent Barre + Summary
            LinearLayout parentLayout = new LinearLayout(getActivity());
            LinearLayout.LayoutParams parentParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            parentParams.setMargins(0, 0, 0, dpsToPixels(10));
            parentLayout.setLayoutParams(parentParams);
            parentLayout.setOrientation(LinearLayout.HORIZONTAL);

            // Nom du skill
            TextView tvSkill = new TextView(getActivity());
            tvSkill.setText(skill.getNom());
            tvSkill.setTextSize(30);
            tvSkill.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            tvSkill.setGravity(Gravity.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams skillsLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            skillsLayoutParams.setMargins(0, 0, 0, dpsToPixels(10));
            tvSkill.setLayoutParams(skillsLayoutParams);

            // Image du skill
            ImageView ivSkill = new ImageView(getActivity());
            LinearLayout.LayoutParams ivSkillLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ivSkillLayout.setMargins(0, 0, 0, dpsToPixels(10));
            ivSkillLayout.gravity = Gravity.CENTER;
            ivSkill.setLayoutParams(ivSkillLayout);
            ivSkill.setImageResource(getDrawableIdentifier(getActivity(), skill.getCanonical_name()));

            // Résumé du skill
            TextView tvSummarySkill = new TextView(getActivity());
            tvSummarySkill.setText(skill.getDescription());
            tvSummarySkill.setTextSize(15);
            tvSummarySkill.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            tvSummarySkill.setGravity(Gravity.LEFT);
            tvSummarySkill.setLayoutParams(skillsLayoutParams);

            // Barre orange sur le côté
            View viewSkill = new View(getActivity());
            LinearLayout.LayoutParams viewSkillParams = new LinearLayout.LayoutParams(dpsToPixels(5), ViewGroup.LayoutParams.MATCH_PARENT);
            viewSkillParams.setMargins(0, 0, dpsToPixels(10), 0);
            viewSkill.setLayoutParams(viewSkillParams);
            viewSkill.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));

            //parentLayout.setLayoutParams(rlp);
            parentLayout.addView(viewSkill);
            parentLayout.addView(tvSummarySkill);
            mSkillsLayout.addView(tvSkill);
            mSkillsLayout.addView(ivSkill);
            mSkillsLayout.addView(parentLayout);
        }
    }

    private static int getStringIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }

    private static int getDrawableIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

    private int dpsToPixels(int dps) {
        return (int)(dps * getContext().getResources().getDisplayMetrics().density + 0.5f);
    }
}

