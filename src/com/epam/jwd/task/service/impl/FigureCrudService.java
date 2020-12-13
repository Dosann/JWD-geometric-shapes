package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigureCrud;
import com.epam.jwd.task.storage.impl.FigureCache;

import java.util.ArrayList;
import java.util.List;

public class FigureCrudService implements FigureCrud {

    @Override
    public Figure create (FigureFactory figureFactory, String type, List<Point> points) throws FigureException {
        return figureFactory.createFigure(type, points);
    }

    @Override
    public List<Figure> multiCreate(int amountOfWantedFigures, FigureFactory figureFactory, String type,
                                    List<Point> points) throws FigureException {
        List<Figure> figures = new ArrayList<>();
        for (int i = 0; i < amountOfWantedFigures; i++) {
            figures.add(figureFactory.createFigure(type, points));
        }
        return figures;
    }

    @Override
    public void delete(String type, List<Point> points) {

    }


}
