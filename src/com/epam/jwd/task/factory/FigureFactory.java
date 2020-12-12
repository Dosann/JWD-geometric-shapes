package com.epam.jwd.task.factory;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Figure;

import java.util.List;

public interface FigureFactory {
    Figure createFigure(String type, List<Point> points) throws FigureException;
}
