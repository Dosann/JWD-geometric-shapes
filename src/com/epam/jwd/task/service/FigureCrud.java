package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.List;

public interface FigureCrud {

    Figure create (FigureFactory figureFactory, String type, List<Point> points) throws FigureException;
    List<Figure> multiCreate(int amountOfWantedFigures, FigureFactory figureFactory, String type, List<Point> points)
            throws FigureException;

    void delete(String type, List<Point> points);

}
