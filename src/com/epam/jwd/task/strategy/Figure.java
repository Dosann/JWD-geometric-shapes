package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;

public class Figure {
    private FigurePropertiesStrategy strategy;
    private Point[] points;

    public Figure(FigurePropertiesStrategy figurePropertiesStrategy, Point[] points) {
        this.strategy = figurePropertiesStrategy;
        this.points = points;
    }

    public double calculateArea() {
        return strategy.calculateArea(points);
    }
    public double calculatePerimeter() {
        return strategy.calculatePerimeter(points);
    }



}
