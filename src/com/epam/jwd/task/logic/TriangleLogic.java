package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import com.epam.jwd.task.model.Figure;

public class TriangleLogic {

    private static final Logger LOGGER = LogManager.getLogger(TriangleLogic.class);

    public static boolean isExist(Triangle triangle) {
        double sideA = PointLogic.pointsDestination(triangle.getPoints().get(0), triangle.getPoints().get(1));
        double sideB = PointLogic.pointsDestination(triangle.getPoints().get(0), triangle.getPoints().get(2));
        double sideC = PointLogic.pointsDestination(triangle.getPoints().get(0), triangle.getPoints().get(2));

        double maximumOfSides = Math.max(sideA, sideB);
        if (maximumOfSides < sideC) {
            maximumOfSides = sideC;
        }
        return (maximumOfSides <= sideA + sideB && triangle.calculateArea() != 0);
    }

    public static void printTriangles(Figure[] figures) {
        for (Figure figure : figures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                LOGGER.log(Level.INFO, "{}\nPerimeter = {}\nArea = {}", triangle,
                        triangle.calculatePerimeter(), triangle.calculateArea());
            }
        }
    }
}
