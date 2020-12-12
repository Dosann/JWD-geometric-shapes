package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePreProcessor;

import java.util.List;

public class FigureExistencePreProcessor implements FigurePreProcessor {

    @Override
    public void process(List<Point> points) throws FigureException {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).equals(points.get(j))) {
                    throw new FigureNotExistException("Can't create a figure from the same points");
                }
            }
        }
    }
}
