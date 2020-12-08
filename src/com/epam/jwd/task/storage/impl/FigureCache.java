package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.storage.FigureStorage;

public class FigureCache implements FigureStorage {

    private static class SimpleFigureStorageHolder {
        private final static FigureCache instance = new FigureCache();
    }

    public static FigureCache getInstance() {
        return SimpleFigureStorageHolder.instance;
    }

    public static int amountOfFigures = 0;
    public static final Figure[] createdFigures = new Figure[amountOfFigures];

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
