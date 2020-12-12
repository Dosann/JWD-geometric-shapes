package com.epam.jwd.task.model;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.storage.impl.FigureCache;
import com.epam.jwd.task.storage.impl.FigureCacheService;

import java.util.List;

public class SimpleFigureFactory implements FigureFactory {

    @Override
    public Figure createFigure(String type, List<Point> points) {

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

    private Line createLineOrFetchFromCache (List<Point> points) {
        for (Figure figure : FigureCache.figuresInTheCache) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                if (FigureCacheService.getInstance().isFigureContainsInTheCache(line, points)) {
                    return line;
                }
            }
        }
        final Line line = new Line(points);
        FigureCache.figuresInTheCache.add(line);
        return line;
    }

    private Triangle createTriangleOrFetchFromCache (List<Point> points) {
        for (Figure figure : FigureCache.figuresInTheCache) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if(FigureCacheService.getInstance().isFigureContainsInTheCache(triangle, points)){
                    return triangle;
                }
            }
        }
        final Triangle triangle = new Triangle(points);
        FigureCache.figuresInTheCache.add(triangle);
        return triangle;

    }

    private Square createSquareOrFetchFromCache (List<Point> points) {
        for (Figure figure : FigureCache.figuresInTheCache) {
            if (figure instanceof Square) {
                Square square = (Square) figure;
                if (FigureCacheService.getInstance().isFigureContainsInTheCache(square, points)) {
                    return square;
                }
            }
        }
        final Square square = new Square(points);
        FigureCache.figuresInTheCache.add(square);
        return square;
    }

    private MultiAngleFigure createMultiangleOrFetchFromCache (List<Point> points) {
        for (Figure figure : FigureCache.figuresInTheCache) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                if (FigureCacheService.getInstance().isFigureContainsInTheCache(multiAngle, points)) {
                    return multiAngle;
                }
            }
        }
        final MultiAngleFigure multiAngle = new MultiAngleFigure(points);
        FigureCache.figuresInTheCache.add(multiAngle);
        return multiAngle;
    }
}


