package FactoryPattern;

import java.awt.*;
import java.util.ArrayList;

public class TriangularShapeFactory implements ShapeFactory {

    @Override
    public Shape create(String type, Point[] points) {
        if (type.equals("Triangle")) {
            Shape sh = new Triangle(type,points);
            return sh;
        }else if(type.equals("RightTriangle")) {
            Shape sh = new RightTriangle(type,points);
            return sh;
        }else{
            return null;
        }
    }

}