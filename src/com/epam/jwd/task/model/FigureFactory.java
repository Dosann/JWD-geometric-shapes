package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;

public class FigureFactory {

    private static final Figure[] createdFigures = new Figure[12];
    private static int amountOfFigures = 0;

    private static Line createLine(Point[] points){
        for (Figure figure : createdFigures) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                if (line.getPoints() == points) {
                    return line;
                }
            }
        }
        final Line line = new Line(points);
        createdFigures[amountOfFigures++] = line;
        return line;
    }

    private static Triangle createTriangle(Point[] points){
        for (Figure figure : createdFigures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (triangle.getPoints() == points) {
                    return triangle;
                }
            }
        }
        final Triangle triangle = new Triangle(points);
        createdFigures[amountOfFigures++] = triangle;
        return triangle;
    }

    private static Square createSquare(Point[] points){
        for (Figure figure : createdFigures) {
            if (figure instanceof Square) {
                Square square = (Square) figure;
                if (square.getPoints() == points) {
                    return square;
                }
            }
        }
        final Square square = new Square(points);
        createdFigures[amountOfFigures++] = square;
        return square;
    }

    private static MultiAngleFigure createMultiAngles(Point[] points){
        for (Figure figure : createdFigures) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                if (multiAngle.getPoints() == points) {
                    return multiAngle;
                }
            }
        }
        final MultiAngleFigure multiAngle = new MultiAngleFigure(points);
        createdFigures[amountOfFigures++] = multiAngle;
        return multiAngle;
    }

    public static Figure buildFigure(String type, Point[] points) {
        switch (type) {
            case "Line":
                return createLine(points);
            case "Triangle":
                return createTriangle(points);
            case "Square":
                return createSquare(points);
            default:
                return createMultiAngles(points);
        }
    }
}
