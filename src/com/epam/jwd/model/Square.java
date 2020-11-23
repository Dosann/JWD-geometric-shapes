package com.epam.jwd.model;

public class Square {
    private Point[] points;

    public Square(Point p1, Point p2, Point p3, Point p4){
        initialize(p1, p2, p3, p4);
    }

    private void initialize(Point p1, Point p2, Point p3, Point p4){
        points = new Point[4];
        points[0] = new Point(p1.getX(), p1.getY());
        points[1] = new Point(p2.getX(), p2.getY());
        points[2] = new Point(p3.getX(), p3.getY());
        points[3] = new Point(p4.getX(), p4.getY());
    }

    public int isSquare(){
        double sideFrom0To1 = points[0].squarePointsDestination(points[1]);
        double sideFrom0To2 = points[0].squarePointsDestination(points[2]);
        double sideFrom0To3 = points[0].squarePointsDestination(points[3]);

        // check if points are the same
        if (sideFrom0To1 == 0 || sideFrom0To2 == 0 || sideFrom0To3 == 0){
            return -1;
        }

        if (sideFrom0To1 == sideFrom0To2 && 2 * sideFrom0To1 == sideFrom0To3 &&
                2 * points[1].squarePointsDestination(points[3]) ==
                        points[1].squarePointsDestination(points[2])){
            return 1;
        }

        if (sideFrom0To2 == sideFrom0To3 && 2 * sideFrom0To2 == sideFrom0To1 &&
                2 * points[1].squarePointsDestination(points[2]) ==
                        points[2].squarePointsDestination(points[3])){
            return 1;
        }

        if (sideFrom0To1 == sideFrom0To3 && 2 * sideFrom0To1 == sideFrom0To2 &&
                2 * points[1].squarePointsDestination(points[2]) ==
                        points[1].squarePointsDestination(points[3])){
            return 1;
        }

        return 0;
    }


    @Override
    public String toString() {
        String result = "Square{\n\t";
        for (Point point : points) {
            result += point.toString() + " ";
        }
        return result + "\n}";
    }
}
