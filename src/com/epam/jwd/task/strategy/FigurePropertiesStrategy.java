package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;

public interface FigurePropertiesStrategy {
    double calculateArea(Point[] points);
    double calculatePerimeter(Point[] points);
}
