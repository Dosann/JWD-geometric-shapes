package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;


public class SquareLogic {

    private static final Logger LOGGER = LogManager.getLogger(SquareLogic.class);

    private static double squarePointsDestination(Point p1, Point p2) {
        double xDestination = Math.abs(p1.getX()- p2.getX());
        double yDestination = Math.abs(p1.getY() - p2.getY());
        return Math.pow(xDestination, 2) + Math.pow(yDestination, 2);
    }

    public static double[] destinationsFromOnePoint(Square square) {
        double[] sides = new double[3];
        sides[0] = SquareLogic.squarePointsDestination(square.getPoints()[0], square.getPoints()[1]);
        sides[1] = SquareLogic.squarePointsDestination(square.getPoints()[0], square.getPoints()[2]);
        sides[2] = SquareLogic.squarePointsDestination(square.getPoints()[0], square.getPoints()[3]);
        return sides;
    }

    public static boolean isSquare(Square square) {
        double[] sides = SquareLogic.destinationsFromOnePoint(square);
        for (double side : sides) {
            if(side == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isExist(Square square) {
        double[] sides = SquareLogic.destinationsFromOnePoint(square);

        if (sides[0] == sides[1] && 2.0 * sides[0] == sides[2]
                && 2.0 * SquareLogic.squarePointsDestination(square.getPoints()[1], square.getPoints()[3]) ==
                SquareLogic.squarePointsDestination(square.getPoints()[1], square.getPoints()[2])){
            return true;
        }

        if (sides[1] == sides[2] && 2.0 * sides[1] == sides[0]
                && 2.0 * SquareLogic.squarePointsDestination(square.getPoints()[1], square.getPoints()[2]) ==
                SquareLogic.squarePointsDestination(square.getPoints()[2], square.getPoints()[3])){
            return true;
        }

        if (sides[0] == sides[2] && 2.0 * sides[0] == sides[1]
                && 2.0 * SquareLogic.squarePointsDestination(square.getPoints()[1], square.getPoints()[2]) ==
                SquareLogic.squarePointsDestination(square.getPoints()[1], square.getPoints()[3])){
            return true;
        }
        return false;
    }

    public static void printSquares(Square[] squares){
        for (Square square : squares) {
            if (SquareLogic.isSquare(square)) {
                if (SquareLogic.isExist(square)) {
                    LOGGER.log(Level.INFO, "{}", square);
                } else {
                    LOGGER.log(Level.ERROR, "{} can't exist", square);
                }
            } else {
                LOGGER.log(Level.ERROR, "Object {} can't be a square!", square);
            }
        }
    }
}
