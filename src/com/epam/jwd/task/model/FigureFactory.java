package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;

public class FigureFactory {

    private static final Figure[] createdFigures = new Figure[12];
    private static int amountOfFigures = 0;

    private static Line createLine(Point[] points){
        for (Figure figure : createdFigures){
            if(figure instanceof Line){
                Line line = (Line) figure;
                if(line.getPoints() == points) {
                    return line;
                }
            }
        }
        final Line line = new Line(points);
        createdFigures[amountOfFigures++] = line;
        return line;
    }

    public static Line buildLine(Point[] points){
        return createLine(points);
    }

    private static Triangle createTriangle(Point[] points){
        for (Figure figure : createdFigures){
            if(figure instanceof Triangle){
                Triangle triangle = (Triangle) figure;
                if(triangle.getPoints() == points) {
                    return triangle;
                }
            }
        }
        final Triangle triangle = new Triangle(points);
        createdFigures[amountOfFigures++] = triangle;
        return triangle;
    }

    public static Triangle buildTriangle(Point[] points){
        return createTriangle(points);
    }

    private static Square createSquare(Point[] points){
        for (Figure figure : createdFigures){
            if(figure instanceof Square){
                Square square = (Square) figure;
                if(square.getPoints() == points) {
                    return square;
                }
            }
        }
        final Square square = new Square(points);
        createdFigures[amountOfFigures++] = square;
        return square;
    }

    public static Square buildSquare(Point[] points){
        return createSquare(points);
    }

    private static MultiAngleFigure createMultiAngles(Point[] points){
        for (Figure figure : createdFigures){
            if(figure instanceof MultiAngleFigure){
                MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                if(multiAngle.getPoints() == points) {
                    return multiAngle;
                }
            }
        }
        final MultiAngleFigure multiAngle = new MultiAngleFigure(points);
        createdFigures[amountOfFigures++] = multiAngle;
        return multiAngle;
    }

    public static MultiAngleFigure buildMultiAngles(Point[] points){
        return createMultiAngles(points);
    }

}
