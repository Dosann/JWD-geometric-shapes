package com.epam.jwd.task.builder;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;

public class Specification {

    private final Color color;
    private final String name;
    private final double area;
    private final double perimeter;

    private int nameIndex;
    private int areaIndex;
    private int perimeterIndex;

    private Specification setUpIndex(int nameIndex, int areaIndex, int perimeterIndex) {
        this.nameIndex = nameIndex;
        this.areaIndex = areaIndex;
        this.perimeterIndex = perimeterIndex;
        return this;
    }

    public Specification(Color color, String name, double area, double perimeter) {
        this.color = color;
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getAreaIndex() {
        return areaIndex;
    }

    public int getPerimeterIndex() {
        return perimeterIndex;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Color color;
        private String name;
        private double area;
        private double perimeter;

        private int nameIndex;
        private int areaIndex;
        private int perimeterIndex;

        public Builder withColor(Color color) {
            this.color =  color;
            return this;
        }

        public Builder withNameEqualsTo(String name) {
            this.name =  name;
            return this;
        }

        public Builder withAreaEqualsTo(double area) {
            this.area =  area;
            return this;
        }

        public Builder withPerimeterEqualsTo(double perimeter) {
            this.perimeter =  perimeter;
            return this;
        }

        public Specification build() {
            return new Specification(this.color, this.name, this.area, this.perimeter)
                    .setUpIndex(this.nameIndex, this.areaIndex, this.perimeterIndex);
        }

        //todo: think of logic
        public <T extends Figure> Builder find(Class<T> figureClass) {
//            name = figureClass.getName();
            return this;
        }

        public Builder withNameStartsWith(String name) {
           this.nameIndex = 1;
            return withNameEqualsTo(name);
        }

        public Builder withNameEndsWith(String name) {
            this.nameIndex = -1;
            return withNameEqualsTo(name);
        }

        public Builder withAreaGreaterThan(double area) {
            this.areaIndex = 1;
            return withAreaEqualsTo(area);
        }

        public Builder withAreaLessThen(double area) {
            this.areaIndex = -1;
            return withAreaEqualsTo(area);
        }

        public Builder withPerimeterGreaterThan(double perimeter) {
            this.perimeterIndex = 1;
            return withPerimeterEqualsTo(perimeter);
        }

        public Builder withPerimeterLessThan(double perimeter) {
           this.perimeterIndex = -1;
           return withPerimeterEqualsTo(perimeter);
        }
    }
}
