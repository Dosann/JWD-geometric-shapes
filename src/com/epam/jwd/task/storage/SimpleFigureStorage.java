package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

public class SimpleFigureStorage implements FigureStorage {

    private static class SimpleFigureStorageHolder {
        private final static SimpleFigureStorage instance = new SimpleFigureStorage();
    }

    public static SimpleFigureStorage getInstance() {
        return SimpleFigureStorageHolder.instance;
    }

    public static final Figure[] createdFigures = new Figure[12];
    public static int amountOfFigures = 0;

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
