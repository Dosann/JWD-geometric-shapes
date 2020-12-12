package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Triangle;

public class TriangleLogic {

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

}
