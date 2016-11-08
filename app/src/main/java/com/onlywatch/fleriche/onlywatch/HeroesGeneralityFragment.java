package com.onlywatch.fleriche.onlywatch;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
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

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.Entity.Skill;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroesGeneralityFragment extends android.support.v4.app.Fragment {
    private static final int EASY = 1;
    private static final int MEDIUM = 2;

    public HeroesGeneralityFragment() {}

    public static HeroesGeneralityFragment newInstance(int heroesid) {
        HeroesGeneralityFragment fragment = new HeroesGeneralityFragment();
        Bundle args = new Bundle();
        args.putInt("heroesId", heroesid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        TextView tvRole = (TextView) view.findViewById(R.id.role);
        ViewFlipper viewFlipperDifficulty2 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty2);
        ViewFlipper viewFlipperDifficulty3 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty3);
        TextView tvHeroSummary = (TextView) view.findViewById(R.id.heroSummary);
        LinearLayout skillsLayout = (LinearLayout) view.findViewById(R.id.skillsLayout);
        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());
        Heroes hero;
        int skillsCounter = 0;

        hm.open();
        hero = hm.getHero(heroesId);
        tvRole.setText(hero.getRole().toUpperCase());
        tvHeroSummary.setText(getStringIdentifier(getActivity(), hero.getCanonical_name()+"_summary"));

        switch (hero.getDifficulty()) {
            case EASY:
                viewFlipperDifficulty2.showNext();
                viewFlipperDifficulty3.showNext();
                break;
            case MEDIUM:
                viewFlipperDifficulty3.showNext();
                break;
            default:
                break;
        }

        ArrayList<Skill> skillsList = hm.getHeroSkills(hero.getId());
        hm.close();

        for (Skill skill : skillsList) {
            skillsCounter++;
            TextView tvSkill = new TextView(getActivity());
            tvSkill.setText(skill.getNom());
            tvSkill.setTextSize(30);
            tvSkill.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            tvSkill.setGravity(Gravity.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams skillsLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            tvSkill.setLayoutParams(skillsLayoutParams);
            skillsLayout.addView(tvSkill);

            ImageView ivSkill = new ImageView(getActivity());
            ivSkill.setImageResource(getDrawableIdentifier(getActivity(), hero.getCanonical_name()+"_skill_"+skillsCounter));
            skillsLayout.addView(ivSkill);

            TextView tvSkillSummary = new TextView(getActivity());
            tvSkillSummary.setText(skill.getDescription());
            tvSkillSummary.setTextSize(15);
            tvSkillSummary.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            tvSkillSummary.setGravity(Gravity.CENTER_HORIZONTAL);
            tvSkillSummary.setLayoutParams(skillsLayoutParams);
            skillsLayout.addView(tvSkillSummary);
        }
        return view;
    }

    private static int getStringIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }

    private static int getDrawableIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }
}

