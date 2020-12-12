package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.List;

public interface FigureStorage {
    boolean isFigureContainsInTheCache(Figure figure, List<Point> points);
}
