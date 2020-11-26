package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.logic.PointLogic;

public class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    private static SquarePropertiesStrategy instance;

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    private static double sideOfSquare(Point[] points) {
        double firstSide = PointLogic.pointsDestination(points[0], points[1]);
        double secondSide = PointLogic.pointsDestination(points[0], points[2]);
        return Math.min(secondSide, firstSide);
    }

    @Override
    public double calculateArea(Point[] points) {
        return Math.pow(sideOfSquare(points), 2);
    }

    @Override
    public double calculatePerimeter(Point[] points) {
        return 4 * sideOfSquare(points);
    }
}
