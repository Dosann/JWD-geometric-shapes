package com.epam.jwd.task.builder;

public class FigureCriterionBuilder implements Builder {
    private FigureCriterion figureCriterion;

    @Override
    public void reset() {
        figureCriterion = new FigureCriterion();
    }

    @Override
    public void setFigureColor(String color) {
        figureCriterion.setColor(color);
    }

    @Override
    public void setFigureAmountOfAngles(int amountOfAngles) {
        figureCriterion.setAmountOfAngles(amountOfAngles);
    }

    public FigureCriterion getFigureCriterion() {
        return figureCriterion;
    }

}
