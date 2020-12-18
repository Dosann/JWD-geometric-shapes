package com.epam.jwd.task.model;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;

import java.util.List;

public class SimpleFigureFactory implements FigureFactory {

    @Override
    public Figure createFigure(FigureType type, List<Point> points, Color color, String name) throws FigureException{

        Figure figure;
        switch (type) {
            case LINE:
                figure = new Line(points, color, name);
                break;
            case TRIANGLE:
                figure = new Triangle(points, color, name);
                break;
            case SQUARE:
                figure = new Square(points, color, name);
                break;
            case MULTIANGLE:
                figure = new MultiAngleFigure(points, color, name);
                break;
            default:
                throw new FigureException("Invalid figure type!");
        }
        return figure;
    }
}


