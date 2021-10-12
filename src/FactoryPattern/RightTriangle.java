package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;
public class RightTriangle extends Shape {
    RightTriangle(String type, Point[] points){
        super(type,points);
    }
    @Override
    public double calcArea() {
        double a;
        double b;

        a = points[2].getX()-points[1].getX();
        b = points[0].getY()-points[1].getY();


        return a*b/2;
    }



}