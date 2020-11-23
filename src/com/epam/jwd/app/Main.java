package com.epam.jwd.app;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class Main {
    static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Point[] points = new Point[4];

        points[0] = new Point(3, 4);
        points[1] = new Point(-1, 1);
        points[2] = new Point(0, 10);
        points[3] = new Point(2, 0);

        int iterator = 0;
        do{
            LOGGER.log(Level.INFO, "{}", points[iterator++]);
        }
        while(iterator != points.length);

        Line[] lines = new Line[2];

        lines[0] = new Line(points[0], points[1]);
        lines[1] = new Line(points[2], points[2]);

        for(Line line : lines){
            if(line.isLine()) {
                LOGGER.log(Level.INFO, "{}", line);
            } else {
                LOGGER.log(Level.ERROR, "Object {} can't be a line!", line);
            }
        }

        Triangle[] triangles = new Triangle[2];

        triangles[0] = new Triangle(points[0], points[2], points[3]);
        triangles[1] = new Triangle(points[1], points[3], points[2]);

        for(Triangle triangle : triangles){
            if(triangle.isTriangle() == 1){
                LOGGER.log(Level.INFO, "{}", triangle);
            } else if(triangle.isTriangle() == -1){
                LOGGER.log(Level.ERROR, "Object {} can't be a triangle!", triangle);
            } else {
                LOGGER.log(Level.ERROR, "{} can't exist", triangle);
            }
        }

        Square[] squares = new Square[1];
        squares[0] = new Square(points[0], points[1], points[2], points[3]);

        for(Square square : squares){
            if(square.isSquare() == 1){
                LOGGER.log(Level.INFO, "{}", square);
            } else if(square.isSquare() == -1){
                LOGGER.log(Level.ERROR, "Object {} can't be a square!", square);
            } else {
                LOGGER.log(Level.ERROR, "{} isn't a square", square);
            }
        }

    }
}
