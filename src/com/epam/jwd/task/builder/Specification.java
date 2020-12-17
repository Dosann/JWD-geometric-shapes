package com.epam.jwd.task.builder;

import com.epam.jwd.task.model.Color;
import com.epam.jwd.task.model.Figure;

public class Specification {

    private final Color color;
    private final String name;
    private final double area;
    private final double perimeter;

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

        public Builder color(Color color) {
            this.color =  color;
            return this;
        }

        public Builder name(String name) {
            this.name =  name;
            return this;
        }

        public Builder area(double area) {
            this.area =  area;
            return this;
        }

        public Builder perimeter(double perimeter) {
            this.perimeter =  perimeter;
            return this;
        }

        public Specification build() {
            return new Specification(this.color, this.name, this.area, this.perimeter);
        }

        //todo: think of logic
        public <T extends Figure> Builder find(Class<T> figureClass) {
            name = figureClass.getName();
            return this;
        }

        public Builder withColor(Color color) {
            this.color =  color;
            return this;
        }

        public Builder withNameStartsWith(String name) {
            this.name =  name;
            return this;
        }

        public Builder withAreaGreaterThan(double area) {
            this.area =  area;
            return this;
        }

        public Builder withAreaLessThen(double area) {
            this.area =  area;
            return this;
        }

        public Builder withPerimeterGreaterThan(double perimeter) {
            this.perimeter =  perimeter;
            return this;
        }

        public Builder withPerimeterLessThan(double perimeter) {
            this.perimeter =  perimeter;
            return this;
        }


    }
}
