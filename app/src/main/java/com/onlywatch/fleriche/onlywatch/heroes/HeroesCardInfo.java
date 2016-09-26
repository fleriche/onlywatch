package com.onlywatch.fleriche.onlywatch.heroes;

import android.support.v7.widget.CardView;
import android.widget.ImageView;

public class HeroesCardInfo {
    private String mName;
    private Boolean mIsBackVisible = false;
    private CardView mCardViewFront;
    private CardView mCardViewBack;
    private ImageView mImageView;
    private Boolean mClicked = false;
    public static final String NAME_PREFIX = "Name_";

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setIsBackVisible(Boolean isBackVisible) {
        this.mIsBackVisible = isBackVisible;
    }

    public Boolean getIsBackVisible() {
        return mIsBackVisible;
    }

    public CardView getCardViewFront() {
        return mCardViewFront;
    }

    public void setCardViewFront(CardView mCardViewFront) {
        this.mCardViewFront = mCardViewFront;
    }

    public CardView getCardViewBack() {
        return mCardViewBack;
    }

    public void setCardViewBack(CardView mCardViewBack) {
        this.mCardViewBack = mCardViewBack;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView mImageView) {
        this.mImageView = mImageView;
    }

    public Boolean getClicked() {
        return mClicked;
    }

    public void setClicked(Boolean mClicked) {
        this.mClicked = mClicked;
    }
}