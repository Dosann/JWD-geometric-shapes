package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;

import java.util.List;

public class MultiAnglePropertiesStrategy implements FigurePropertiesStrategy {

    private static MultiAnglePropertiesStrategy instance;

    public static MultiAnglePropertiesStrategy getInstance() {
        if (instance == null) {
            instance = new MultiAnglePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculateArea(List<Point> points) {
        return 0;
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        return 0;
    }

    @Override
    public boolean isExist(List<Point> points) {
        return points.size() <= 6 && points.size() >= 4;
    }
}
