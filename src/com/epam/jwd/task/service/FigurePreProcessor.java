package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;

public interface FigurePreProcessor {
    void process(Point[] points) throws FigureException;
}
