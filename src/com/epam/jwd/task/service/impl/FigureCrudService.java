package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.builder.Specification;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.ApplicationContext;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.SimpleApplicationContext;
import com.epam.jwd.task.service.FigureCrud;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public enum FigureCrudService implements FigureCrud {
    INSTANCE;

    private static final ApplicationContext applicationContext = SimpleApplicationContext.INSTANCE;
    private static final FigureFactory figureFactory = applicationContext.createFigureFactory();

    @Override
    public Figure createFigure (String type, List<Point> points, Color color, String name) throws FigureException {
        return figureFactory.createFigure(type, points, color, name);
    }

    @Override
    public List<Figure> multiCreateFigures (int amountOfWantedFigures, String type, List<Point> points,
                                            Color color, String name) throws FigureException {
        List<Figure> figures = new ArrayList<>();
        for (int i = 0; i < amountOfWantedFigures; i++) {
            figures.add(figureFactory.createFigure(type, points, color, name));
        }
        return figures;
    }

    @Override
    public void saveFigure (List<Figure> figure) {
        FigureStorage.figuresInTheCache.addAll(figure);
    }

    @Override
    public void deleteFigure (Figure figure) {
        FigureStorage.figuresInTheCache.remove(figure);
    }

    @Override
    public Optional<Figure> findFigure (Figure figure) {
        if (figure == null) {
            return Optional.empty();
        }
        return FigureStorage.figuresInTheCache
                .stream()
                .filter(figure::equals)
                .findFirst();
    }

    @Override
    public void updateFigure (Figure oldFigure, Figure newFigure) {
        int indexOfOldFigure = FigureStorage.figuresInTheCache.indexOf(oldFigure);
        FigureStorage.figuresInTheCache.remove(oldFigure);
        FigureStorage.figuresInTheCache.add(indexOfOldFigure, newFigure);
    }

    @Override
    public Optional<Figure> findFigureById(UUID uuid) {
        if(uuid == null) {
            return Optional.empty();
        }

        return FigureStorage.figuresInTheCache
                .stream()
                .filter(figure -> figure.getId().equals(uuid))
                .findFirst();
    }


    @Override
    public List<Figure> findFigureByCriterion(Specification specification) {
        if(specification == null) {
            return FigureStorage.figuresInTheCache;
        }

        return FigureStorage.figuresInTheCache
                .stream()
                .filter(figures -> (
                        checkWithArea(figures, specification) &&
                        checkWithPerimeter(figures, specification) &&
                        checkWithColor(figures, specification) &&
                        checkWithName(figures, specification)))
                .collect(Collectors.toList());
    }

    private boolean checkWithArea (Figure figure, Specification specification) {
        return specification.getAreaIndex() == 1 ? figure.calculateArea() > specification.getArea() :
                (specification.getAreaIndex() == -1 ? figure.calculateArea() < specification.getArea() :
                        figure.calculateArea() == specification.getArea());
    }

    private boolean checkWithPerimeter (Figure figure, Specification specification) {
        return specification.getPerimeterIndex() == 1 ? figure.calculatePerimeter() > specification.getPerimeter() :
                (specification.getPerimeterIndex() == -1 ? figure.calculatePerimeter() < specification.getPerimeter() :
                        figure.calculatePerimeter() == specification.getPerimeter());
    }

    private boolean checkWithColor (Figure figure, Specification specification) {
        return figure.getColor() == specification.getColor();
    }

    private boolean checkWithName (Figure figure, Specification specification) {
        return specification.getNameIndex() == 1 ? figure.getName().startsWith(specification.getName()) :
                (specification.getNameIndex() == -1 ? figure.getName().endsWith(specification.getName()) :
                        figure.getName().equals(specification.getName()));
    }

}
