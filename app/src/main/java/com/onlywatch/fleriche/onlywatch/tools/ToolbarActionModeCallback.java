package com.onlywatch.fleriche.onlywatch.tools;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.general.HomeActivity;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesListFragment;
import com.onlywatch.fleriche.onlywatch.heroes.HeroesRecyclerAdapter;

/**
 * Created by florian on 04/01/17
 */

public class ToolbarActionModeCallback implements ActionMode.Callback {
    private Context context;
    private HeroesRecyclerAdapter recyclerView_adapter;

    public ToolbarActionModeCallback(Context context, HeroesRecyclerAdapter recyclerView_adapter) {
        this.context = context;
        this.recyclerView_adapter = recyclerView_adapter;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.action_mode, menu);//Inflate the menu over action mode
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

        //Sometimes the meu will not be visible so for that we need to set their visibility manually in this method
        //So here show action menu according to SDK Levels
        if (Build.VERSION.SDK_INT < 11) {
            MenuItemCompat.setShowAsAction(menu.findItem(R.id.actionModeDelete), MenuItemCompat.SHOW_AS_ACTION_NEVER);
        } else {
            menu.findItem(R.id.actionModeDelete).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }

        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionModeDelete:
                HomeActivity homeActivity = (HomeActivity) context;
                Fragment recyclerFragment = homeActivity.getFragmentByTag("TAG_HEROES");
                if (recyclerFragment != null)
                    ((HeroesListFragment)recyclerFragment).deleteRows();
                break;
        }
        return false;
    }


    @Override
    public void onDestroyActionMode(ActionMode mode) {
        recyclerView_adapter.removeSelection();  // remove selection
        HomeActivity homeActivity = (HomeActivity) context;
        Fragment recyclerFragment = homeActivity.getFragmentByTag("TAG_HEROES");
        if (recyclerFragment != null)
            ((HeroesListFragment) recyclerFragment).setNullToActionMode();//Set action mode null
    }
}
