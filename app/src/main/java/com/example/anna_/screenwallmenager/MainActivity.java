package com.example.anna_.screenwallmenager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anna_.screenwallmenager.Model.*;
import  com.example.anna_.screenwallmenager.View.*;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    boolean paused = true;
    boolean repeat = false;
    boolean shuffle = false;
    boolean volume_off = false;
    boolean picture_selected = false;

    String IdAsString = "";

    Video video = new Video();

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
        myStringArray1.add("App created by: Hanna SKOROMNA,  Mohamed Koma CAMARA et Jean Mirabeau KEPATO");
        for (int i=1; i<21; i++){
            myStringArray1.add("Video number:  "+ i);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray1);

        myListView.setAdapter(adapter);
    }


    public void select_picture (View v) {
        ImageButton button = (ImageButton)v;
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        IdAsString = button.getResources().getResourceName(button.getId());
        Toast toast = Toast.makeText(context, "", duration);

        if (picture_selected) {
//            button.setBackgroundDrawable(getResources().getDrawable(R.color.ShinyOrange));
            button.setImageResource(R.mipmap.picture);
//            label.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.LightBlue));
            picture_selected = false;
           toast = Toast.makeText(context, R.string.v_unselected, duration);
        }

        else if (!picture_selected) {
            button.setImageResource(R.mipmap.picture_selected);
            picture_selected = true;
            toast = Toast.makeText(context, R.string.v_selected, duration);
        }

        toast.show();
    }


    public void shuffle(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

        if (shuffle) {
            button.setImageResource(R.mipmap.shuffle);
            shuffle = false;
            toast = Toast.makeText(getApplicationContext(), R.string.list_ordered, Toast.LENGTH_SHORT);
        }
        else if (!shuffle) {
            button.setImageResource(R.mipmap.shuffle_pressed);
            shuffle = true;
            toast = Toast.makeText(getApplicationContext(), R.string.list_shuffled, Toast.LENGTH_SHORT);
        }


        toast.show();
    }


    public void playClick(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);
        if (paused) {
            button.setImageResource(R.drawable.pause_button_customized);
            paused = false;
            toast = Toast.makeText(getApplicationContext(), R.string.v_play, Toast.LENGTH_SHORT);
        }

        else if (!paused) {
            button.setImageResource(R.drawable.play_button_customized);
            paused = true;
            toast = Toast.makeText(getApplicationContext(), R.string.v_paused, Toast.LENGTH_SHORT);
        }

        toast.show();
    }

    public void repeat(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);;

        if (repeat) {
            button.setImageResource(R.mipmap.repeat);
            repeat = false;
            toast = Toast.makeText(getApplicationContext(),  R.string.v_repeat_not, Toast.LENGTH_SHORT);
        }

        else if (!repeat) {
            button.setImageResource(R.mipmap.repeat_pressed);
            repeat = true;
            toast = Toast.makeText(getApplicationContext(),R.string.v_repeat, Toast.LENGTH_SHORT);
        }

        toast.show();
    }


    public void volume(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast =Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);

        if (volume_off) {
            button.setImageResource(R.drawable.volume_button_customized);
            volume_off = false;
            toast = Toast.makeText(getApplicationContext(),  R.string.v_unmuted, Toast.LENGTH_SHORT);
        }
        else if (!volume_off) {
            button.setImageResource(R.drawable.volume_off_button_customized);
            volume_off = true;
            toast = Toast.makeText(getApplicationContext(), R.string.v_muted, Toast.LENGTH_SHORT);
        }
        toast.show();
    }


    public void stop(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.v_stopped, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void pause(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),  R.string.v_paused, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void forward(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),  R.string.v_next, Toast.LENGTH_SHORT);
        toast.show();

    }

    public void backward(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.v_previous, Toast.LENGTH_SHORT);
        toast.show();

    }

}


