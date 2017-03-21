package com.example.anna_.screenwallmenager.Model;

import java.util.ArrayList;


public class Scenario {


    private String name;
    private ArrayList<Video> videoList = new ArrayList<>();

    //contructeur par default
    public Scenario(){}

    //contructeur avec parametres

    public Scenario(String name,ArrayList<Video> video_list){

        this.name = name;
        this.videoList= video_list;

    }

    public String getName(){
        return name;
    }

    public ArrayList<Video> getVideoList(){

        return videoList;

    }

    //TODO: shuffle the PlayList (videoList)
    public void shuffleVideoList(){

    }
}
