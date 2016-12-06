package com.onlywatch.fleriche.onlywatch.maps;

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
import com.onlywatch.fleriche.onlywatch.entity.Map;
import com.onlywatch.fleriche.onlywatch.general.ConsultActivity;

import java.util.List;

/**
 * Created by florian on 29/11/16
 */

public class MapRecyclerAdapter extends RecyclerView.Adapter<MapRecyclerAdapter.MapViewHolder> {
    public static final String MAP_ID_EXTRA = "id";
    public static final String TYPE_ACTIVITY_EXTRA = "type";
    private List<Map> mMapList;
    private Context mContext;

    public MapRecyclerAdapter(List<Map> maps, Context context) {
        this.mMapList = maps;
        this.mContext = context;
    }

    @Override
    public MapRecyclerAdapter.MapViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_heroe_front, viewGroup, false);

        ImageView imgMap = (ImageView)itemView.findViewById(R.id.imgHeroe);
        imgMap.setScaleType(ImageView.ScaleType.FIT_XY);

        return new MapRecyclerAdapter.MapViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MapRecyclerAdapter.MapViewHolder mapViewHolder, int position) {
        final Map map = mMapList.get(position);
        mapViewHolder.mTitle.setText(map.getNom());
        mapViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ConsultActivity.class);
                intent.putExtra(MAP_ID_EXTRA, map.getId());
                intent.putExtra(TYPE_ACTIVITY_EXTRA, "map");
                mContext.startActivity(intent);
            }
        });
        mapViewHolder.mImageView.setImageResource(mContext.getResources().getIdentifier(map.getCanonical_name(), "drawable", mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return mMapList.size();
    }

    public static class MapViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitle;
        protected ImageView mImageView;
        protected CardView mCardView;

        public MapViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.title);
            mImageView = (ImageView) view.findViewById(R.id.imgHeroe);
            mCardView = (CardView) view.findViewById(R.id.cardLyFront);
        }
    }
}
