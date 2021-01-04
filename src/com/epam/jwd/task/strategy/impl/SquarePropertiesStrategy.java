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

    @Override
    public double calculateArea(List<Point> points) {
        return Math.pow(defineSideOfSquare(points), 2);
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        return 4 * defineSideOfSquare(points);
    }

    @Override
    public boolean isExist(List<Point> points) {
        double[] sides = destinationsFromOnePoint(points);

        if (sides[0] == sides[1] && 2.0 * sides[0] == sides[2]
                && 2.0 * PointLogic.squarePointsDestination(points.get(1), points.get(3)) ==
                PointLogic.squarePointsDestination(points.get(1), points.get(2))) {
            return true;
        }

        if (sides[1] == sides[2] && 2.0 * sides[1] == sides[0]
                && 2.0 * PointLogic.squarePointsDestination(points.get(1), points.get(2)) ==
                PointLogic.squarePointsDestination(points.get(2), points.get(3))) {
            return true;
        }

        return sides[0] == sides[2] && 2.0 * sides[0] == sides[1]
                && 2.0 * PointLogic.squarePointsDestination(points.get(1), points.get(2)) ==
                PointLogic.squarePointsDestination(points.get(1), points.get(3));
    }

    private static double defineSideOfSquare(List<Point> points) {
        double firstSide = PointLogic.pointsDestination(points.get(0), points.get(1));
        double secondSide = PointLogic.pointsDestination(points.get(0), points.get(2));
        return Math.min(secondSide, firstSide);
    }

    public static double[] destinationsFromOnePoint(List<Point> points) {
        double[] sides = new double[3];
        sides[0] = PointLogic.squarePointsDestination(points.get(0), points.get(1));
        sides[1] = PointLogic.squarePointsDestination(points.get(0), points.get(2));
        sides[2] = PointLogic.squarePointsDestination(points.get(0), points.get(3));
        return sides;
    }

}
