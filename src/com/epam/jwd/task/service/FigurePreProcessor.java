package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.Figure;

public interface FigurePreProcessor {
    Figure process(Point[] points) throws FigureException;
}
