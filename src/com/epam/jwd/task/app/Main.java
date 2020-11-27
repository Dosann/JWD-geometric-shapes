package com.epam.jwd.task.app;

import com.epam.jwd.task.logic.LineLogic;
import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.logic.TriangleLogic;
import com.epam.jwd.task.logic.SquareLogic;
import com.epam.jwd.task.logic.MultiAngleFigureLogic;
import com.epam.jwd.task.model.Line;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.FigureFactory;
import com.epam.jwd.task.model.PointFactory;
import com.epam.jwd.task.model.Triangle;
import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.model.MultiAngleFigure;


public class Main {

    private static final Point[] POINTS = {
            PointFactory.buildPoint(0.1, -9.4), PointFactory.buildPoint(0.1, -9.4),
            PointFactory.buildPoint(3.5, -0.4), PointFactory.buildPoint(5, 3),
    };

    private static final Point[] POINTS_FOR_FIRST_LINE = {
            PointFactory.buildPoint(0.1, -9.4), PointFactory.buildPoint(0.1, -9.4)
    };

    private static final Point[] POINTS_FOR_SECOND_LINE = {
            PointFactory.buildPoint(0.1, -9), PointFactory.buildPoint(-2.1, 4)
    };

    private static final Point[] POINTS_FOR_FIRST_TRIANGLE = {
            PointFactory.buildPoint(0, 0),
            PointFactory.buildPoint(1, -1),
            PointFactory.buildPoint(-1, 1)
    };

    private static final Point[] POINTS_FOR_SECOND_TRIANGLE = {
            PointFactory.buildPoint(3, 0),
            PointFactory.buildPoint(-1, 3),
            PointFactory.buildPoint(-1, 0)
    };

    private static final Point[] POINTS_FOR_SQUARE = {
            PointFactory.buildPoint(3, 3),
            PointFactory.buildPoint(10, 10),
            PointFactory.buildPoint(3, 10),
            PointFactory.buildPoint(10, 3)
    };

    private static final Point[] POINTS_FOR_FIRST_MULTI_ANGLE = {
            PointFactory.buildPoint(3, 3),
            PointFactory.buildPoint(10, 10),
            PointFactory.buildPoint(3, 10),
            PointFactory.buildPoint(10, 3)
    };

    private static final Point[] POINTS_FOR_SECOND_MULTI_ANGLE = {
            PointFactory.buildPoint(9, 3),
            PointFactory.buildPoint(0, 9),
            PointFactory.buildPoint(9, 3),
            PointFactory.buildPoint(8, 3)
    };

    private static final Point[] POINTS_FOR_THIRD_MULTI_ANGLE = {
            PointFactory.buildPoint(-2, 3),
            PointFactory.buildPoint(0, 6.4),
            PointFactory.buildPoint(-3.32, -10.43),
            PointFactory.buildPoint(-1.9, 3.89),
            PointFactory.buildPoint(-9, 3.7),
            PointFactory.buildPoint(1, 3.32)
    };

    private static final Line[] LINES = {
            FigureFactory.buildLine(POINTS_FOR_FIRST_LINE),
            FigureFactory.buildLine(POINTS_FOR_SECOND_LINE)
    };

    private static final Triangle[] TRIANGLES = {
            FigureFactory.buildTriangle(POINTS_FOR_FIRST_TRIANGLE),
            FigureFactory.buildTriangle(POINTS_FOR_SECOND_TRIANGLE)
    };

    private static final Square[] SQUARES = {
            FigureFactory.buildSquare(POINTS_FOR_SQUARE)
    };

    private static final MultiAngleFigure[] MULTI_ANGLE_FIGURES = {
            FigureFactory.buildMultiAngles(POINTS_FOR_FIRST_MULTI_ANGLE),
            FigureFactory.buildMultiAngles(POINTS_FOR_SECOND_MULTI_ANGLE),
            FigureFactory.buildMultiAngles(POINTS_FOR_THIRD_MULTI_ANGLE)
    };

    public static void main(String[] args) {
        PointLogic.printPoints(POINTS);
        LineLogic.printLines(LINES);
        TriangleLogic.printTriangles(TRIANGLES);
        SquareLogic.printSquares(SQUARES);
        MultiAngleFigureLogic.printMultiAngles(MULTI_ANGLE_FIGURES);
    }
}
