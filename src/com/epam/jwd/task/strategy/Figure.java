package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;

public class Figure {

    private FigurePropertiesStrategy strategy;
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public Figure(Point[] points) {
        this.strategy = LinePropertiesStrategy.INSTANCE;
        this.points = points;
    }

    public void setTriangleStrategy(){
        this.strategy = new TrianglePropertiesStrategy();
    }

    public void setSquareStrategy(){
        this.strategy = new SquarePropertiesStrategy();
    }

    public double calculateArea() {
        return strategy.calculateArea(points);
    }
    public double calculatePerimeter() {
        return strategy.calculatePerimeter(points);
    }
}
