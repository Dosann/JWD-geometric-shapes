package com.epam.jwd.task.model;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.storage.impl.FigureCache;
import com.epam.jwd.task.storage.impl.FigureCacheService;

public class SimpleFigureFactory implements FigureFactory {

    @Override
    public Figure createFigure(String type, Point[] points) throws FigureException {

        Figure figure;
        switch (type) {
            case "Line":
                figure = createLineOrFetchFromCache(points);
                break;
            case "Triangle":
                figure = createTriangleOrFetchFromCache(points);
                break;
            case "Square":
                figure = createSquareOrFetchFromCache(points);
                break;
            case "Multi-angle":
                figure = createMultiangleOrFetchFromCache(points);
                break;
            default:
                throw new IllegalArgumentException("Invalid figure type!");
        }
        return figure;
    }

    private Line createLineOrFetchFromCache (Point[] points) {
        for (Figure figure : FigureCache.createdFigures) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                if (FigureCacheService.getInstance().isFigureContainsInTheCache(line, points)) {
                    return line;
                }
            }
        }
        final Line line = new Line(points);
        FigureCache.createdFigures[FigureCache.amountOfFigures++] = line;
        return line;
    }

    private Triangle createTriangleOrFetchFromCache (Point[] points) {
        for (Figure figure : FigureCache.createdFigures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if(FigureCacheService.getInstance().isFigureContainsInTheCache(triangle, points)){
                    return triangle;
                }
            }
        }
        final Triangle triangle = new Triangle(points);
        FigureCache.createdFigures[FigureCache.amountOfFigures++] = triangle;
        return triangle;
    }

    private Square createSquareOrFetchFromCache (Point[] points) {
        for (Figure figure : FigureCache.createdFigures) {
            if (figure instanceof Square) {
                Square square = (Square) figure;
                if (FigureCacheService.getInstance().isFigureContainsInTheCache(square, points)) {
                    return square;
                }
            }
        }
        final Square square = new Square(points);
        FigureCache.createdFigures[FigureCache.amountOfFigures++] = square;
        return square;
    }

    private MultiAngleFigure createMultiangleOrFetchFromCache (Point[] points) {
        for (Figure figure : FigureCache.createdFigures) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                if (FigureCacheService.getInstance().isFigureContainsInTheCache(multiAngle, points)) {
                    return multiAngle;
                }
            }
        }
        final MultiAngleFigure multiAngle = new MultiAngleFigure(points);
        FigureCache.createdFigures[FigureCache.amountOfFigures++] = multiAngle;
        return multiAngle;
    }

}


