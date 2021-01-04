package com.epam.jwd.task.builder;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.FigureType;

public class Specification {

    private final FigureType type;
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

    private Specification(FigureType type, Color color, String name, double area, double perimeter) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }

    public FigureType getType() {
        return type;
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
                "type=" + type +
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
        private FigureType type;
        private Color color;
        private String name;
        private double area;
        private double perimeter;

        private int nameIndex;
        private int areaIndex;
        private int perimeterIndex;

        public Builder withType(FigureType type) {
            this.type = type;
            return this;
        }

        public Builder withColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder withNameEqualsTo(String name) {
            this.name = name;
            return this;
        }

        public Builder withAreaEqualsTo(double area) {
            this.area = area;
            return this;
        }

        public Builder withPerimeterEqualsTo(double perimeter) {
            this.perimeter = perimeter;
            return this;
        }

        public Specification build() {
            return new Specification(this.type, this.color, this.name, this.area, this.perimeter)
                    .setUpIndex(this.nameIndex, this.areaIndex, this.perimeterIndex);
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
