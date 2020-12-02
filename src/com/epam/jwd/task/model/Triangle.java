package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;

import java.util.Arrays;

public class Triangle extends Figure {

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    Triangle(Point[] points) {
        super(points);
       this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{\n\t" + Arrays.toString(points) + "\n}";
    }
}
