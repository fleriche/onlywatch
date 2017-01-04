package com.onlywatch.fleriche.onlywatch.tools;

import android.view.View;

/**
 * Created by florian on 04/01/17
 */

public interface RecyclerClickListener {

    /**
     * Interface for Recycler View Click listener
     **/

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
