package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePostProcessor;

import java.util.ArrayList;
import java.util.List;

public class PostProcessingFactoryDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private final List<FigurePostProcessor> postProcessors = new ArrayList<>();

    {
        postProcessors.add(new FigureExistencePostProcessor());
    }

    @Override
    public Figure createFigure(FigureType type, List<Point> points, Color color, String name) throws FigureException {
        Figure figure = figureFactory.createFigure(type, points, color, name);
        for (FigurePostProcessor postProcessor : postProcessors) {
            figure = postProcessor.process(figure);
        }
        return figure;
    }

    public PostProcessingFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }
}
