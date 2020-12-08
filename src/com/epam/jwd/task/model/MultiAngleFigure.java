package com.epam.jwd.task.model;

import java.util.Arrays;

public class MultiAngleFigure extends Figure {

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public MultiAngleFigure(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Multi-angle figure{\n\t" + Arrays.toString(points) + "\n}";
    }
}
