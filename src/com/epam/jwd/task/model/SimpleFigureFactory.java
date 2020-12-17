package com.epam.jwd.task.model;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;

import java.util.List;

public class SimpleFigureFactory implements FigureFactory {

    @Override
    public Figure createFigure(String type, List<Point> points) throws FigureException{

        Figure figure;
        switch (type) {
            case "Line":
                figure = new Line(points);
                break;
            case "Triangle":
                figure = new Triangle(points);
                break;
            case "Square":
                figure = new Square(points);
                break;
            case "MultiAngle":
                figure = new MultiAngleFigure(points);
                break;
            default:
                throw new FigureException("Invalid figure type!");
        }
        return figure;
    }
}


