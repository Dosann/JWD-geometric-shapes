package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class TriangleLogic {

    private static final Logger LOGGER = LogManager.getLogger(TriangleLogic.class);

    public static boolean isTriangle(Triangle triangle) {
        return !(triangle.getPoints()[0].equals(triangle.getPoints()[1]) ||
                triangle.getPoints()[0].equals(triangle.getPoints()[2]) ||
                triangle.getPoints()[1].equals(triangle.getPoints()[2]));
    }

    public static boolean isPointsLieOnStraightLine(Triangle triangle) {
        double area = triangle.getPoints()[0].getX() * (triangle.getPoints()[1].getY() -
                triangle.getPoints()[2].getY()) + triangle.getPoints()[1].getX() *
                (triangle.getPoints()[2].getY() - triangle.getPoints()[0].getY()) +
                triangle.getPoints()[2].getX() * (triangle.getPoints()[0].getY() - triangle.getPoints()[1].getY());
        return area == 0;
    }

    public static boolean isExist(Triangle triangle) {
        double sideA = PointLogic.pointsDestination(triangle.getPoints()[0], triangle.getPoints()[1]);
        double sideB = PointLogic.pointsDestination(triangle.getPoints()[0], triangle.getPoints()[2]);
        double sideC = PointLogic.pointsDestination(triangle.getPoints()[0], triangle.getPoints()[2]);

        double maximumOfSides = Math.max(sideA, sideB);
        if (maximumOfSides < sideC) {
            maximumOfSides = sideC;
        }
        return (maximumOfSides <= sideA + sideB) &&
                (!TriangleLogic.isPointsLieOnStraightLine(triangle));
    }

    public static void printTriangles(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            if (TriangleLogic.isTriangle(triangle)) {
                if (TriangleLogic.isExist(triangle)) {
                    LOGGER.log(Level.INFO, "{}", triangle);
                } else {
                    LOGGER.log(Level.ERROR, "{} can't exist", triangle);
                }
            } else {
                LOGGER.log(Level.ERROR, "Object {} can't be a triangle!", triangle);
            }
        }
    }
}
