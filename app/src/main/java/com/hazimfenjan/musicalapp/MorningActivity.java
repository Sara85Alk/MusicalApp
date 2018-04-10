package com.hazimfenjan.musicalapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MorningActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Create an ArrayList of Morning Music objects
        final ArrayList<Music> morningMusic = new ArrayList<>();

        morningMusic.add(new Music(getString(R.string.m_one),getString(R.string.m_artName_one),R.drawable.mornigsix, R.raw.morningone));
        morningMusic.add(new Music(getString(R.string.m_tow),getString(R.string.m_artName_tow),R.drawable.morningfive, R.raw.morningtow));
        morningMusic.add(new Music(getString(R.string.m_three),getString(R.string.m_artName_three),R.drawable.morningfour, R.raw.morningthree));
        morningMusic.add(new Music(getString(R.string.m_four),getString(R.string.m_artName_four),R.drawable.morningtow, R.raw.morningfour));
        morningMusic.add(new Music(getString(R.string.m_five),getString(R.string.m_artName_five),R.drawable.morningone, R.raw.morningfive));
        morningMusic.add(new Music(getString(R.string.m_six),getString(R.string.m_artName_six),R.drawable.morningsix, R.raw.morningsix));

        // Create an SongsAdapter, whose data source is a list of
        //  Music . The adapter knows how to create list item views for each item
        // in the list.

        MusicAdapter AdaptorForList = new MusicAdapter(this, morningMusic);

        // Get a reference to the ListView, and attach the adapter to the listView.

        final ListView ListView = findViewById(R.id.list);

        ListView.setAdapter(AdaptorForList);
        // Set a Item Click Listener on that list view to play media player.
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // get position of each song in array list and save it in a variable .
                Music play = morningMusic.get(position);

                // to avoid a crash , I stop the player only if this was created before.

                if (currentPosition != position) {
                    if (mPlayer != null) {
                        mPlayer.stop();
                    }
                }
                // this would help avoiding lopping song when I click a music is already playing.so it start gian.
                if (mPlayer != null) {
                    currentPosition = position;
                    mPlayer.stop();
                }
                // start media player when I chose a music.
                mPlayer = MediaPlayer.create(MorningActivity.this, play.getmAudioFile());
                mPlayer.start();
            }
        });
    }

    // stop media player when Morning music.activity is close.
    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }
}
