package com.onlywatch.fleriche.onlywatch.heroes;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
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
        RelativeLayout skillsLayout = (RelativeLayout) view.findViewById(R.id.skillsRelativeLayout);
        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());
        Heroes hero;
        int skillsCounter = 0;

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

        ArrayList<Skill> skillsList = hm.getHeroSkills(hero.getId()); // Liste des skills du héro
        hm.close();

        for (Skill skill : skillsList) {
            skillsCounter++;

            // Params
            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if(skillsCounter != 0) {
                rlp.addRule(RelativeLayout.BELOW, skillsCounter - 1);
            }

            // Linear parent
            LinearLayout parentLayout = new LinearLayout(getActivity());
            parentLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            parentLayout.setOrientation(LinearLayout.HORIZONTAL);
            parentLayout.setId(skillsCounter);

            // Linear qui prendra toutes les infos du skill
            LinearLayout skillLayout = new LinearLayout(getActivity());
            skillLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            skillLayout.setOrientation(LinearLayout.VERTICAL);

            // Nom du skill
            TextView tvSkill = new TextView(getActivity());
            tvSkill.setText(skill.getNom());
            tvSkill.setTextSize(30);
            tvSkill.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            tvSkill.setGravity(Gravity.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams skillsLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            tvSkill.setLayoutParams(skillsLayoutParams);
            skillLayout.addView(tvSkill);

            // Image du skill
            ImageView ivSkill = new ImageView(getActivity());
            ivSkill.setImageResource(getDrawableIdentifier(getActivity(), hero.getCanonical_name()+"_skill_"+skillsCounter));
            skillLayout.addView(ivSkill);

            // Résumé du skill
            TextView tvSummarySkill = new TextView(getActivity());
            tvSummarySkill.setText(skill.getDescription());
            tvSummarySkill.setTextSize(15);
            tvSummarySkill.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            tvSummarySkill.setGravity(Gravity.CENTER_HORIZONTAL);
            tvSummarySkill.setLayoutParams(skillsLayoutParams);
            skillLayout.addView(tvSummarySkill);

            // Barre orange sur le côté
            View viewSkill = new View(getActivity());
            viewSkill.setLayoutParams(new ViewGroup.LayoutParams(5, ViewGroup.LayoutParams.MATCH_PARENT));
            viewSkill.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));

            parentLayout.setLayoutParams(rlp);
            parentLayout.addView(viewSkill);
            parentLayout.addView(skillLayout);
            skillsLayout.addView(parentLayout);
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

