package com.example.david.david_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void select_story(View view) {

        Intent intent = new Intent(this, select_story.class);
        // starts the new activity
        startActivity(intent);


    }
}
