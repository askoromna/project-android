package com.example.anna_.screenwallmenager.Model;

import java.util.ArrayList;


public class Scenario {


    private String name;
    private ArrayList<String> video_list = new ArrayList<String>();

    //contructeur par default
    public Scenario(){}

    //contructeur avec parametres

    public Scenario(String name,ArrayList<String> video_list){

        this.name = name;
        this.video_list= video_list;

    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getVideo_list(){

        return video_list;

    }
}
