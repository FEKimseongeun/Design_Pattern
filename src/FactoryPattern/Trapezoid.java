package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;
public class Trapezoid extends Shape{
    Trapezoid(String type, Point[] points){
        super(type,points);
    }
    public double calcArea() {
        double x;
        double y;
        x = (points[3].getX()-points[0].getX())+(points[1].getX()-points[2].getX());
        y = points[3].getY()-points[1].getY();
        return x*y/2;
    }


}