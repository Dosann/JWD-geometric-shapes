package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Point;
import java.util.List;

public interface FigurePreProcessor {
    void process(List<Point> points) throws FigureException;
}
