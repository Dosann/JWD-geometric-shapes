package com.epam.jwd.task.factory;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Figure;

public interface FigureFactory {
    Figure createFigure(String type, Point[] points) throws FigureException;
}
