package com.epam.jwd.task.app;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.ApplicationContext;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.logic.ReportAction;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.SimpleApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final List<Point> POINTS_FOR_LINE = new ArrayList<>();

    static {

        POINTS_FOR_LINE.add(new Point(0.1, -9.4));
        POINTS_FOR_LINE.add(new Point(0.1, -9.4));
    }

    private static final List<Point> POINTS_FOR_FIRST_TRIANGLE = new ArrayList<>();

    static {

        POINTS_FOR_FIRST_TRIANGLE.add(new Point(-1, 0));
        POINTS_FOR_FIRST_TRIANGLE.add(new Point(-1, 3));
        POINTS_FOR_FIRST_TRIANGLE.add(new Point(3, 0));

    }

    private static final List<Point> POINTS_FOR_SECOND_TRIANGLE = new ArrayList<>();

    static {

        POINTS_FOR_SECOND_TRIANGLE.add(new Point(3, 0));
        POINTS_FOR_SECOND_TRIANGLE.add(new Point(-1, 3));
        POINTS_FOR_SECOND_TRIANGLE.add(new Point(-1, 0));

    }

    private static final List<Point> POINTS_FOR_SQUARE = new ArrayList<>();

    static {

        POINTS_FOR_SQUARE.add(new Point(3, 3));
        POINTS_FOR_SQUARE.add(new Point(10, 10));
        POINTS_FOR_SQUARE.add(new Point(3, 10));
        POINTS_FOR_SQUARE.add(new Point(10, 3));

    }

    private static final List<Point> POINTS_FOR_MULTI_ANGLE = new ArrayList<>();

    static {

        POINTS_FOR_MULTI_ANGLE.add(new Point(-2, 3));
        POINTS_FOR_MULTI_ANGLE.add(new Point(0, 6.3));
        POINTS_FOR_MULTI_ANGLE.add(new Point(-5.62, -13.6));
        POINTS_FOR_MULTI_ANGLE.add(new Point(-5.4, 3.7));
        POINTS_FOR_MULTI_ANGLE.add(new Point(1, 0.99));

    }

    private static final ApplicationContext applicationContext = SimpleApplicationContext.INSTANCE;
    private static final FigureFactory figureFactory = applicationContext.createFigureFactory();

    private static void generateInfoAboutLines() {
        List<Figure> lines = new ArrayList<>();

        {
            try {
                lines.add(figureFactory.createFigure("Line", POINTS_FOR_LINE));

            } catch (FigureException e) {
                LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
            }
        }

        ReportAction.printFigure(lines);
    }

    private static void generateInfoAboutTriangles() {
        List<Figure> triangles = new ArrayList<>();

        {
            try {
                triangles.add(figureFactory.createFigure("Triangle", POINTS_FOR_SECOND_TRIANGLE));
                triangles.add(figureFactory.createFigure("Triangle", POINTS_FOR_FIRST_TRIANGLE));
            } catch (FigureException e) {
                LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
            }
        }

        ReportAction.printFigure(triangles);
    }

    private static void generateInfoAboutSquares() {
        List<Figure> squares = new ArrayList<>();

        {
            try {
                squares.add(figureFactory.createFigure("Square", POINTS_FOR_SQUARE));
            } catch (FigureException e) {
                LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
            }
        }

        ReportAction.printFigure(squares);
    }

    private static void generateInfoAboutMultiAngles() {
        List<Figure> multiAngles = new ArrayList<>();

        {
            try {
                multiAngles.add(figureFactory.createFigure("Multi-angle", POINTS_FOR_MULTI_ANGLE));
            } catch (FigureException e) {
                LOGGER.log(Level.ERROR, "Exception has been thrown:\n{}", e.toString());
            }
        }

        ReportAction.printFigure(multiAngles);
    }

    public static void main(String[] args) {
        generateInfoAboutLines();
        generateInfoAboutTriangles();
        generateInfoAboutSquares();
        generateInfoAboutMultiAngles();
    }

}
