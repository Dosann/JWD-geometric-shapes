package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Figure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ReportAction {

    private static final Logger LOGGER = LogManager.getLogger(ReportAction.class);

    public static <T extends Figure> void printFigure(List<T> figures) {
        for(Figure figure : figures){
            LOGGER.log(Level.INFO, "{}\nLength = {}\nArea = {}", figure,
                    figure.calculatePerimeter(), figure.calculateArea());
        }
    }
}
