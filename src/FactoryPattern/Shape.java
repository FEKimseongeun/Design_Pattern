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
        System.out.println(type);
        for(int i=0; i<points.length; i++)
            System.out.println("p"+i+": "+points[i]);
        System.out.println("area : "+calcArea());
        return "";
    }


}