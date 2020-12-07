package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.logic.MultiAngleFigureLogic;
import com.epam.jwd.task.logic.SquareLogic;
import com.epam.jwd.task.logic.TriangleLogic;
import com.epam.jwd.task.model.MultiAngleFigure;
import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.model.Triangle;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.strategy.Figure;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure instanceof Triangle) {
            figure.setTriangleStrategy();
            checkTriangleValidation(figure);
        } else if (figure instanceof Square) {
            figure.setSquareStrategy();
            checkSquareValidation(figure);
        } else if (figure instanceof MultiAngleFigure) {
            checkMultiAngleValidation(figure);
        }
        return figure;
    }

    private static void checkTriangleValidation(Figure figure) throws FigureException {
        Triangle triangle = (Triangle) figure;
        if (!TriangleLogic.isExist(triangle)) {
            throw new FigureNotExistException("Triangle doesn't exist");
        }
    }

    private static void checkSquareValidation(Figure figure) throws FigureException {
        Square square = (Square) figure;
        if (!SquareLogic.isExist(square)) {
            throw new FigureNotExistException("Square doesn't exist");
        }
    }

    private static void checkMultiAngleValidation(Figure figure) throws FigureException {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
        if (!MultiAngleFigureLogic.isExist(multiAngleFigure)) {
            throw new FigureNotExistException("MultiAngle doesn't exist");
        }
    }
}
