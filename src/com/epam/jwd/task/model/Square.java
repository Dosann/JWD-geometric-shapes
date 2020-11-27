package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;
import com.epam.jwd.task.strategy.SquarePropertiesStrategy;

import java.util.Arrays;

public class Square extends Figure {
    private Point[] points;
//    public static FigurePropertiesStrategy strategy = SquarePropertiesStrategy.getInstance();

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    Square(Point[] points) {
        super(points);
        this.points = points;
    }

//    public Square(FigurePropertiesStrategy figurePropertiesStrategy, Point[] points) {
//        super(figurePropertiesStrategy, points);
//    }

    @Override
    public String toString() {
        return "Square{\n\t" + Arrays.toString(points) + "\n}";
    }

}
