package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePreProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePreProcessor;

import java.util.ArrayList;
import java.util.List;

public class PreProcessingFactoryDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private final List<FigurePreProcessor> preProcessors = new ArrayList<>();

    {
        preProcessors.add(new FigureExistencePreProcessor());
    }

    @Override
    public Figure createFigure(FigureType type, List<Point> points, Color color, String name) throws FigureException {
        for (FigurePreProcessor preProcessor : preProcessors) {
            preProcessor.process(points);
        }
        return figureFactory.createFigure(type, points, color, name);
    }

    public PreProcessingFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

}
