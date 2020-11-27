package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import com.epam.jwd.task.strategy.Figure;

public class TriangleLogic {

    private static final Logger LOGGER = LogManager.getLogger(TriangleLogic.class);

    public static boolean isTriangle(Triangle triangle) {
        return !(triangle.getPoints()[0].equals(triangle.getPoints()[1]) ||
                triangle.getPoints()[0].equals(triangle.getPoints()[2]) ||
                triangle.getPoints()[1].equals(triangle.getPoints()[2]));
    }

    public static boolean isExist(Triangle triangle) {
        double sideA = PointLogic.pointsDestination(triangle.getPoints()[0], triangle.getPoints()[1]);
        double sideB = PointLogic.pointsDestination(triangle.getPoints()[0], triangle.getPoints()[2]);
        double sideC = PointLogic.pointsDestination(triangle.getPoints()[0], triangle.getPoints()[2]);

        double maximumOfSides = Math.max(sideA, sideB);
        if (maximumOfSides < sideC) {
            maximumOfSides = sideC;
        }
        return (maximumOfSides <= sideA + sideB);
    }

    private static void showInfoAboutTriangle(Triangle triangle){
        triangle.setTriangleStrategy();
        double areaOfTriangle = triangle.calculateArea();
        if (TriangleLogic.isTriangle(triangle)) {
            if (TriangleLogic.isExist(triangle) && areaOfTriangle != 0) {
                LOGGER.log(Level.INFO, "{}\nPerimeter = {}\nArea = {}", triangle,
                        triangle.calculatePerimeter(), areaOfTriangle);
            } else {
                LOGGER.log(Level.ERROR, "{} can't exist", triangle);
            }
        } else {
            LOGGER.log(Level.ERROR, "Object {} can't be a triangle!", triangle);
        }
    }

    public static void printTriangles(Figure[] figures) {
        for (Figure figure : figures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                TriangleLogic.showInfoAboutTriangle(triangle);
            }
        }
    }
}
