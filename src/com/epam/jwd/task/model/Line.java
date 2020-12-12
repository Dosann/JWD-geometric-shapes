package com.epam.jwd.task.model;

import java.util.List;

public class Line extends Figure {

    private final List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    Line(List<Point> points){
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line{\n\t" + points + "\n}";
    }
}
