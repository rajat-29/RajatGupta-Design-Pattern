package org.example.Creational;

import java.util.Map;
import java.util.HashMap;

abstract class Color implements Cloneable{
    protected String color;
    abstract void addColor();
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

class greenColor extends Color{
    public greenColor(){
        this.color="green";
    }
    @Override
    void addColor() {
        System.out.println("Green color added");
    }
}

class blackColor extends Color{
    public blackColor(){
        this.color="black";
    }
    @Override
    void addColor() {
        System.out.println("Black color added");
    }
}

class ColorStore{
    private static Map<String,Color> colorMap = new HashMap<String, Color>();
    static {
        colorMap.put("green",new greenColor());
        colorMap.put("black",new blackColor());
    }
    public static Color getColor(String colorName){
        return (Color) colorMap.get(colorName).clone();
    }
}

public class Prototype {
    public static void main(String args[]){
        ColorStore.getColor("green").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("green").addColor();
        ColorStore.getColor("black").addColor();
    }
}