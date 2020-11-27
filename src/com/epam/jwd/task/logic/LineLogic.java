package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import com.epam.jwd.task.strategy.Figure;

public class LineLogic {

    private static final Logger LOGGER = LogManager.getLogger(LineLogic.class);

    public static boolean isLine(Line line) {
        return !line.getPoints()[0].equals(line.getPoints()[1]);
    }

    public static void printLines(Figure[] figures) {
        Line[] lines = (Line[])figures;
        for (Line line : lines) {
            if (LineLogic.isLine(line)) {
                LOGGER.log(Level.INFO, "{}\nLength = {}\nArea = {}", line,
                        line.calculatePerimeter(), line.calculateArea());
            } else {
                LOGGER.log(Level.ERROR, "Object {} can't be a line!", line);
            }
        }
    }
}
