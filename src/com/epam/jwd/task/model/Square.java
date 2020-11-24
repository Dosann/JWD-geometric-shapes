package com.epam.jwd.task.model;

import java.util.Arrays;

public class Square {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Square(Point p1, Point p2, Point p3, Point p4) {
        initialize(p1, p2, p3, p4);
    }

    private void initialize(Point p1, Point p2, Point p3, Point p4) {
        points = new Point[4];
        points[0] = new Point(p1.getX(), p1.getY());
        points[1] = new Point(p2.getX(), p2.getY());
        points[2] = new Point(p3.getX(), p3.getY());
        points[3] = new Point(p4.getX(), p4.getY());
    }

    @Override
    public String toString() {
        return "Square{\n\t" + Arrays.toString(points) + "\n}";
    }

}
