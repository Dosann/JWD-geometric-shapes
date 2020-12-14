package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.builder.FigureCriterion;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigureCrud;
import com.epam.jwd.task.storage.impl.FigureCache;
import com.epam.jwd.task.storage.impl.FigureCacheService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum FigureCrudService implements FigureCrud {
    INSTANCE;

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
    public void save(Figure figure) {
        if (!FigureCacheService.getInstance().isFigureContainsInTheCache(figure, figure.getPoints())) {
            FigureCache.figuresInTheCache.add(figure);
        }
    }

    @Override
    public void delete(Figure figure) {
        FigureCache.figuresInTheCache.remove(figure);
    }

    @Override
    public Figure find(Figure figure) {
        Optional <Figure> foundFigure = FigureCache.figuresInTheCache.
                stream().
                filter(figure::equals).
                findFirst();
        return foundFigure.orElseThrow();
    }

    @Override
    public void update(int index, Figure figure) {
        FigureCache.figuresInTheCache.add(index, figure);
    }

    @Override
    public Figure findById(int index) {
        Optional <Figure> figureByIndex = FigureCache.figuresInTheCache.
                stream().
                skip(index).
                findFirst();
        return figureByIndex.orElseThrow();
    }

    @Override
    public List<Figure> findByCriterion(FigureCriterion figureCriterion) {
        return FigureCache.figuresInTheCache.
                stream().
                filter((figures)-> checkForCriterion(figures, figureCriterion)).
                collect(Collectors.toList());
    }

    private boolean checkForCriterion(Figure figure, FigureCriterion figureCriterion) {
        return figure.getFigureColor().equals(figureCriterion.getColor()) && (figure.getPoints().size() ==
                figureCriterion.getAmountOfAngles());
    }

}
