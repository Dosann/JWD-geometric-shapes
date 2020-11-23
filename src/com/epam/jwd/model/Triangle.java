package com.epam.jwd.model;

public class Triangle {
    private Point[] points;

    public Triangle(Point p1, Point p2, Point p3){
        initialize(p1, p2, p3);
    }

    private void initialize(Point p1, Point p2, Point p3){
        points = new Point[3];
        points[0] = new Point(p1.getX(), p1.getY());
        points[1] = new Point(p2.getX(), p2.getY());
        points[2] = new Point(p3.getX(), p3.getY());
    }

    public int isTriangle(){
        if (points[0].equals(points[1]) || points[0].equals(points[2]) ||
                points[1].equals(points[2])){
            return -1;
        }

        // check if points don't lie on a straight line
        double area = points[0].getX() * (points[1].getY() - points[2].getY()) +
                points[1].getX() * (points[2].getY() - points[0].getY()) +
                points[2].getX() * (points[0].getY() - points[1].getY());
        if(area == 0){
            return 0;
        }

        double sideA = points[0].pointsDestination(points[1]);
        double sideB = points[0].pointsDestination(points[2]);
        double sideC = points[1].pointsDestination(points[2]);

        double maximumOfSides = Math.max(sideA, sideB);
        if(maximumOfSides < sideC){
            maximumOfSides = sideC;
        }
        return maximumOfSides <= sideA + sideB ? 1 : 0;
    }

    @Override
    public String toString() {
        String result = "Triangle{\n\t";
        for (Point point : points) {
            result += point.toString() + " ";
        }
        return result + "\n}";
    }


}
