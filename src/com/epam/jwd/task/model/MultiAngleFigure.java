package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;

import java.util.Arrays;

public class MultiAngleFigure extends Figure {

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    MultiAngleFigure(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Multi-angle figure{\n\t" + Arrays.toString(points) + "\n}";
    }
}
