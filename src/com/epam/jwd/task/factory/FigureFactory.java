package com.epam.jwd.task.factory;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Figure;

import java.util.List;

public interface FigureFactory {
    Figure createFigure(FigureType type, List<Point> points, Color color, String name) throws FigureException;
}
