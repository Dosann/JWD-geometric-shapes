package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.MultiAngleFigure;

public class MultiAngleFigureLogic {

    public static boolean isExist(MultiAngleFigure multiAngle) {
        return multiAngle.getPoints().size() <= 6 && multiAngle.getPoints().size() >= 4;
    }
}
