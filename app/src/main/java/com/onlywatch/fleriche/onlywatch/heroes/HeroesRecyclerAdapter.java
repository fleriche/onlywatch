package com.onlywatch.fleriche.onlywatch.heroes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
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

    //Action mode
    private SparseBooleanArray mSelectedItemsIds;

    public HeroesRecyclerAdapter(List<Heroes> heroesList, Context context) {
        this.mHeroesList = heroesList;
        this.mContext = context;
        mSelectedItemsIds = new SparseBooleanArray();
    }

    @Override
    public int getItemCount() {
        return mHeroesList.size();
    }

    @Override
    public void onBindViewHolder(HeroesViewHolder heroesViewHolder, int position) {
        final Heroes heroes = mHeroesList.get(position);
        heroesViewHolder.mTextView.setText(heroes.getNom());
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
        heroesViewHolder.mTextView.setBackgroundColor(mSelectedItemsIds.get(position) ? mContext.getResources().getColor(R.color.colorAccent) : mContext.getResources().getColor(R.color.blueOverwatch));
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

    /***
     * Methods required for do selections, remove selections, etc.
     */

    //Toggle selection methods
    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }


    //Remove selected selections
    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }


    //Put or delete selected position into SparseBooleanArray
    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);

        notifyDataSetChanged();
    }

    //Get total selected count
    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    //Return all selected ids
    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }

    public static class HeroesViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTextView;
        protected ImageView mImageView;
        protected CardView mCardView;

        public HeroesViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.title);
            mImageView = (ImageView) view.findViewById(R.id.imgHeroe);
            mCardView = (CardView) view.findViewById(R.id.cardLyFront);
        }
    }
}