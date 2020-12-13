package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;

import java.util.List;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double calculateArea(List<Point> points) {
        return 0;
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        return PointLogic.pointsDestination(points.get(0), points.get(1));
    }

    @Override
    public boolean isExist(List<Point> points) {
        return true;
    }
}
