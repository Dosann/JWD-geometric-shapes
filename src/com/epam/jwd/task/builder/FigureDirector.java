package com.epam.jwd.task.builder;

public class FigureDirector {

    public void constructBrightMultiAngle(Builder builder) {
        builder.reset();
        builder.setFigureAmountOfAngles(4);
        builder.setFigureColor("Orange");
    }

    public void constructDarkMultiAngle(Builder builder) {
        builder.reset();
        builder.setFigureAmountOfAngles(6);
        builder.setFigureColor("Midnight blue");
    }
}
