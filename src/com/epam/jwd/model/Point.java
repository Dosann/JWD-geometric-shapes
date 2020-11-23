package com.epam.jwd.model;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    public double pointsDestination(Point p){
        if (p == null){
            return -1;
        }
        double xDestination = Math.abs(this.x - p.x);
        double yDestination = Math.abs(this.y - p.y);
        return Math.hypot(xDestination, yDestination);
    }

    public double squarePointsDestination(Point p){
        return Math.pow(pointsDestination(p), 2);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x = " + x +
                ", y = " + y +
                '}';
    }
}
