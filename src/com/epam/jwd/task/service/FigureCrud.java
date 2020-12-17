package com.epam.jwd.task.service;

import com.epam.jwd.task.builder.Specification;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FigureCrud {

    Figure createFigure (String type, List<Point> points, Color color, String name) throws FigureException;
    List<Figure> multiCreateFigures (int amountOfWantedFigures, String type, List<Point> points,
                                     Color color, String name) throws FigureException;

    void saveFigure (List<Figure> figure);
    default void saveFigure (Figure figure) {
        FigureStorage.figuresInTheCache.add(figure);
    }

    void deleteFigure (Figure figure);
    Optional<Figure> findFigure (Figure figure);
    void updateFigure (Figure oldFigure, Figure newFigure);
    Optional<Figure> findFigureById(UUID uuid);
    List<Figure> findFigureBySpecification(Specification specification);
}
