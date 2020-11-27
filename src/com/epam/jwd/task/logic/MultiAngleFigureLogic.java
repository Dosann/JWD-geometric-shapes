package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.MultiAngleFigure;
import com.epam.jwd.task.strategy.Figure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiAngleFigureLogic {

    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigureLogic.class);

    public static boolean isMultiAngle(MultiAngleFigure multiAngle){
        for(int i = 0; i < multiAngle.getPoints().length; i++) {
            for (int j = i + 1; j < multiAngle.getPoints().length; j++) {
                if (multiAngle.getPoints()[i].equals(multiAngle.getPoints()[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isExist(MultiAngleFigure multiAngle) {
        return multiAngle.getPoints().length <= 6 && multiAngle.getPoints().length >= 4;
    }

    public static void printMultiAngles(Figure[] figures){
        MultiAngleFigure[] multiAngles = (MultiAngleFigure[]) figures;
        for (MultiAngleFigure multiAngle : multiAngles) {
            if (MultiAngleFigureLogic.isMultiAngle(multiAngle)) {
                if (MultiAngleFigureLogic.isExist(multiAngle)) {
                    multiAngle.setSquareStrategy();
                    LOGGER.log(Level.INFO, "{}", multiAngle);
                } else {
                    LOGGER.log(Level.ERROR, "{} can't exist", multiAngle);
                }
            } else {
                LOGGER.log(Level.ERROR, "Object {} can't be a multi-angle!", multiAngle);
            }
        }
    }

}
