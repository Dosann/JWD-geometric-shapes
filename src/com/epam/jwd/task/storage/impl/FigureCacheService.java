package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.storage.FigureStorage;

public class FigureCacheService implements FigureStorage {

    private static class FigureCacheServiceHolder {
        private final static FigureCacheService instance = new FigureCacheService();
    }

    public static FigureCacheService getInstance() {
        return FigureCacheServiceHolder.instance;
    }

    @Override
    public boolean isFigureContainsInTheCache(Figure figure, Point[] points) {
        int amountOfSamePoints = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (figure.getPoints()[i].equals(points[j])) {
                    amountOfSamePoints++;
                }
            }
        }
        return amountOfSamePoints == points.length;
    }
}
