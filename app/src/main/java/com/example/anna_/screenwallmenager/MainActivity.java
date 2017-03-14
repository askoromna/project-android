package com.example.anna_.screenwallmenager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void shuffle(View v) {


    }


    public void playClick(View v) {
        ImageButton button = (ImageButton)v;
        //if (button.getDrawable().equals( R.drawable.play_button_customized))
        //if (button.getImageAlpha() == R.drawable.pause_button_customized)
        if (paused) {
            button.setImageResource(R.drawable.play_button_customized);
            paused = false;
        }

        else if (!paused) {
            button.setImageResource(R.drawable.pause_button_customized);
            paused = true;
        }




    }

    public void stop(View v) {


    }
    public void pauseClick(View v) {



    }

    public void forward(View v) {


    }
    public void backward(View v) {


    }
    public void repeat(View v) {


    }
    public void sound(View v) {

    }
}


