package com.epam.jwd.task.model;

import com.epam.jwd.task.logic.PointLogic;

import java.util.Arrays;

public class Triangle {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Triangle(Point p1, Point p2, Point p3) {
        initialize(p1, p2, p3);
    }

    private void initialize(Point p1, Point p2, Point p3) {
        points = new Point[3];
        points[0] = new Point(p1.getX(), p1.getY());
        points[1] = new Point(p2.getX(), p2.getY());
        points[2] = new Point(p3.getX(), p3.getY());
    }

    @Override
    public String toString() {
        return "Triangle{\n\t" + Arrays.toString(points) + "\n}";
    }


}
