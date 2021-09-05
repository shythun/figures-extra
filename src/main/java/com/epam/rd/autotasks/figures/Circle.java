package com.epam.rd.autotasks.figures;

import org.w3c.dom.TypeInfo;

import java.lang.reflect.Type;
import java.text.Format;

class Circle extends Figure{

    private final Point center;
    private final double radius;

    Circle(Point center, double radius) {

        if (center == null) throw new IllegalArgumentException("Circle: null center");
        if (radius <= 0 || isRelativelyEqual(radius, 0)) throw new IllegalArgumentException("Radius should be > 0");

        this.center = center;
        this.radius = radius;

    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String pointsToString() {
        return "(" + center.getX() + "," + center.getY() + ")";
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + "(" + center.getX() + "," + center.getY() + ")" + radius + "]";
    }

    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() != getClass()) return false;
        return center.isTheSame(((Circle) figure).center) && isRelativelyEqual(radius , ((Circle) figure).radius);
    }
}
