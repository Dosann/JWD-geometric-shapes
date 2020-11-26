package com.epam.jwd.task.model;

import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.strategy.Figure;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;
import com.epam.jwd.task.strategy.TrianglePropertiesStrategy;

import java.util.Arrays;

public class Triangle extends Figure {
    private Point[] points;
//    public static FigurePropertiesStrategy strategy = TrianglePropertiesStrategy.getInstance();

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Triangle(Point[] points) {
        super(points);
        this.points = points;
    }

//    public Triangle(FigurePropertiesStrategy figurePropertiesStrategy, Point[] points) {
//        super(figurePropertiesStrategy, points);
//    }

    @Override
    public String toString() {
        return "Triangle{\n\t" + Arrays.toString(points) + "\n}";
    }


}
