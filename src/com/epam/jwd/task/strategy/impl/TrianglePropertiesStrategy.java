package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;

import java.util.List;

public final class TrianglePropertiesStrategy implements FigurePropertiesStrategy {

    private static class TriangleHolder {
        private final static TrianglePropertiesStrategy INSTANCE = new TrianglePropertiesStrategy();
    }

    public static TrianglePropertiesStrategy getInstance() {
        return TriangleHolder.INSTANCE;
    }

    @Override
    public double calculateArea(List<Point> points) {
        double area = points.get(0).getX() * (points.get(1).getY() - points.get(2).getY()) + points.get(1).getX() *
                (points.get(2).getY() - points.get(0).getY()) + points.get(2).getX() *
                (points.get(0).getY() - points.get(1).getY());
        return Math.abs(area / 2);
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        double firstSide = PointLogic.pointsDestination(points.get(0), points.get(1));
        double secondSide = PointLogic.pointsDestination(points.get(0), points.get(2));
        double thirdSide = PointLogic.pointsDestination(points.get(1), points.get(2));
        return firstSide + secondSide + thirdSide;
    }
}
