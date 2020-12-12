package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Point;

public class PointLogic {

    public static double pointsDestination(Point p1, Point p2) {
        return Math.sqrt(squarePointsDestination(p1, p2));
    }

    public static double squarePointsDestination(Point p1, Point p2) {
        double xDestination = Math.abs(p1.getX() - p2.getX());
        double yDestination = Math.abs(p1.getY() - p2.getY());
        return Math.pow(xDestination, 2) + Math.pow(yDestination, 2);
    }

}
