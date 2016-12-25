package com.onlywatch.fleriche.onlywatch.skills;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.entity.Skill;
import com.onlywatch.fleriche.onlywatch.general.ConsultActivity;

import java.util.List;

/**
 * Created by florian on 24/12/16
 */

public class SkillRecyclerAdapter extends RecyclerView.Adapter<SkillRecyclerAdapter.SkillViewHolder> {
    public static final String SKILL_ID_EXTRA = "id";
    public static final String TYPE_ACTIVITY_EXTRA = "type";
    private List<Skill> mSkillList;
    private Context mContext;

    public SkillRecyclerAdapter(List<Skill> skillList, Context context) {
        this.mSkillList = skillList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mSkillList.size();
    }

    @Override
    public void onBindViewHolder(SkillViewHolder skillViewHolder, int position) {
        final Skill skill = mSkillList.get(position);
        skillViewHolder.mTitle.setText(skill.getNom());
        skillViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ConsultActivity.class);
                intent.putExtra(SKILL_ID_EXTRA, skill.getId());
                intent.putExtra(TYPE_ACTIVITY_EXTRA, "skill");
                mContext.startActivity(intent);
            }
        });
        skillViewHolder.mImageView.setImageResource(mContext.getResources().getIdentifier(skill.getCanonical_name(), "drawable", mContext.getPackageName()));
    }

    @Override
    public SkillViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_skill, viewGroup, false);

        ImageView imgHeroes = (ImageView)itemView.findViewById(R.id.imgHeroe);
        imgHeroes.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return new SkillViewHolder(itemView);
    }

    public static class SkillViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitle;
        protected ImageView mImageView;
        protected CardView mCardView;

        public SkillViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.title);
            mImageView = (ImageView) view.findViewById(R.id.imgHeroe);
            mCardView = (CardView) view.findViewById(R.id.cardLyFront);
        }
    }
}
