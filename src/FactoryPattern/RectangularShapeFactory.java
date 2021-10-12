package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;

public class RectangularShapeFactory implements ShapeFactory {

    public Shape create(String type, Point[] points) {

        if (type.equals("Rectangle")) {
            Shape sh = new Rectangle(type,points);
            return sh;
        }else if(type.equals("Parallelogram")) {
            Shape sh = new Parallelogram(type,points);
            return sh;
        }else if(type.equals("Trapezoid")) {
            Shape sh = new Trapezoid(type,points);
            return sh;
        }else{
            return null;
        }

    }



}