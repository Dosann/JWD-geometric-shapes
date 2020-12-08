package com.epam.jwd.task.model;

import java.util.Arrays;

public class Square extends Figure {

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    Square(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Square{\n\t" + Arrays.toString(points) + "\n}";
    }
}
