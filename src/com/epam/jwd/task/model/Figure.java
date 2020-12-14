package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.FigurePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.LinePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.MultiAnglePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.SquarePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.TrianglePropertiesStrategy;

import java.util.List;

public abstract class Figure {

    private FigurePropertiesStrategy strategy;
    private String figureColor;

    public Figure() {
        this.strategy = LinePropertiesStrategy.INSTANCE;
    }

    public void setTriangleStrategy() {
        this.strategy = TrianglePropertiesStrategy.getInstance();
    }

    public void setSquareStrategy() {
        this.strategy = SquarePropertiesStrategy.getInstance();
    }

    public void setMultiAngleStrategy() {
        this.strategy = MultiAnglePropertiesStrategy.getInstance();
    }

    public abstract List<Point> getPoints();

    public double calculateArea() {
        return strategy.calculateArea(getPoints());
    }

    public double calculatePerimeter() {
        return strategy.calculatePerimeter(getPoints());
    }

    public boolean isFigureExist() {
        return strategy.isExist(getPoints());
    }

    public String getFigureColor() {
        return figureColor;
    }

    public void setFigureColor(String figureColor) {
        this.figureColor = figureColor;
    }
}
