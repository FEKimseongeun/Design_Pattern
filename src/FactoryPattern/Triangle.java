package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;
public class Triangle extends Shape{
    Triangle(String type, Point[] points){
        super(type,points);
    }

    public double calcArea() {
        double a;
        double b;
        double c;
        double s;
        a = Math.sqrt(Math.pow(points[0].getX()-points[1].getX(),2)+Math.pow(points[0].getY()-points[1].getY(),2));
        b = Math.sqrt(Math.pow(points[1].getX()-points[2].getX(),2)+Math.pow(points[1].getY()-points[2].getY(),2));
        c = Math.sqrt(Math.pow(points[0].getX()-points[2].getX(),2)+Math.pow(points[0].getY()-points[2].getY(),2));
        s = (a+b+c)/2;

        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

}