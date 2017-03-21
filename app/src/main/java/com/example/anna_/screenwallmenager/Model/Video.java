package com.example.anna_.screenwallmenager.Model;

import java.util.ArrayList;
import java.util.List;

import com.example.anna_.screenwallmenager.View.*;



public class Video {

//    protected void onCreate(Bundle savedInstanceState) {
//
//    }

    private String idv;
    private String file;
    private int distributed;
    private int volume;
    private int mute;
    private double departure;
    private String state="pause"; // "pause" or "play"
    private int loop=1;
    private List<Screen> screen = new ArrayList<Screen>();
    boolean selected;

    public Video(){    }

    public Video(String idv, String file, int volume, int mute, double departure, String state,int loop, List<Screen> screen){

        this.idv=idv;
        this.file=file;
        this.screen = screen;
        this.volume=volume;
        this.mute=mute;
        this.state=state;
        this.loop=loop;
        this.departure=departure;
        this.selected = false;

    }
    // deuxieme contructeur sans les parametres initialisés

    public Video(String idv,String file,List<Screen> screen){

        this.idv=idv; this.file=file; this.screen = screen;
    }

    public String getFile(){

        return file;
    }


    public int getVolume(){

        return volume;
    }

    public String getIdv(){

        return idv;
    }

    public List<Screen> getScreen (){

        return this.screen;
    }

    public void setVolume_fort(){ this.volume++;}

    public void setVolume_faible() { this.volume--; }

    public void setMute() {
        if (this.mute ==0) mute= 1;

    else mute = 0;
    }
    public void addvideo_inScenario(Video video ) {

        //videoist.add(video.getFile());
    }

    // utiliser les bouton manager
//    Manager mng= new ManagerImpl();


    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setLoop(int value){
        this.loop = loop;
    }

    public int getLoop(){
        return this.loop;
    }

    public int getMute(){
        return this.mute;
    }



// TODO: fill all the below methods (you have to create json file and fill with info it on every call of the method)
    public void play(){}
    public void stop(){}
    public void pause(){}
    public void forward(){}
    public void backward(){}
    public void repeate(boolean rep){}

}
