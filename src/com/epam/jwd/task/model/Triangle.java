package com.epam.jwd.task.model;

import java.util.Arrays;

public class Triangle extends Figure {

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    Triangle(Point[] points) {
       this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{\n\t" + Arrays.toString(points) + "\n}";
    }
}
