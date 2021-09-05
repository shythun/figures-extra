package com.epam.rd.autotasks.figures;

import java.text.MessageFormat;

class Point {

    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isTheSame(Point point) {
        return Figure.isRelativelyEqual(x, point.x) && Figure.isRelativelyEqual(y, point.y);
    }

    @Override
    public String toString() {
        return MessageFormat.format("({0,number,#0.0}+{1,number,#0.0})", x, y).replace(',', '.').replace('+', ',');
    }

}