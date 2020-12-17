package com.epam.jwd.task.model;

import java.util.List;

public class Square extends Figure {

    private final List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    Square(List<Point> points, Color color, String name) {
        super(color, name);
        this.points = points;
    }

    @Override
    public String toString() {
        return "Square{\n\t" + points + "\n}";
    }
}
