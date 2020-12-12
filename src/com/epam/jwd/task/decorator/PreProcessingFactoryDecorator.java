package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePreProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePreProcessor;

import java.util.ArrayList;

public class PreProcessingFactoryDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private ArrayList<FigurePreProcessor> preProcessors = new ArrayList<>();

    {
        preProcessors.add(new FigureExistencePreProcessor());
    }

    public PreProcessingFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(String type, Point[] points) throws FigureException {
        for (FigurePreProcessor preProcessor : preProcessors) {
            preProcessor.process(points);
        }
        Figure figure = figureFactory.createFigure(type, points);
        return figure;
    }
}
