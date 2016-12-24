package com.onlywatch.fleriche.onlywatch.settings;

/**
 * Created by florian on 24/12/16
 */

public class Language {
    private String mTitle;
    private String mIsoCode;
    private int mFlag;

    public Language(String title, String isoCode, int flag) {
        this.mTitle = title;
        this.mIsoCode = isoCode;
        this.mFlag = flag;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getFlag() {
        return mFlag;
    }

    public void setFlag(int mFlag) {
        this.mFlag = mFlag;
    }

    public String getIsoCode() {
        return mIsoCode;
    }

    public void setIsoCode(String mIsoCode) {
        this.mIsoCode = mIsoCode;
    }
}
