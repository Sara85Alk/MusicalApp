package com.hazimfenjan.musicalapp;

public class Music {

    // Name of the Music.
    private String mMusicName;
    // Name of the Music artist.
    private String mArtistName;
    // Drawable resource ID (image of artist).
    private int mImageArtist;
    // raw resource ID (mp3. file of Music)
    private int mAudioFile;

    //Create a new Music object.

    public Music(String sName, String artName, int imageArtist, int AudioFile) {
        mMusicName = sName;
        mArtistName = artName;
        mImageArtist = imageArtist;
        mAudioFile = AudioFile;
    }

    // Get the name of the Music.
    public String getMusicName() {
        return mMusicName;
    }

    // Get the name of the Music Artist
    public String getArtistName() {
        return mArtistName;
    }

    // Get the image resource of the artist.
    public int ImageArtist() {
        return mImageArtist;
    }

    // Get the audio file resource of the Music .
    public int getmAudioFile() {
        return mAudioFile;
    }
}
