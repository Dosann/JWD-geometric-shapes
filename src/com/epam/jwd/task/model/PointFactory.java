//package com.epam.jwd.task.model;
//
//public class PointFactory {
//
//    private static class PointFactoryHolder {
//        private final static PointFactory instance = new PointFactory();
//    }
//
//    public static PointFactory getInstance() {
//        return PointFactory.PointFactoryHolder.instance;
//    }
//
//    private static final Point[] createdPoints = new Point[42];
//    private static int amountOfPoints = 0;
//
//    public Point buildPoint(double x, double y){
//        final Point point = new Point(x, y);
//        createdPoints[amountOfPoints++] = point;
//        return point;
//    }
//}
