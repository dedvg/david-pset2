package com.example.david.david_madlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class select_story extends AppCompatActivity {
    public String file;
    public String[] files = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_story);


    }

    public void goToSecond(View v) {
        switch (v.getId()) {
            case R.id.Bsimple:
                file = files[0];
                break;
            case R.id.Btarzan:
                file = files[1];
                break;
            case R.id.Buniversity:
                file = files[2];
                break;
            case R.id.Bclothes:
                file = files[3];
                break;
            case R.id.Bdance:
                file = files[4];
                break;
        }
        Intent intent = new Intent(this, second_activity.class);
        intent.putExtra("filename", file);
        // starts the new activity
        startActivity(intent);
        finish();
    }
}