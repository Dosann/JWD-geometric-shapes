package com.epam.jwd.task.app;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.ApplicationContext;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.logic.LineLogic;
import com.epam.jwd.task.logic.TriangleLogic;
import com.epam.jwd.task.logic.SquareLogic;
import com.epam.jwd.task.logic.MultiAngleFigureLogic;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.PointFactory;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.SimpleApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final PointFactory pointFactory = PointFactory.getInstance();

    private static final Point[] POINTS_FOR_FIRST_LINE = {
            pointFactory.buildPoint(0.1, -9.4), pointFactory.buildPoint(0.1, -9.4)
    };

    private static final Point[] POINTS_FOR_SECOND_LINE = {
            pointFactory.buildPoint(0.1, -9), pointFactory.buildPoint(-2.1, 4)
    };

    private static final Point[] POINTS_FOR_FIRST_TRIANGLE = {
            pointFactory.buildPoint(-1, 0),
            pointFactory.buildPoint(-1, 3),
            pointFactory.buildPoint(3, 0)
    };

    private static final Point[] POINTS_FOR_SECOND_TRIANGLE = {
            pointFactory.buildPoint(3, 0),
            pointFactory.buildPoint(-1, 3),
            pointFactory.buildPoint(-1, 0)
    };

    private static final Point[] POINTS_FOR_SQUARE = {
            pointFactory.buildPoint(3, 3),
            pointFactory.buildPoint(10, 10),
            pointFactory.buildPoint(3, 10),
            pointFactory.buildPoint(10, 3)
    };

    private static final Point[] POINTS_FOR_FIRST_MULTI_ANGLE = {
            pointFactory.buildPoint(3, 3),
            pointFactory.buildPoint(10, 10),
            pointFactory.buildPoint(3, 10),
            pointFactory.buildPoint(7, 3),
            pointFactory.buildPoint(12, 7)
    };

    private static final Point[] POINTS_FOR_SECOND_MULTI_ANGLE = {
            pointFactory.buildPoint(9, 3),
            pointFactory.buildPoint(0, 9),
            pointFactory.buildPoint(9, 3),
            pointFactory.buildPoint(8, 3)
    };

    private static final Point[] POINTS_FOR_THIRD_MULTI_ANGLE = {
            pointFactory.buildPoint(-2, 3),
            pointFactory.buildPoint(0, 6.4),
            pointFactory.buildPoint(-3.32, -10.43),
            pointFactory.buildPoint(-1.9, 3.89),
            pointFactory.buildPoint(-9, 3.7),
            pointFactory.buildPoint(1, 3.32)
    };

    private static final ApplicationContext applicationContext = SimpleApplicationContext.INSTANCE;
    private static final FigureFactory figureFactory = applicationContext.createFigureFactory();

    private static void generateInfoAboutLines() {
        Figure[] lines = new Figure[0];

        try {
            lines = new Figure[]{
                    figureFactory.createFigure("Line", POINTS_FOR_FIRST_LINE)
            };
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
        }
        LineLogic.printLines(lines);
    }

    private static void generateInfoAboutTriangles() {
        Figure[] triangles = new Figure[0];

        try {
            triangles = new Figure[]{
                    figureFactory.createFigure("Triangle", POINTS_FOR_SECOND_TRIANGLE),
                    figureFactory.createFigure("Triangle", POINTS_FOR_FIRST_TRIANGLE)
            };
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
        }
        TriangleLogic.printTriangles(triangles);
    }

    private static void generateInfoAboutSquares() {
        Figure[] squares = new Figure[0];

        try {
            squares = new Figure[]{
                    figureFactory.createFigure("Square", POINTS_FOR_SQUARE)
            };
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
        }
        SquareLogic.printSquares(squares);
    }

    private static void generateInfoAboutMultiAngles() {
        Figure[] multiAngles = new Figure[0];

        try {
            multiAngles = new Figure[]{
                    figureFactory.createFigure("Multi-angle", POINTS_FOR_THIRD_MULTI_ANGLE)
            };
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
        }
        MultiAngleFigureLogic.printMultiAngles(multiAngles);
    }

    public static void main(String[] args) {
        generateInfoAboutLines();
        generateInfoAboutTriangles();
        generateInfoAboutSquares();
        generateInfoAboutMultiAngles();
    }

}
