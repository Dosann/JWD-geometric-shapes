package com.epam.jwd.task.model;

import com.epam.jwd.task.strategy.FigurePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.LinePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.MultiAnglePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.SquarePropertiesStrategy;
import com.epam.jwd.task.strategy.impl.TrianglePropertiesStrategy;

import java.util.List;
import java.util.UUID;

public abstract class Figure {

    private FigurePropertiesStrategy strategy;
    private final UUID id;
    private final FigureType type;
    private final Color color;
    private final String name;

    public Figure(FigureType type, Color color, String name) {
        this.strategy = LinePropertiesStrategy.INSTANCE;
        id = UUID.randomUUID();
        this.type = type;
        this.color = color;
        this.name = name;
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

    public UUID getId() {
        return id;
    }

    public FigureType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double calculateArea() {
        return strategy.calculateArea(getPoints());
    }

    public double calculatePerimeter() {
        return strategy.calculatePerimeter(getPoints());
    }

    public boolean isFigureExist() {
        return strategy.isExist(getPoints());
    }
}
