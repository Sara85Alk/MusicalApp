package com.hazimfenjan.musicalapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class NightActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Create an ArrayList of Night Music objects
        final ArrayList<Music> nightMusic = new ArrayList<>();

        nightMusic.add(new Music(getString(R.string.n_one),getString(R.string.n_artName_one),R.drawable.nightone, R.raw.nightone));
        nightMusic.add(new Music(getString(R.string.n_tow),getString(R.string.n_artName_tow),R.drawable.nighttow, R.raw.nighttow));
        nightMusic.add(new Music(getString(R.string.n_three),getString(R.string.n_artName_three),R.drawable.nightthree, R.raw.nightthree));
        nightMusic.add(new Music(getString(R.string.n_four),getString(R.string.n_artName_four),R.drawable.nightfour, R.raw.nightfour));
        nightMusic.add(new Music(getString(R.string.n_five),getString(R.string.n_artName_five),R.drawable.nightone, R.raw.nightfive));
        nightMusic.add(new Music(getString(R.string.n_six),getString(R.string.n_artName_six),R.drawable.nightsix, R.raw.nightsix));

        // Create an MusicAdapter, whose data source is a list of
        //  Music . The adapter knows how to create list item views for each item
        // in the list.

        MusicAdapter AdaptorForList = new MusicAdapter(this, nightMusic);

        // Get a reference to the ListView, and attach the adapter to the listView.

        final ListView ListView = findViewById(R.id.list);

        ListView.setAdapter(AdaptorForList);
        // Set a Item Click Listener on that list view to play media player.
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // get position of each music in array list and save it in a variable .
                Music play = nightMusic.get(position);

                // to avoid a crash , I stop the player only if this was created before.
                if (currentPosition != position) {
                    if (mPlayer != null) {
                        mPlayer.stop();
                    }
                }
                // this would help avoiding lopping music when I click a music is already playing.so it start gian.
                if (mPlayer != null) {
                    currentPosition = position;
                    mPlayer.stop();
                }
                // start media player when I chose a music.
                mPlayer = MediaPlayer.create(NightActivity.this, play.getmAudioFile());
                mPlayer.start();
            }
        });
    }

    // stop media player when Night music.activity is close.
    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }
}
