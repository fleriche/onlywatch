package com.onlywatch.fleriche.onlywatch.heroes;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.onlywatch.fleriche.onlywatch.R;
import com.onlywatch.fleriche.onlywatch.database.HeroesManager;
import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.tools.RecyclerClickListener;
import com.onlywatch.fleriche.onlywatch.tools.RecyclerTouchListener;
import com.onlywatch.fleriche.onlywatch.tools.ToolbarActionModeCallback;

import java.lang.reflect.Field;
import java.util.List;

public class HeroesListFragment extends Fragment implements SearchView.OnQueryTextListener {

    private static final int REQUEST_CODE_HEROES_FILTER = 1;

    private static final String ONLY_FAVORITE = "only_favorite";

    private boolean mIsFavoriteList = false;

    private HeroesManager mHeroesManager;

    private RecyclerView mRecyclerView;

    private HeroesRecyclerAdapter mHra;

    private List<Heroes> mHeroesList;

    private GridLayoutManager mGridLayoutManager;

    private ActionMode mActionMode; //Action mode

    private FloatingActionButton mFab;

    private TextView mNoFavorites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes_list, container, false);
        initView(view);
        buildList();

        // Floating Action Button
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HeroesFilterActivity.class);
                startActivityForResult(intent, REQUEST_CODE_HEROES_FILTER);
            }
        });

        implementRecyclerViewClickListeners();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIsFavoriteList = getArguments().getBoolean(ONLY_FAVORITE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_HEROES_FILTER) {
            if(resultCode == HeroesFilterActivity.RESULT_HEROES_FILTER_OK) {
                int progress = data.getIntExtra(HeroesFilterActivity.DIFFICULTY_FILTER, 0);
                int offense = data.getIntExtra(HeroesFilterActivity.OFFENSE_FILTER, 0);
                int tank = data.getIntExtra(HeroesFilterActivity.TANK_FILTER, 0);
                int defense = data.getIntExtra(HeroesFilterActivity.DEFENSE_FILTER, 0);
                int support = data.getIntExtra(HeroesFilterActivity.SUPPORT_FILTER, 0);

                mRecyclerView.setAdapter(createRecyclerAdapter(progress,
                        offense,
                        tank,
                        defense,
                        support)
                );
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        try {
            MenuItem searchItem = menu.findItem(R.id.tlbSearch);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

            // Customiser le curseur
            AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(
                    android.support.v7.appcompat.R.id.search_src_text);
            Field cursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            cursorDrawableRes.setAccessible(true);
            cursorDrawableRes.set(searchTextView, R.drawable.cursor);

            searchItem.setVisible(true);
            searchView.setOnQueryTextListener(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean onQueryTextSubmit(String q) {
        mHeroesManager.open();
        HeroesRecyclerAdapter hra;
        if(mIsFavoriteList)
            hra = !q.isEmpty() ?
                    new HeroesRecyclerAdapter(mHeroesManager.getFavoriteHeroes(q), getActivity()) :
                    new HeroesRecyclerAdapter(mHeroesManager.getFavoriteHeroes(), getActivity());
        else
            hra = !q.isEmpty() ?
                    new HeroesRecyclerAdapter(mHeroesManager.getHeroes(q), getActivity()) :
                    new HeroesRecyclerAdapter(mHeroesManager.getHeroes(), getActivity());
        mRecyclerView.setAdapter(hra);
        mHeroesManager.close();

        // Permet de cacher le clavier virtuel après avoir submit la query
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mActionMode != null)
            mActionMode.finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mGridLayoutManager = new GridLayoutManager(getActivity(),
                newConfig.orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
    }

    public static HeroesListFragment newInstance(boolean onlyFavoriteHeroes) {
        HeroesListFragment fragment = new HeroesListFragment();
        Bundle args = new Bundle();
        args.putBoolean(ONLY_FAVORITE, onlyFavoriteHeroes);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Set action mode null quand on a fini de l'utiliser
     */
    public void setNullToActionMode() {
        if (mActionMode != null)
            mActionMode = null;
    }

    public void deleteRows() {
        SparseBooleanArray selected = mHra.getSelectedIds();

        //Loop all selected ids
        for (int i = (selected.size() - 1); i >= 0; i--) {
            if (selected.valueAt(i)) {
                //If current id is selected remove the item via key
                mHeroesList.remove(selected.keyAt(i));
                mHra.notifyDataSetChanged();//notify adapter
            }
        }
        Toast.makeText(getActivity(), "Coucou la Petite Chieuse !", Toast.LENGTH_SHORT).show();
        mActionMode.finish();

    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.cardList);
        mFab = (FloatingActionButton) view.findViewById(R.id.fabHeroesList);
        mNoFavorites = (TextView) view.findViewById(R.id.tvNoFavoritesHeroes);

        ((AppCompatActivity) getActivity())
                .getSupportActionBar()
                .setTitle(mIsFavoriteList ? getString(R.string.titleFavoritesListFragment)
                        : getString(R.string.titleHeroesListFragment));

        setHasOptionsMenu(true);

        // 2 colones de Cardviews si mode portrait ou 3 si mode paysage
        mGridLayoutManager = getResources()
                .getConfiguration()
                .orientation == Configuration.ORIENTATION_PORTRAIT ?
                new GridLayoutManager(getActivity(), 2) :
                new GridLayoutManager(getActivity(), 3);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
    }

    // Liste contenant tous les héros
    private void buildList() {
        mHeroesManager = new HeroesManager(getActivity());

        mHeroesManager.open();
        if(!mIsFavoriteList)
            mHeroesList = mHeroesManager.getHeroes();
        else
            mHeroesList = mHeroesManager.getFavoriteHeroes();
        mHra = new HeroesRecyclerAdapter(mHeroesList, getActivity());
        mRecyclerView.setAdapter(mHra);
        mHeroesManager.close();

        if(mHeroesList.isEmpty() && mIsFavoriteList)
            mNoFavorites.setVisibility(View.VISIBLE);

        mHra.notifyDataSetChanged();
    }

    private HeroesRecyclerAdapter createRecyclerAdapter(int progress, int offense, int tank,
                                                        int defense, int support) {
        HeroesManager heroesManager = new HeroesManager(getActivity());
        HeroesRecyclerAdapter hra;
        heroesManager.open();

        if (progress >= 0 && progress < 10) {
            hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByRoles(offense == 1, tank == 1,
                    defense == 1, support == 1, mIsFavoriteList), getActivity());
        } else if(progress >= 10 && progress < 30) {
            hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByDifficultyAndRoles(1,
                    offense == 1, tank == 1, defense == 1, support == 1, mIsFavoriteList),
                    getActivity());
        } else if(progress >= 30 && progress < 50) {
            hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByDifficultyAndRoles(2,
                    offense == 1, tank == 1, defense == 1, support == 1, mIsFavoriteList),
                    getActivity());
        } else {
            hra = new HeroesRecyclerAdapter(heroesManager.getHeroesByDifficultyAndRoles(3,
                    offense == 1, tank == 1, defense == 1, support == 1, mIsFavoriteList),
                    getActivity());
        }

        heroesManager.close();
        return hra;
    }

    //Implement item click and long click over recycler view
    private void implementRecyclerViewClickListeners() {
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                mRecyclerView, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                //If ActionMode not null select item
                if (mActionMode != null)
                    onListItemSelect(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                //Select item on long click
                onListItemSelect(position);
            }
        }));
    }

    private void onListItemSelect(int position) {
        mHra.toggleSelection(position); //Toggle the selection

        //Check if any items are already selected or not
        boolean hasCheckedItems = mHra.getSelectedCount() > 0;

        if (hasCheckedItems && mActionMode == null)
            // there are some selected items, start the actionMode
            mActionMode = ((AppCompatActivity) getActivity())
                    .startSupportActionMode(new ToolbarActionModeCallback(getActivity(), mHra));
        else if (!hasCheckedItems && mActionMode != null)
            // there no selected items, finish the actionMode
            mActionMode.finish();
        if (mActionMode != null)
            //set action mode title on item selection
            mActionMode.setTitle(String.valueOf(mHra.getSelectedCount()) + " selected");
    }
}
