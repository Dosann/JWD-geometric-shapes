package com.epam.jwd.task.model;

public class PointFactory {

    private static final Point[] createdPoints = new Point[42];
    private static int amountOfPoints = 0;

    public static Point buildPoint(double x, double y){
        final Point point = new Point(x, y);
        createdPoints[amountOfPoints++] = point;
        return point;
    }
}
