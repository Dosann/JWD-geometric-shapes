package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;

import java.util.List;

public final class SquarePropertiesStrategy implements FigurePropertiesStrategy {

    private static SquarePropertiesStrategy instance;

    public static SquarePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    private static double defineSideOfSquare(List<Point> points) {
        double firstSide = PointLogic.pointsDestination(points.get(0), points.get(1));
        double secondSide = PointLogic.pointsDestination(points.get(0), points.get(2));
        return Math.min(secondSide, firstSide);
    }

    @Override
    public double calculateArea(List<Point> points) {
        return Math.pow(defineSideOfSquare(points), 2);
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        return 4 * defineSideOfSquare(points);
    }
}
