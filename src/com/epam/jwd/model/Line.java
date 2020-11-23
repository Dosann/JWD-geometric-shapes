package com.epam.jwd.model;

public class Line {
    private Point[] points;

    public Line(Point p1, Point p2){
        initialize(p1, p2);
    }

    private void initialize(Point p1, Point p2){
        points = new Point[2];
        points[0] = new Point(p1.getX(), p1.getY());
        points[1] = new Point(p2.getX(), p2.getY());
    }

    public boolean isLine(){
        return points[0].equals(points[1]) ? false : true;
    }

    @Override
    public String toString() {
        String result = "Line{\n\t";
        for (Point point : points) {
            result += point.toString() + " ";
        }
        return result + "\n}";
    }

}
