package FactoryPattern;

import java.awt.*;

public abstract class Shape {
    Point[] points;
    String type;
    public Shape(String type,Point[] points) {
        this.points = points;
        this.type = type;
    }

    abstract double calcArea();

    public String toString() {
        String s= type+"\n";
        for(int i=0; i<points.length; i++)
            s+="p"+i+": "+points[i].toString()+"\n";
        s+=("area: " + calcArea());
        return s;
    }


}