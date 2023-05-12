package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends Figure {

    Point center;
    double radius;

    public Circle(Point center, double radius) {

        if (center == null || radius <= 0){
            throw new IllegalArgumentException();
        }
        else {
            this.center = center;
            this.radius = radius;
        }
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public Point centroid() {
        return center;
    }


    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle){
            double cx = ((Circle) figure).center.getX();
            double cy = ((Circle) figure).center.getY();
            double r = ((Circle) figure).getRadius();
            double delta = 4.440892098500626E-16;
            if ((Math.abs(getRadius()-r)<=delta)&&(Math.abs(center.getX()-cx)<= delta)&&(Math.abs(center.getY()-cy)<=delta)){
                return true;
            }
            else return false;
        }
        return false;
    }
}
