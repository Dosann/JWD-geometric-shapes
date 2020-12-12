package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.List;

public class FigureCacheService implements FigureStorage {

    private static class FigureCacheServiceHolder {
        private final static FigureCacheService instance = new FigureCacheService();
    }

    public static FigureCacheService getInstance() {
        return FigureCacheServiceHolder.instance;
    }

    @Override
    public boolean isFigureContainsInTheCache(Figure figure, List<Point> points) {
        int amountOfSamePoints = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (figure.getPoints().get(i).equals(points.get(j))) {
                    amountOfSamePoints++;
                }
            }
        }
        return amountOfSamePoints == points.size();
    }
}
