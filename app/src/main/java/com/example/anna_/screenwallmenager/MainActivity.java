package com.example.anna_.screenwallmenager;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anna_.screenwallmenager.Model.*;
import  com.example.anna_.screenwallmenager.View.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    boolean paused = true;
    boolean repeat = false;
    boolean shuffle = false;
    boolean volume_off = false;

    String selectedPictureTag = "";


    private ArrayAdapter<String> adapter;
    private List<Integer> intList = new ArrayList<>(); //list of ints for random  with no duplicates

    //DEMO lists of screens for video_1, video_2, video_3
    private List<Screen> screenList1 = new ArrayList<>();
    private List<Screen> screenList2 = new ArrayList<>();
    private List<Screen> screenList3 = new ArrayList<>();
    private List<Screen> screenList = new ArrayList<>();


    // DEMO
    Video video1 = new Video("v1", "video_file_1.mp4", 2, 0, 10.5, "pause", 0, screenList1);
    Video video2 = new Video("v2", "video_file_2.mp4", 2, 0, 10.5, "pause", 0, screenList2);
    Video video3 = new Video("v3", "video_file_3.mp4", 2, 0, 10.5, "pause", 0, screenList3);


    //list of ImageButtons to set the OnLongClick action on
    int imButtonsIds [] = {R.id.s11, R.id.s12,R.id.s13,R.id.s14,R.id.s21,R.id.s22,R.id.s23,R.id.s24,
            R.id.s31,R.id.s32,R.id.s33,R.id.s34,R.id.s41,R.id.s42,R.id.s43,R.id.s44};

    Scenario scenario = new Scenario();
    ManagerImpl manager = new ManagerImpl() ;
    Video video = new Video();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();   //list of videos in profile OR scenario
        fillScreenLists();  //lists of screens for every video
        colorVideoBackground(); //sets background of picture, that represents one video

        for (int id: imButtonsIds){
            final ImageButton b11 = (ImageButton)findViewById(id);
            b11.setLongClickable(true);
            b11.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    select_screen(v);
                    return true;
                }
            });
        }
    }


    //lists of screens for every video
    public void fillScreenLists(){  // demo function for showing the functionality of the app

        /// for video_1 (left upper corner of the wall
        screenList1.add(new Screen("s11", "1920x1080", "landscape",  false));
        screenList1.add(new Screen("s12", "1920x1080", "landscape",  false));
        screenList1.add(new Screen("s21", "1920x1080", "landscape",  false ));
        screenList1.add(new Screen("s22", "1920x1080", "landscape",  false ));

        /// for video_2 (right upper corner of the wall
        screenList2.add(new Screen("s13", "1920x1080", "landscape",  false ));
        screenList2.add(new Screen("s14", "1920x1080", "landscape",  false));
        screenList2.add(new Screen("s23", "1920x1080", "landscape",  false ));
        screenList2.add(new Screen("s24", "1920x1080", "landscape",  false ));

        /// for video_1 (left upper corner of the wall
        screenList3.add(new Screen("s31", "1920x1080", "landscape",  false ));
        screenList3.add(new Screen("s32", "1920x1080", "landscape",  false));
        screenList3.add(new Screen("s41", "1920x1080", "landscape",  false ));
        screenList3.add(new Screen("s42", "1920x1080", "landscape",  false ));
        screenList3.add(new Screen("s33", "1920x1080", "landscape",  false ));
        screenList3.add(new Screen("s34", "1920x1080", "landscape",  false));
        screenList3.add(new Screen("s43", "1920x1080", "landscape",  false ));
        screenList3.add(new Screen("s44", "1920x1080", "landscape",  false ));

        screenList.addAll(screenList1);
        screenList.addAll(screenList2);
        screenList.addAll(screenList3);

    }


    //sets background of picture, that represents one video
    public void colorVideoBackground(){

        for (int i=1; i<17; i++){
            intList.add(i);
        }
        Collections.shuffle(intList);   //shuffling list of ints to get the random no-duplicate color
        int view_id = 0, view_id_2 =0;
        int color_id;
        View v1, v2 ;

        for(Screen s: video1.getScreen()){
            view_id = getResources().getIdentifier(s.getIds(), "id", MainActivity.this.getPackageName());
            v1 = findViewById(view_id);
            view_id_2 = getResources().getIdentifier("label_" + s.getIds(), "id", MainActivity.this.getPackageName());
            v2 = findViewById(view_id_2);

            color_id = getResources().getIdentifier("color_"+intList.get(0), "color", MainActivity.this.getPackageName());
            v1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color_id));
            v2.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color_id));
        }

        for(Screen s: video2.getScreen()){
            view_id = getResources().getIdentifier(s.getIds(), "id", MainActivity.this.getPackageName());
            v1 = findViewById(view_id);
            view_id_2 = getResources().getIdentifier("label_" + s.getIds(), "id", MainActivity.this.getPackageName());
            v2 = findViewById(view_id_2);

            color_id = getResources().getIdentifier("color_"+intList.get(1), "color", MainActivity.this.getPackageName());
            v1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color_id));
            v2.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color_id));
        }

        for(Screen s: video3.getScreen()){
            view_id = getResources().getIdentifier(s.getIds(), "id", MainActivity.this.getPackageName());
            v1 = findViewById(view_id);
            view_id_2 = getResources().getIdentifier("label_" + s.getIds(), "id", MainActivity.this.getPackageName());
            v2 = findViewById(view_id_2);

            color_id = getResources().getIdentifier("color_"+intList.get(3), "color", MainActivity.this.getPackageName());
            v1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color_id));
            v2.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color_id));
        }
    }


    //list of videos in profile OR scenario
    public void createList (){
        ListView myListView = (ListView)findViewById(R.id.videoList);
        ArrayList<String> myStringArray1 = new ArrayList<String>();
        myStringArray1.add("App created by: Hanna SKOROMNA,  Mohamed Koma CAMARA et Jean Mirabeau KEPATO");
        for (int i=1; i<21; i++){
            myStringArray1.add("Video number:  "+ i);
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, myStringArray1);

        myListView.setAdapter(adapter);
    }


    //View behaviour for click action on ImageButton that represents a screen
    public void select_screen (View v){
        ImageButton button = (ImageButton)findViewById(v.getId());
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Screen screen = new Screen();
        selectedPictureTag = (String)button.getTag();
        Toast toast = Toast.makeText(context, "", duration);

        for (Screen s: screenList){    //loops to search Screen and Video objects by selected picture
            if (s.getIds().equals(selectedPictureTag)){
                screen = s;
            }
        }

        if(screen.getSelected()){
            button.setImageResource(R.mipmap.picture);
            screen.setSelected(false);
            toast = Toast.makeText(context,  R.string.s_unselected, duration);
        }
        else if (!screen.getSelected()) {
                button.setImageResource(R.mipmap.picture_selected);
                screen.setSelected(true);
            toast = Toast.makeText(context,  R.string.s_selected, duration);
            }

        toast.show();
    }


    //View behaviour for click action on ImageButton that represents a video
    public void select_video (View v) {
        ImageButton button = (ImageButton)findViewById(v.getId());
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Screen screen = new Screen();
        Toast toast = Toast.makeText(context, "", duration);
        selectedPictureTag = (String)button.getTag();

        for (Screen s: screenList1){    //loops to search Screen and Video objects by selected picture
            if (s.getIds().equals(selectedPictureTag)){
                screen = s;
                video = video1;
            }
        }
        for (Screen s: screenList2){
            if (s.getIds().equals(selectedPictureTag)){
                screen = s;
                video = video2;
            }
        }
        for (Screen s: screenList3){
            if (s.getIds().equals(selectedPictureTag)){
                screen = s;
                video = video3;
            }
        }

        if (screen.getSelected()) {
            for (Screen s: video.getScreen()){
                int id  = getResources().getIdentifier(s.getIds(), "id", MainActivity.this.getPackageName());
                button = (ImageButton)findViewById(id);
                button.setImageResource(R.mipmap.picture);
                s.setSelected(false);
            }
            toast = Toast.makeText(context,  R.string.v_unselected, duration);
        }

        else if (!screen.getSelected()) {
            for (Screen s: video.getScreen()) {
                int id  = getResources().getIdentifier(s.getIds(), "id", MainActivity.this.getPackageName());
                button = (ImageButton)findViewById(id);
                button.setImageResource(R.mipmap.picture_selected);
                s.setSelected(true);

            }
            toast = Toast.makeText(context,  R.string.v_selected, duration);
        }
        toast.show();
    }


    //Shuffles playlist of videos (
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

        scenario.shuffleVideoList();
    }


    public void playClick(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);
        if (video.getState().equals("pause")) {
            button.setImageResource(R.drawable.pause_button_customized);

            toast = Toast.makeText(getApplicationContext(),  R.string.v_play, Toast.LENGTH_SHORT);
            video.setState("play");
            video.play();

        }

        else if (video.getState().equals("play")) {
            button.setImageResource(R.drawable.play_button_customized);

            toast = Toast.makeText(getApplicationContext(),  R.string.v_paused, Toast.LENGTH_SHORT);
            video.setState("pause");
            video.pause();
        }

        toast.show();

    }


    public void repeat(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);;

        if (video.getLoop()==1) {
            button.setImageResource(R.mipmap.repeat);
            toast = Toast.makeText(getApplicationContext(),  R.string.v_repeat_not , Toast.LENGTH_SHORT);

            video.setLoop(0);
            video.repeate(false);
        }

        else if (video.getLoop()==0) {
            button.setImageResource(R.mipmap.repeat_pressed);
            toast = Toast.makeText(getApplicationContext(),R.string.v_repeat, Toast.LENGTH_SHORT);

            video.setLoop(1);
            video.repeate(true);
        }

        toast.show();
    }


    public void volume(View v) {
        ImageButton button = (ImageButton)v;
        Toast toast =Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);

        if (video.getMute() == 1) {
            button.setImageResource(R.drawable.volume_button_customized);
            toast = Toast.makeText(getApplicationContext(),  R.string.v_unmuted, Toast.LENGTH_SHORT);

            video.setMute();
        }
        else if (video.getMute() ==0) {
            button.setImageResource(R.drawable.volume_off_button_customized);
            toast = Toast.makeText(getApplicationContext(), R.string.v_muted, Toast.LENGTH_SHORT);

            video.setMute();
        }
        toast.show();
    }


    public void stop(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),  R.string.v_stopped, Toast.LENGTH_SHORT);
        toast.show();
        video.stop();
    }


    public void forward(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),  R.string.v_next, Toast.LENGTH_SHORT);
        toast.show();
        video.forward();

    }

    public void backward(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.v_previous, Toast.LENGTH_SHORT);
        toast.show();

        video.backward();

    }

}


