package com.epam.jwd.task.model;

import java.util.List;

public class Triangle extends Figure {

    private final List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    Triangle(List<Point> points, Color color, String name) {
        super(FigureType.TRIANGLE, color, name);
        this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{\n\t" + points + "\n}";
    }
}
