package com.epam.jwd.task.app;

import com.epam.jwd.task.builder.Specification;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.service.impl.FigureCrudService;
import com.epam.jwd.task.storage.FigureStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final List<Point> POINTS_FOR_LINE = new ArrayList<>();

    static {

        POINTS_FOR_LINE.add(new Point(0.1, -9.4));
        POINTS_FOR_LINE.add(new Point(0.1, 9.4));
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

    public static void main(String[] args) {
        testFigureCrudService();
    }

    private static void testFigureCrudService () {

        FigureCrudService figureCrudService = FigureCrudService.INSTANCE;

        try {
            Figure square = figureCrudService.createFigure("Square", POINTS_FOR_SQUARE, Color.PURPLE, "ASquare");
            Figure triangle1 = figureCrudService.createFigure("Triangle", POINTS_FOR_FIRST_TRIANGLE, Color.PURPLE, "ATriangle");
            Figure triangle2 = figureCrudService.createFigure("Triangle", POINTS_FOR_SECOND_TRIANGLE, Color.BLUE, "BTriangle");
            Figure multiangle = figureCrudService.createFigure("MultiAngle", POINTS_FOR_MULTI_ANGLE, Color.GREEN, "AMulti");

            figureCrudService.saveFigure(square);
            figureCrudService.saveFigure(Arrays.asList(triangle1, triangle2));


            LOGGER.log(Level.INFO, "{}", figureCrudService.findFigureById(null));

            Specification specification = Specification.builder()
//                    .find(Square.class)
                    .withAreaGreaterThan(0)
                    .withColor(Color.PURPLE)
                    .withNameStartsWith("A")
                    .withPerimeterLessThan(50)
                    .build();

            LOGGER.log(Level.INFO, "Figures found by specification: {}",
                    figureCrudService.findFigureByCriterion(specification));

        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Exception occurred: {}", e.toString());
        }

    }

}
