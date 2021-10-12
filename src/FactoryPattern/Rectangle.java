package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;
public class Rectangle extends Shape {
    Rectangle(String type, Point[] points){
        super(type,points);
    }
    public double calcArea() {
        double x;
        double y;
        x = Math.abs(points[0].getX()-points[1].getX());
        y = Math.abs(points[0].getY()-points[1].getY());
        return(x*y);
    }

}
