package com.hazimfenjan.musicalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Button that shows Morning and Night Music.
        Button morning = findViewById(R.id.morning);
        Button night = findViewById(R.id.night);

        // Set a click listener on the Morning Button
        morning.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Morning Button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link MorningActivity}
                Intent morningIntent = new Intent(MainActivity.this, MorningActivity.class);
                // Start the new activity
                startActivity(morningIntent);
            }
        });

        // Set a click listener on the Night Button
        night.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Night Button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NightActivity}
                Intent nightIntent = new Intent(MainActivity.this,NightActivity.class);
                // Start the new activity
                startActivity(nightIntent);
            }
        });


    }
}
