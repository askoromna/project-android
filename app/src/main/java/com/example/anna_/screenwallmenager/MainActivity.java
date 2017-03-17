package com.example.anna_.screenwallmenager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import static com.example.anna_.screenwallmenager.R.color.LightBlue;


public class MainActivity extends AppCompatActivity {

    boolean paused = true;
    boolean repeat = false;
    boolean shuffle = false;
    boolean volume_off = false;
    boolean picture_selected = false;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createList();

    }


    public void createList (){
        ListView myListView = (ListView)findViewById(R.id.videoList);
        ArrayList<String> myStringArray1 = new ArrayList<String>();
        for (int i=1; i<21; i++){
            myStringArray1.add("Video number:  "+ i);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray1);

        myListView.setAdapter(adapter);
    }


    public void select_picture (View v) {
        ImageButton button = (ImageButton)v;
        TextView label = (TextView)v;
        if (picture_selected) {
//            button.setBackgroundDrawable(getResources().getDrawable(R.color.ShinyOrange));
            button.setImageResource(R.mipmap.picture);
//            label.setTextColor(getResources().getDrawable(R.color.LightBlue));
            picture_selected = false;
        }

        else if (!picture_selected) {
            button.setImageResource(R.mipmap.picture_selected);
            picture_selected = true;
        }

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


    public void stop(View v) {

    }

    public void pause(View v) {

    }

    public void forward(View v) {

    }

    public void backward(View v) {

    }

}


