package com.onlywatch.fleriche.onlywatch.heroes;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.Entity.Skill;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroGeneralityFragment extends android.support.v4.app.Fragment {
    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private LinearLayout skillsLayout;

    public HeroGeneralityFragment() {}

    public static HeroGeneralityFragment newInstance(int heroesid) {
        HeroGeneralityFragment fragment = new HeroGeneralityFragment();
        Bundle args = new Bundle();
        args.putInt("heroesId", heroesid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generality_hero, container, false);

        // Déclaration
        TextView tvRole = (TextView) view.findViewById(R.id.role);
        ViewFlipper viewFlipperDifficulty2 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty2);
        ViewFlipper viewFlipperDifficulty3 = (ViewFlipper) view.findViewById(R.id.viewFlipperDifficulty3);
        TextView tvHeroSummary = (TextView) view.findViewById(R.id.heroSummary);
        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());
        Heroes hero;

        hm.open();
        hero = hm.getHero(heroesId); // on récup le héro souhaité
        tvRole.setText(hero.getRole().toUpperCase());
        tvHeroSummary.setText(getStringIdentifier(getActivity(), hero.getCanonical_name()+"_summary"));

        // Affichage du nombre d'étoile en fonction de la difficulté
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

        skillsLayout = (LinearLayout) view.findViewById(R.id.skillsRelativeLayout);
        buildSkills(hm.getHeroSkills(hero.getId()), hero);

        hm.close();

        return view;
    }

    private void buildSkills(ArrayList<Skill> skillsList, Heroes hero) {
        int skillsCounter = 0;
        for (Skill skill : skillsList) {
            skillsCounter++;

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
            ivSkill.setImageResource(getDrawableIdentifier(getActivity(), hero.getCanonical_name()+"_skill_"+skillsCounter));

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
            skillsLayout.addView(tvSkill);
            skillsLayout.addView(ivSkill);
            skillsLayout.addView(parentLayout);
        }
    }

    private static int getStringIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }

    private static int getDrawableIdentifier(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

    private int dpsToPixels(int dps) {
        final float SCALE = getContext().getResources().getDisplayMetrics().density;
        return (int)(dps * SCALE + 0.5f);
    }
}

