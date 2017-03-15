package com.example.anna_.screenwallmenager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    boolean paused = true;
    boolean repeat = false;
    boolean shuffle = false;
    boolean volume_off = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void shuffle(View v) {
        ImageButton button = (ImageButton)v;
        if (shuffle) {
            button.setImageResource(R.mipmap.shuffle);
            shuffle = false;
        }

        else if (!shuffle) {
            button.setImageResource(R.mipmap.shuffle_pressed);
            shuffle = true;
        }




    }


    public void playClick(View v) {
        ImageButton button = (ImageButton)v;
        if (paused) {
            button.setImageResource(R.drawable.pause_button_customized);
            paused = false;
        }

        else if (!paused) {
            button.setImageResource(R.drawable.play_button_customized);
            paused = true;
        }

    }

    public void stop(View v) {


    }
    public void pause(View v) {



    }

    public void forward(View v) {


    }
    public void backward(View v) {


    }
    public void repeat(View v) {
        ImageButton button = (ImageButton)v;

        if (repeat) {
            button.setImageResource(R.mipmap.repeat);
            repeat = false;
        }

        else if (!repeat) {
            button.setImageResource(R.mipmap.repeat_pressed);
            repeat = true;
        }




    }
    public void volume(View v) {
        ImageButton button = (ImageButton)v;

        if (volume_off) {
            button.setImageResource(R.drawable.volume_button_customized);
            volume_off = false;
        }
        else if (!volume_off) {
            button.setImageResource(R.drawable.volume_off_button_customized);
            volume_off = true;
        }



    }
}


