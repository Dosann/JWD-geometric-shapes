package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
