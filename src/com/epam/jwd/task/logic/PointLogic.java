package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class PointLogic {

    private static final Logger LOGGER = LogManager.getLogger(PointLogic.class);

    public static double pointsDestination(Point p1, Point p2) {
        return Math.sqrt(squarePointsDestination(p1, p2));
    }

    public static double squarePointsDestination(Point p1, Point p2) {
        double xDestination = Math.abs(p1.getX() - p2.getX());
        double yDestination = Math.abs(p1.getY() - p2.getY());
        return Math.pow(xDestination, 2) + Math.pow(yDestination, 2);
    }

    public static void printPoints(Point[] points) {
        int iterator = 0;
        do {
            LOGGER.log(Level.INFO, "{}", points[iterator++]);
        }
        while (iterator != points.length);
    }
}
