package com.epam.rd.autotasks.figures;

import java.util.*;

class Quadrilateral extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;
    private final Segment ab;
    private final Segment bc;
    private final Segment cd;
    private final Segment da;
    private final Triangle abc;
    private final Triangle adc;
    private final Triangle bcd;
    private final Triangle bad;

    public Quadrilateral(Point a, Point b, Point c, Point d) {

        ab = new Segment(a, b);
        bc = new Segment(b, c);
        cd = new Segment(c, d);
        da = new Segment(d, a);

        if (ab.intersection(cd) != null) throw new IllegalArgumentException("Not plain: AB intersects CD");
        if (bc.intersection(da) != null) throw new IllegalArgumentException("Not plain: BC intersects DA");

        abc = new Triangle(a, b, c);
        adc = new Triangle(a, d, c);
        bcd = new Triangle(b, c, d);
        bad = new Triangle(b, a, d);

        if (!isRelativelyEqual(abc.area() + adc.area(), bcd.area() + bad.area()))
            throw new IllegalArgumentException("Non convex");

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double area() {
        return new Triangle(a, b, c).area() + new Triangle(a, d, c).area();
    }

    public String pointsToString() {
        return "" + a + b + c + d;
    }

    public Point leftmostPoint() {

        double[] points = new double[]{
                a.getX(),
                b.getX(),
                c.getX(),
                d.getX()
        };

        Arrays.sort(points);

        if (a.getX() == points[0]) return a;
        if (b.getX() == points[0]) return b;
        if (c.getX() == points[0]) return c;

        return d;

    }

    @Override
    public Point centroid() {
        Segment line1 = new Segment(abc.centroid(), adc.centroid());
        Segment line2 = new Segment(bcd.centroid(), bad.centroid());
        return line1.intersection(line2);
    }

    @Override
    public boolean isTheSame(Figure figure) {

        Quadrilateral quad = ((Quadrilateral) figure);

        Point[] points = new Point[4];

        points[0] = quad.a;
        points[1] = quad.b;
        points[2] = quad.c;
        points[3] = quad.d;

        for (Point point: points) {

            if (!a.isTheSame(point)
                && !b.isTheSame(point)
                && !c.isTheSame(point)
                && !d.isTheSame(point))

                return false;
        }
        return true;
    }
}
