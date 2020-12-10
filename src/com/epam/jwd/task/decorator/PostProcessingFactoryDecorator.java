package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePostProcessor;

public class PostProcessingFactoryDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private final FigurePostProcessor[] postProcessors = {new FigureExistencePostProcessor()};

    public PostProcessingFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(String type, Point[] points) throws FigureException {
        Figure figure = figureFactory.createFigure(type, points);
        for (FigurePostProcessor postProcessor : postProcessors) {
            figure = postProcessor.process(figure);
        }
        return figure;
    }
}
