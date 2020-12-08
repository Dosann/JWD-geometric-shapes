package com.epam.jwd.task.model;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.FigurePreProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePreProcessor;
import com.epam.jwd.task.strategy.Figure;

public class FigureFactory {

    private static final Figure[] createdFigures = new Figure[12];
    private static int amountOfFigures = 0;

    private static boolean isSameFigureInTheCache(Figure figure, Point[] points) {
        int amountOfSamePoints = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (figure.getPoints()[i].equals(points[j])) {
                    amountOfSamePoints++;
                }
            }
        }
        return amountOfSamePoints == points.length;
    }

    private static Line createLine(Point[] points){
        for (Figure figure : createdFigures) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                if (isSameFigureInTheCache(line, points)) {
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
                if(isSameFigureInTheCache(triangle, points)){
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
                if (isSameFigureInTheCache(square, points)) {
                    return square;
                }
            }
        }
        final Square square = new Square(points);
        createdFigures[amountOfFigures++] = square;
        return square;
    }

    private static MultiAngleFigure createMultiAngle(Point[] points){
        for (Figure figure : createdFigures) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                if (isSameFigureInTheCache(multiAngle, points)) {
                    return multiAngle;
                }
            }
        }
        final MultiAngleFigure multiAngle = new MultiAngleFigure(points);
        createdFigures[amountOfFigures++] = multiAngle;
        return multiAngle;
    }

    private static final FigurePreProcessor figurePreProcessor = new FigureExistencePreProcessor();
    private static final FigurePostProcessor figurePostProcessor = new FigureExistencePostProcessor();


    public static Figure buildFigure(String type, Point[] points) throws FigureException {
        figurePreProcessor.process(points);

        Figure figure;
        switch (type) {
            case "Line":
                figure = createLine(points);
                break;
            case "Triangle":
                figure = createTriangle(points);
                break;
            case "Square":
                figure = createSquare(points);
                break;
            default:
                figure = createMultiAngle(points);
                break;
        }

        figure = figurePostProcessor.process(figure);
        return figure;
    }
}
