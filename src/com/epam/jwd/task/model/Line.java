package com.epam.jwd.task.model;

import java.util.Arrays;

public class Line {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Line(Point p1, Point p2){
        initialize(p1, p2);
    }

    private void initialize(Point p1, Point p2) {
        points = new Point[2];
        points[0] = new Point(p1.getX(), p1.getY());
        points[1] = new Point(p2.getX(), p2.getY());
    }

    @Override
    public String toString() {
        return "Line{\n\t" + Arrays.toString(points) + "\n}";
    }
}
