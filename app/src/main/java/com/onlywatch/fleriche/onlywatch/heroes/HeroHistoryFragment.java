package com.onlywatch.fleriche.onlywatch.heroes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;

public class HeroHistoryFragment extends Fragment {

    private WebView mWebViewHistory;

    private TextView mTvRealName;

    private TextView mTvOccupation;

    private TextView mTvBaseOperation;

    private TextView mTvAffiliation;

    private TextView mTvQuote;

    public HeroHistoryFragment() {}

    public static HeroHistoryFragment newInstance(int heroesId) {
        HeroHistoryFragment fragment = new HeroHistoryFragment();
        Bundle args = new Bundle();
        args.putInt("heroesId", heroesId);
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
        initView(view);

        int heroesId = getArguments().getInt("heroesId");
        HeroesManager hm = new HeroesManager(getActivity());

        hm.open();
        updateView(hm.getHero(heroesId));
        hm.close();
        return view;
    }

    private void initView(View view) {
        mWebViewHistory = (WebView) view.findViewById(R.id.webViewHistory);
        mTvRealName = (TextView) view.findViewById(R.id.strRealName);
        mTvOccupation = (TextView) view.findViewById(R.id.strOccupation);
        mTvBaseOperation = (TextView) view.findViewById(R.id.strBaseOperation);
        mTvAffiliation = (TextView) view.findViewById(R.id.strAffiliation);
        mTvQuote = (TextView) view.findViewById(R.id.quote);
    }

    private void updateView(Heroes hero) {
        mWebViewHistory.loadUrl("file:///android_asset/"+hero.getCanonical_name()+".html");
        mTvRealName.setText(hero.getReal_name());
        mTvOccupation.setText(hero.getOccupation());
        mTvBaseOperation.setText(hero.getBase_of_operation());
        mTvAffiliation.setText(hero.getAffiliation());
        mTvQuote.setText("« "+hero.getQuote()+" »");
    }
}
