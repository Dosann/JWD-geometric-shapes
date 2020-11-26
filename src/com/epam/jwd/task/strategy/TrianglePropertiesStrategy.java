package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.logic.PointLogic;

public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {

    private static class TriangleHolder {
        private final static TrianglePropertiesStrategy INSTANCE = new TrianglePropertiesStrategy();
    }

    public static TrianglePropertiesStrategy getInstance() {
        return TriangleHolder.INSTANCE;
    }

    @Override
    public double calculateArea(Point[] points) {
        double area = points[0].getX() * (points[1].getY() - points[2].getY()) + points[1].getX() *
                (points[2].getY() - points[0].getY()) + points[2].getX() * (points[0].getY() - points[1].getY());
        return Math.abs(area / 2);
    }

    @Override
    public double calculatePerimeter(Point[] points) {
        double firstSide = PointLogic.pointsDestination(points[0], points[1]);
        double secondSide = PointLogic.pointsDestination(points[0], points[2]);
        double thirdSide = PointLogic.pointsDestination(points[1], points[2]);
        return firstSide + secondSide + thirdSide;
    }
}
