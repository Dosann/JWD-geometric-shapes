package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;

import java.util.List;

public interface FigurePropertiesStrategy {
    double calculateArea(List<Point> points);
    double calculatePerimeter(List<Point> points);
    boolean isExist(List<Point> points);
}
