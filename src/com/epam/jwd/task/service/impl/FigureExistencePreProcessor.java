package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePreProcessor;

public class FigureExistencePreProcessor implements FigurePreProcessor {

    @Override
    public void process(Point[] points) throws FigureException {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    throw new FigureNotExistException("Can't create a figure from the same points");
                }
            }
        }
    }
}
