package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

public interface FigureStorage {
    boolean isFigureContainsInTheCache(Figure figure, Point[] points);
}
