package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;

public final class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    private static SquarePropertiesStrategy instance;

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    private static double defineSideOfSquare(Point[] points) {
        double firstSide = PointLogic.pointsDestination(points[0], points[1]);
        double secondSide = PointLogic.pointsDestination(points[0], points[2]);
        return Math.min(secondSide, firstSide);
    }

    @Override
    public double calculateArea(Point[] points) {
        return Math.pow(defineSideOfSquare(points), 2);
    }

    @Override
    public double calculatePerimeter(Point[] points) {
        return 4 * defineSideOfSquare(points);
    }
}
