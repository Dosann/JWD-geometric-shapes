package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.MultiAngleFigure;
import com.epam.jwd.task.model.Figure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiAngleFigureLogic {

    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigureLogic.class);

    public static boolean isExist(MultiAngleFigure multiAngle) {
        return multiAngle.getPoints().length <= 6 && multiAngle.getPoints().length >= 4;
    }

    public static void printMultiAngles(Figure[] figures) {
        for (Figure figure : figures) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngle = (MultiAngleFigure) figure;
                LOGGER.log(Level.INFO, "{}", multiAngle);
            }
        }
    }
}
