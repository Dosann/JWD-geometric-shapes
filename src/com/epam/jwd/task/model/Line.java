package com.epam.jwd.task.model;

import java.util.Arrays;

public class Line extends Figure {

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    Line(Point[] points){
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line{\n\t" + Arrays.toString(points) + "\n}";
    }
}
