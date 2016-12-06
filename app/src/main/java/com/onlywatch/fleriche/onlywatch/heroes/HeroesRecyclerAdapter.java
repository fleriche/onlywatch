package com.onlywatch.fleriche.onlywatch.heroes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.general.ConsultActivity;
import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.R;

import java.util.List;

public class HeroesRecyclerAdapter extends RecyclerView.Adapter<HeroesRecyclerAdapter.HeroesViewHolder> {
    public static final String HEROES_ID_EXTRA = "id";
    public static final String TYPE_ACTIVITY_EXTRA = "type";
    private List<Heroes> mHeroesList;
    private Context mContext;

    public HeroesRecyclerAdapter(List<Heroes> heroesList, Context context) {
        this.mHeroesList = heroesList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mHeroesList.size();
    }

    @Override
    public void onBindViewHolder(HeroesViewHolder heroesViewHolder, int position) {
        final Heroes heroes = mHeroesList.get(position);
        heroesViewHolder.mTitle.setText(heroes.getNom());
        heroesViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ConsultActivity.class);
                intent.putExtra(HEROES_ID_EXTRA, heroes.getId());
                intent.putExtra(TYPE_ACTIVITY_EXTRA, "hero");
                mContext.startActivity(intent);
            }
        });
        heroesViewHolder.mImageView.setImageResource(mContext.getResources().getIdentifier(heroes.getCanonical_name(), "drawable", mContext.getPackageName()));
    }

    @Override
    public HeroesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_heroe_front, viewGroup, false);

        ImageView imgHeroes = (ImageView)itemView.findViewById(R.id.imgHeroe);
        imgHeroes.setScaleType(ImageView.ScaleType.FIT_XY);

        return new HeroesViewHolder(itemView);
    }

    public static class HeroesViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitle;
        protected ImageView mImageView;
        protected CardView mCardView;

        public HeroesViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.title);
            mImageView = (ImageView) view.findViewById(R.id.imgHeroe);
            mCardView = (CardView) view.findViewById(R.id.cardLyFront);
        }
    }
}