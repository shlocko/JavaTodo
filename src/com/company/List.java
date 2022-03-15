package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class List {
    
    private final ArrayList<String> list = new ArrayList<>();
    
    public List(){
        
    }
    
    public void add(String text){
        list.add(text);
    }
    public boolean remove(String text){
        if(list.contains(text)){
            list.remove(text);
            return true;
        } else {
            return false;
        }
    }
    public boolean remove(int index){
        if(index < list.size()){
            list.remove(index);
            return true;
        } else {
            return false;
        }
    }
    public int find(String text){
        return (list.contains(text)) ? list.indexOf(text) : -1;
    }
    public ArrayList<String> getList(){
        return list;
    }
    
}
