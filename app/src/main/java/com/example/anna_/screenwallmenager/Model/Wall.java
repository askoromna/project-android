package com.example.anna_.screenwallmenager.Model;

import java.util.List;



public class Wall {

    private String name;
    private int rows;
    private int cols;
    private List<Screen> matrix;

    public Wall(String name, int rows ,int cols ,List<Screen> mat){
        name=name; rows=rows ; cols=cols ; matrix=mat;
    }

    public String getName() {return name;}
    public int getRows(){ return rows;}
    public int getCols(){  return cols;}
    public List<Screen> getMatrix(){ return matrix;}


    public Screen getScreen(String id){

        for ( Screen s : matrix)
            if(s.getIds() == id)
                return s;
        return null;
    }

}
