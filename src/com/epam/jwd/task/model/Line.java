package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;

import java.util.Arrays;

public class Line extends Figure {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    Line(Point[] points){
        super(points);
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line{\n\t" + Arrays.toString(points) + "\n}";
    }
}
