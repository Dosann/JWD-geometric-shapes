package com.epam.jwd.task.app;

import com.epam.jwd.task.logic.LineLogic;
import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.logic.SquareLogic;
import com.epam.jwd.task.logic.TriangleLogic;
import com.epam.jwd.task.model.Line;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.model.Triangle;

public class Main {

    private static Point[] createPoints(){
        Point[] points = new Point[4];
        points[0] = new Point(3, 4);
        points[1] = new Point(-1, 1);
        points[2] = new Point(0, 10);
        points[3] = new Point(2, 0);
        return points;
    }

    private static Line[] createLines(){
        Line[] lines = new Line[2];
        lines[0] = new Line(new Point(3.2, 4.1), new Point(-9.23, -0.4));
        lines[1] = new Line(new Point(1.12, 0), new Point(1.12, 0));
        return lines;
    }

    private static Triangle[] createTriangles(){
        Triangle[] triangles = new Triangle[2];
        triangles[0] = new Triangle(new Point(0, 0.3), new Point(9, -3.6), new Point(3.0, -8.43));
        triangles[1] = new Triangle(new Point(0, 0.3), new Point(9, -3.6), new Point(0, 0.3));
        return triangles;
    }

    private static Square[] createSquares(){
        Square[] squares = new Square[1];
        squares[0] = new Square(new Point(2.4, 3.1), new Point(3.1, 2.4),
                new Point(2.4, 2.4), new Point(3.1, 3.1));
        return squares;
    }

    public static void main(String[] args) {
        PointLogic.printPoints(createPoints());
        LineLogic.printLines(createLines());
        TriangleLogic.printTriangles(createTriangles());
        SquareLogic.printSquares(createSquares());
    }
}
