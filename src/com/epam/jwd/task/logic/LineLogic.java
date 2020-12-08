package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import com.epam.jwd.task.model.Figure;

public class LineLogic {

    private static final Logger LOGGER = LogManager.getLogger(LineLogic.class);

    public static void printLines(Figure[] figures) {
        for (Figure figure : figures) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                LOGGER.log(Level.INFO, "{}\nLength = {}\nArea = {}", line,
                        line.calculatePerimeter(), line.calculateArea());
            }
        }
    }

}
