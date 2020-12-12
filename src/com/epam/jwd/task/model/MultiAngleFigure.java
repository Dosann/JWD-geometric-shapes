package com.epam.jwd.task.model;

import java.util.List;

public class MultiAngleFigure extends Figure {

    private final List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    MultiAngleFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Multi-angle figure{\n\t" + points + "\n}";
    }
}
