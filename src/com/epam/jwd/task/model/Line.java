package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.Figure;
import com.epam.jwd.task.strategy.FigurePropertiesStrategy;
import com.epam.jwd.task.strategy.LinePropertiesStrategy;

import java.util.Arrays;

public class Line extends Figure {
    private Point[] points;
//    public static FigurePropertiesStrategy strategy = LinePropertiesStrategy.INSTANCE;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Line(Point[] points){
        super(points);
        this.points = points;
//        this.points = new Point[2];
//        for(int i = 0; i < 2; i++){
//            this.points[i] = points[i];
//        }
    }

//    public Line(FigurePropertiesStrategy figurePropertiesStrategy, Point[] points) {
//        super(figurePropertiesStrategy, points);
//    }

    @Override
    public String toString() {
        return "Line{\n\t" + Arrays.toString(points) + "\n}";
    }
}
