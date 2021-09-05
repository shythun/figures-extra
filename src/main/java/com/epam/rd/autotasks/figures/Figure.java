package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;

abstract class Figure{

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);

    public static boolean isRelativelyEqual(double d1, double d2) {
        return abs(d1 - d2) < 0.001;
    }
}
