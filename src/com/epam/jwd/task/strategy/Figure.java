package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.impl.LinePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.SquarePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.TrianglePropertiesStrategy;

public abstract class Figure {

    private FigurePropertiesStrategy strategy;

    public Figure() {
        this.strategy = LinePropertiesStrategy.INSTANCE;
    }

    public void setTriangleStrategy() {
        this.strategy = TrianglePropertiesStrategy.getInstance();
    }

    public void setSquareStrategy() {
        this.strategy = SquarePropertiesStrategy.getInstance();
    }

    public abstract Point[] getPoints();

    public double calculateArea() {
        return strategy.calculateArea(getPoints());
    }

    public double calculatePerimeter() {
        return strategy.calculatePerimeter(getPoints());
    }
}
