package com.onlywatch.fleriche.onlywatch.heroes;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.R;

import java.util.List;

class HeroesRecyclerAdapter extends RecyclerView.Adapter<HeroesRecyclerAdapter.HeroesViewHolder> {

    private List<HeroesCardInfo> mHeroesList;
    private Context mContext;

    public HeroesRecyclerAdapter(List<HeroesCardInfo> heroesList, Context context) {
        this.mHeroesList = heroesList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mHeroesList.size();
    }

    @Override
    public void onBindViewHolder(HeroesViewHolder heroesViewHolder, int position) {
        final HeroesCardInfo heroesCardInfo = mHeroesList.get(position);
        heroesViewHolder.mTitle.setText(heroesCardInfo.getName());

        heroesCardInfo.setCardViewFront(heroesViewHolder.mCardViewFront);
        heroesCardInfo.setCardViewBack(heroesViewHolder.mCardViewBack);
        heroesCardInfo.setImageView(heroesViewHolder.mImageView);

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.card_flip_right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.card_flip_left_in);

        if(heroesCardInfo.getIsBackVisible()) {
            heroesCardInfo.getImageView().setImageResource(R.drawable.rsz_overwatch_logo);
        } else {
            heroesCardInfo.getImageView().setImageResource(R.drawable.rsz_dva);
        }

        heroesViewHolder.mButtonFlipFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!heroesCardInfo.getIsBackVisible()){
                    setRightOut.setTarget(heroesCardInfo.getCardViewFront());
                    setLeftIn.setTarget(heroesCardInfo.getCardViewFront());
                    setRightOut.start();
                    setLeftIn.start();
                    heroesCardInfo.getImageView().setImageResource(R.drawable.rsz_overwatch_logo);
                    heroesCardInfo.setIsBackVisible(true);
                }
                else{
                    setRightOut.setTarget(heroesCardInfo.getCardViewFront());
                    setLeftIn.setTarget(heroesCardInfo.getCardViewFront());
                    setRightOut.start();
                    setLeftIn.start();
                    heroesCardInfo.getImageView().setImageResource(R.drawable.rsz_dva);
                    heroesCardInfo.setIsBackVisible(false);
                }
            }
        });
    }

    @Override
    public HeroesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemViewFront = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_heroe_front, viewGroup, false);

        ImageView imgHeroesFront = (ImageView)itemViewFront.findViewById(R.id.imgHeroe);
        imgHeroesFront.setScaleType(ImageView.ScaleType.FIT_XY);

        return new HeroesViewHolder(itemViewFront);
    }

    public static class HeroesViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitle;
        protected Button mButtonFlipFront;
        protected CardView mCardViewFront;
        protected CardView mCardViewBack;
        protected ImageView mImageView;

        public HeroesViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.title);
            mButtonFlipFront = (Button) view.findViewById(R.id.btnFlip);
            mCardViewFront = (CardView) view.findViewById(R.id.cardLyFront);
            mCardViewBack = (CardView) view.findViewById(R.id.cardLyBack);
            mImageView = (ImageView) view.findViewById(R.id.imgHeroe);
        }
    }
}