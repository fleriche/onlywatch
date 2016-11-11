package com.onlywatch.fleriche.onlywatch.heroes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

public class HeroHistoryFragment extends Fragment {

    public HeroHistoryFragment() {}

    public static HeroHistoryFragment newInstance(int heroesid) {
        HeroHistoryFragment fragment = new HeroHistoryFragment();
        Bundle args = new Bundle();
        args.putInt("heroesId", heroesid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_history, container, false);
        WebView webViewHistory = (WebView)view.findViewById(R.id.webViewHistory);
        TextView tvRealName = (TextView) view.findViewById(R.id.strRealName);
        TextView tvOccupation = (TextView) view.findViewById(R.id.strOccupation);
        TextView tvBaseOperation = (TextView) view.findViewById(R.id.strBaseOperation);
        TextView tvAffiliation = (TextView) view.findViewById(R.id.strAffiliation);
        TextView tvQuote = (TextView) view.findViewById(R.id.quote);
        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());
        Heroes hero;

        hm.open();
        hero = hm.getHero(heroesId);
        webViewHistory.loadUrl("file:///android_asset/"+hero.getCanonical_name()+".html");
        tvRealName.setText(hero.getReal_name());
        tvOccupation.setText(hero.getOccupation());
        tvBaseOperation.setText(hero.getBase_of_operation());
        tvAffiliation.setText(hero.getAffiliation());
        tvQuote.setText("« "+hero.getQuote()+" »");
        hm.close();
        return view;
    }
}
