package com.onlywatch.fleriche.onlywatch.medias;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.onlywatch.fleriche.onlywatch.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MediasFragment extends Fragment implements YouTubePlayer.OnFullscreenListener {
    /** The duration of the animation sliding up the video in portrait. */
    private static final int ANIMATION_DURATION_MILLIS = 300;

    /** The padding between the video list and the video in landscape orientation. */
    private static final int LANDSCAPE_VIDEO_PADDING_DP = 5;

    /** The request code when calling startActivityForResult to recover from an API service error. */
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    private View videoBox;

    private FrameLayout listFragment;
    private FrameLayout videoFragment;

    private boolean isFullscreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medias2, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.titleMediasFragment));

        listFragment = (FrameLayout) view.findViewById(R.id.videoListFragment);
        videoFragment = (FrameLayout) view.findViewById(R.id.videoFragment);

        VideoListFragment videoListFragment = new VideoListFragment();
        VideoFragment videoFragment = new VideoFragment();

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.videoListFragment, videoListFragment, "TAG_VIDEO_LIST_FRAGMENT");
        ft.replace(R.id.videoFragment, videoFragment);
        ft.addToBackStack(null);
        ft.commit();

        videoBox = view.findViewById(R.id.video_box);
        videoBox.setVisibility(View.INVISIBLE);

        getChildFragmentManager().executePendingTransactions();

        layout();

        checkYouTubeApi();

        return view;
    }

    private void checkYouTubeApi() {
        YouTubeInitializationResult errorReason =
                YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(getActivity());
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
        } else if (errorReason != YouTubeInitializationResult.SUCCESS) {
            String errorMessage =
                    String.format(getString(R.string.error_player), errorReason.toString());
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        layout();
    }

    @Override
    public void onFullscreen(boolean isFullscreen) {
        this.isFullscreen = isFullscreen;

        layout();
    }

    /**
     * Sets up the layout programatically for the three different states. Portrait, landscape or
     * fullscreen+landscape. This has to be done programmatically because we handle the orientation
     * changes ourselves in order to get fluent fullscreen transitions, so the xml layout resources
     * do not get reloaded.
     */
    private void layout() {
        boolean isPortrait =
                getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        listFragment.setVisibility(isFullscreen ? View.GONE : View.VISIBLE);
        ((VideoListFragment) getChildFragmentManager().findFragmentByTag("TAG_VIDEO_LIST_FRAGMENT")).setLabelVisibility(isPortrait);

        if (isFullscreen) {
            videoBox.setTranslationY(0); // Reset any translation that was applied in portrait.
            setLayoutSize(videoFragment, MATCH_PARENT, MATCH_PARENT);
            setLayoutSizeAndGravity(videoBox, MATCH_PARENT, MATCH_PARENT, Gravity.TOP | Gravity.LEFT);
        } else if (isPortrait) {
            setLayoutSize(listFragment, MATCH_PARENT, MATCH_PARENT);
            setLayoutSize(videoFragment, MATCH_PARENT, WRAP_CONTENT);
            setLayoutSizeAndGravity(videoBox, MATCH_PARENT, WRAP_CONTENT, Gravity.BOTTOM);
        } else {
            videoBox.setTranslationY(0); // Reset any translation that was applied in portrait.
            int screenWidth = dpToPx(getResources().getConfiguration().screenWidthDp);
            setLayoutSize(listFragment, screenWidth / 4, MATCH_PARENT);
            int videoWidth = screenWidth - screenWidth / 4 - dpToPx(LANDSCAPE_VIDEO_PADDING_DP);
            setLayoutSize(videoFragment, videoWidth, WRAP_CONTENT);
            setLayoutSizeAndGravity(videoBox, videoWidth, WRAP_CONTENT,
                    Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        }
    }

    /**
     * Fragment permettant de montrer une liste de vidéos en chargeant les thumbnails(vignettes) de chaque vidéo.
     */
    public static final class VideoListFragment extends ListFragment {

        private static final List<MediasFragment.VideoEntry> VIDEO_LIST;
        static {
            List<MediasFragment.VideoEntry> list = new ArrayList<MediasFragment.VideoEntry>();
            list.add(new MediasFragment.VideoEntry("Overwatch Trailer", "FqnKB22pOC0"));
            list.add(new MediasFragment.VideoEntry("Overwatch Animated Short | “Dragons”", "oJ09xdxzIJQ"));
            list.add(new MediasFragment.VideoEntry("Overwatch Animated Short | “Hero”", "cPRRupAM4DI"));
            list.add(new MediasFragment.VideoEntry("Overwatch Animated Short | “Recall”", "sB5zlHMsM7k"));
            list.add(new MediasFragment.VideoEntry("Overwatch Animated Short | “Alive”", "U130wnpi-C0"));
            list.add(new MediasFragment.VideoEntry("Overwatch Animated Short | “Infiltration”", "Og5-Pm4HNlI"));
            list.add(new MediasFragment.VideoEntry("Overwatch Animated Short | “The Last Bastion”", "to8yh83jlXg"));
            VIDEO_LIST = Collections.unmodifiableList(list);
        }

        private MediasFragment.PageAdapter adapter;
        private View videoBox;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            adapter = new MediasFragment.PageAdapter(getActivity(), VIDEO_LIST);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            videoBox = getActivity().findViewById(R.id.video_box);
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            setListAdapter(adapter);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            String videoId = VIDEO_LIST.get(position).videoId;

            MediasFragment.VideoFragment videoFragment =
                    (MediasFragment.VideoFragment) getFragmentManager().findFragmentById(R.id.videoFragment);
            videoFragment.setVideoId(videoId);

            // The videoBox is INVISIBLE if no video was previously selected, so we need to show it now.
            if (videoBox.getVisibility() != View.VISIBLE) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    // Initially translate off the screen so that it can be animated in from below.
                    videoBox.setTranslationY(videoBox.getHeight());
                }
                videoBox.setVisibility(View.VISIBLE);
            }

            // If the fragment is off the screen, we animate it in.
            if (videoBox.getTranslationY() > 0) {
                videoBox.animate().translationY(0).setDuration(ANIMATION_DURATION_MILLIS);
            }
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();

            adapter.releaseLoaders();
        }

        public void setLabelVisibility(boolean visible) {
            adapter.setLabelVisibility(visible);
        }

    }

    /**
     * Adapter pour la liste de vidéos. Permet de gérer les YouTubeThumbnailViews en les initialisant une
     * seule fois et en gardant un loader pour chacune d'entre elles. Lorsque la liste est détruite on
     * release les loaders.
     */
    private static final class PageAdapter extends BaseAdapter {

        private final List<MediasFragment.VideoEntry> entries;
        private final List<View> entryViews;
        private final Map<YouTubeThumbnailView, YouTubeThumbnailLoader> thumbnailViewToLoaderMap;
        private final LayoutInflater inflater;
        private final MediasFragment.PageAdapter.ThumbnailListener thumbnailListener;

        private boolean labelsVisible;

        public PageAdapter(Context context, List<MediasFragment.VideoEntry> entries) {
            this.entries = entries;
            entryViews = new ArrayList<>();
            thumbnailViewToLoaderMap = new HashMap<>();
            inflater = LayoutInflater.from(context);
            thumbnailListener = new MediasFragment.PageAdapter.ThumbnailListener();

            labelsVisible = true;
        }

        public void releaseLoaders() {
            for (YouTubeThumbnailLoader loader : thumbnailViewToLoaderMap.values()) {
                loader.release();
            }
        }

        public void setLabelVisibility(boolean visible) {
            labelsVisible = visible;
            for (View view : entryViews) {
                view.findViewById(R.id.text).setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        }

        @Override
        public int getCount() {
            return entries.size();
        }

        @Override
        public MediasFragment.VideoEntry getItem(int position) {
            return entries.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            MediasFragment.VideoEntry entry = entries.get(position);

            // There are three cases here
            if (view == null) {
                // 1) The view has not yet been created - we need to initialize the YouTubeThumbnailView.
                view = inflater.inflate(R.layout.video_list_item, parent, false);
                YouTubeThumbnailView thumbnail = (YouTubeThumbnailView) view.findViewById(R.id.thumbnail);
                thumbnail.setTag(entry.videoId);
                thumbnail.initialize(DeveloperKey.DEVELOPER_KEY, thumbnailListener);
            } else {
                YouTubeThumbnailView thumbnail = (YouTubeThumbnailView) view.findViewById(R.id.thumbnail);
                YouTubeThumbnailLoader loader = thumbnailViewToLoaderMap.get(thumbnail);
                if (loader == null) {
                    // 2) The view is already created, and is currently being initialized. We store the
                    //    current videoId in the tag.
                    thumbnail.setTag(entry.videoId);
                } else {
                    // 3) The view is already created and already initialized. Simply set the right videoId
                    //    on the loader.
                    thumbnail.setImageResource(R.drawable.loading_thumbnail);
                    loader.setVideo(entry.videoId);
                }
            }
            TextView label = ((TextView) view.findViewById(R.id.text));
            label.setText(entry.text);
            label.setVisibility(labelsVisible ? View.VISIBLE : View.GONE);
            return view;
        }

        private final class ThumbnailListener implements
                YouTubeThumbnailView.OnInitializedListener,
                YouTubeThumbnailLoader.OnThumbnailLoadedListener {

            @Override
            public void onInitializationSuccess(
                    YouTubeThumbnailView view, YouTubeThumbnailLoader loader) {
                loader.setOnThumbnailLoadedListener(this);
                thumbnailViewToLoaderMap.put(view, loader);
                view.setImageResource(R.drawable.loading_thumbnail);
                String videoId = (String) view.getTag();
                loader.setVideo(videoId);
            }

            @Override
            public void onInitializationFailure(
                    YouTubeThumbnailView view, YouTubeInitializationResult loader) {
                view.setImageResource(R.drawable.no_thumbnail);
            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView view, String videoId) {
            }

            @Override
            public void onThumbnailError(YouTubeThumbnailView view, YouTubeThumbnailLoader.ErrorReason errorReason) {
                view.setImageResource(R.drawable.no_thumbnail);
            }
        }

    }

    /**
     * Fragment permettant de montrer une vidéo youtube.
     */
    public static final class VideoFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener {

        private YouTubePlayer player;
        private String videoId;

        public static MediasFragment.VideoFragment newInstance() {
            return new MediasFragment.VideoFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            initialize(DeveloperKey.DEVELOPER_KEY, this); //set la clé développeur récup sur google console
        }

        @Override
        public void onDestroy() {
            if (player != null) {
                player.release(); //quand le fragment est détruit, on a plus besoin du player donc on le release.
            }
            super.onDestroy();
        }

        /**
         * Permet de set l'id de la vidéo que le l'on souhaite regarder dans le player.
         * @param videoId Id de la vidéo à lire.
         */
        public void setVideoId(String videoId) {
            if (videoId != null && !videoId.equals(this.videoId)) { //si change de vidéo on la récupère
                this.videoId = videoId;
                if (player != null) { //on la récupère seulement si le player est non nul ie pas de problèmes
                    player.cueVideo(videoId);
                }
            }
        }

        /**
         * Mettre le player et donc la vidéo en pause.
         */
        public void pause() {
            if (player != null) {
                player.pause();
            }
        }

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean restored) {
            this.player = player;
            player.setFullscreenControlFlags(0);
            player.setOnFullscreenListener((MediasFragment) getParentFragment()); //appelle layout et set le boolean à true
            if (!restored && videoId != null) {
                player.cueVideo(videoId);
            }
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
            this.player = null;
        }

    }

    /**
     * Entité représentant une vidéo (titre et id).
     */
    private static final class VideoEntry {
        private final String text;
        private final String videoId;

        public VideoEntry(String text, String videoId) {
            this.text = text;
            this.videoId = videoId;
        }
    }

    // Méthodes utilisées pour le layouting.

    /**
     * Permet de convertir les dp en px.
     * @param dp Le nombre de dp que l'on souhaite convertir.
     * @return int Le nombre de px convertis.
     */
    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * Permet de définir les paramètre Width et Height pour une vue donnée.
     * @param view La vue dont on souhaite définir les paramètres.
     * @param width Valeur pour width (largeur).
     * @param height Valeur pour height (hauteur).
     */
    private static void setLayoutSize(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

    /**
     * Permet de définir les paramètre Width et Height pour une vue donnée ainsi que sa gravité.
     * @param view La vue dont on souhaite définir les paramètres.
     * @param width Valeur pour width (largeur).
     * @param height Valeur pour height (hauteur).
     * @param gravity Valeur pour gravity.
     */
    private static void setLayoutSizeAndGravity(View view, int width, int height, int gravity) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        params.gravity = gravity;
        view.setLayoutParams(params);
    }
}
