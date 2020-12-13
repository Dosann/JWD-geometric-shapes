package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.MultiAngleFigure;
import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.model.Triangle;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.model.Figure;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure instanceof Triangle) {
            figure.setTriangleStrategy();
            checkFigureValidation(figure);
        } else if (figure instanceof Square) {
            figure.setSquareStrategy();
            checkFigureValidation(figure);
        } else if (figure instanceof MultiAngleFigure) {
            figure.setMultiAngleStrategy();
            checkFigureValidation(figure);
        }
        return figure;
    }

    private void checkFigureValidation(Figure figure) throws FigureException {
        if (!figure.isFigureExist()) {
            throw new FigureNotExistException("Figure doesn't exist");
        }
    }
}
