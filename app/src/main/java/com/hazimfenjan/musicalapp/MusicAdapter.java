package com.hazimfenjan.musicalapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    public MusicAdapter(Activity context, ArrayList<Music> morningMusic) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, morningMusic);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Songs object located at this position in the list
        Music listenSongs = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID music name.
        TextView nameTextView = listItemView.findViewById(R.id.music_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(listenSongs.getMusicName());

        // Find the TextView in the list_item.xml layout with the ID artist name.
        TextView numberTextView = listItemView.findViewById(R.id.artist_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(listenSongs.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID artist icon
        ImageView iconView = listItemView.findViewById(R.id.artist_icon);
        // Get the image resource ID from the current Songs object and
        // set the image to iconView
        iconView.setImageResource(listenSongs.ImageArtist());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}