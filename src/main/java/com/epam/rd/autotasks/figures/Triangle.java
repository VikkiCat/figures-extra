package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    Point a,b,c;

    public Triangle(Point a, Point b, Point c) {

        if (a == null ||b==null||c==null||a.equals(b)||a.equals(c)||b.equals(c)) {
            throw new IllegalArgumentException();
        }
        // area==0
        if (((c.getY()-a.getY())*(b.getX()- a.getX())- (c.getX()- a.getX())*(b.getY()-a.getY()))/2 == 0){
            throw new IllegalArgumentException();
        }
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    @Override
    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX())/3;
        double y = (a.getY()+b.getY()+c.getY())/3;
        return new Point(x,y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Triangle) {
            Triangle other = (Triangle) figure;
            return ((a.equals(other.a) || a.equals(other.b) || a.equals(other.c))
                    && (b.equals(other.a) || b.equals(other.b) || b.equals(other.c))
                    && (c.equals(other.a) || c.equals(other.b) || c.equals(other.c)));
        }
        return false;
    }

}
