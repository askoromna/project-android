package com.example.anna_.screenwallmenager.Model;



public class Screen  {

    int row;
    int col;
    private String ids;
    private String resolution;
    private String orientation;
    private boolean tactile;
    private boolean selected;

    public Screen (){
        this.ids = "";
        this.resolution = "1920x1080";
        this.orientation = "landscape";
        this.tactile = false;

    }

    public Screen(String id, String resolution,String orientation,boolean tactile){

        this.ids = id;
        this.resolution= resolution;
        this.orientation =orientation;
        this.tactile= tactile;
        this.selected = false;

    }

    public String getIds(){

        return ids;
    }

    public String getResolution(){

        return resolution;
    }

    public String getOrientation(){

        return orientation;
    }

    public boolean getTactile(){

        return this.tactile;
    }


    public void setResolution(String r){

        this.resolution = r;

    }
    public void setOrientation(String or){

        this.orientation = or;

    }
    public void setTactile(boolean tac){

        this.tactile = tac;

    }

}
