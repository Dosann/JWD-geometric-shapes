package com.epam.jwd.task.model;

import com.epam.jwd.task.decorator.PostProcessingFactoryDecorator;
import com.epam.jwd.task.decorator.PreProcessingFactoryDecorator;
import com.epam.jwd.task.factory.ApplicationContext;
import com.epam.jwd.task.factory.FigureFactory;

public class SimpleApplicationContext implements ApplicationContext {

    @Override
    public FigureFactory createFigureFactory() {
        return new PostProcessingFactoryDecorator(new PreProcessingFactoryDecorator(new SimpleFigureFactory()));
    }
}
