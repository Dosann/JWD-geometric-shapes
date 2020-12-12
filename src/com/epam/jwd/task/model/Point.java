package com.epam.jwd.task.model;

import java.util.Objects;

public class Point {

    private final double x;
    private final double y;

    public double getX() {
        return x;
    }

    public double getY(){
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point {" + "x = " + x + ", y = " + y + " }";
    }
}
