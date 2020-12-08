package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double calculateArea(Point[] points) {
        return 0;
    }

    @Override
    public double calculatePerimeter(Point[] points) {
        return PointLogic.pointsDestination(points[0], points[1]);
    }
}
