package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;


public class Parallelogram extends Shape{
    Parallelogram(String type, Point[] points){
        super(type,points);
    }
    public double calcArea() {
        double x;
        double y;
        x = Math.abs(points[1].getX()-points[2].getX());
        y = Math.abs(points[3].getY()-points[1].getY());
        return(x*y);
    }


}