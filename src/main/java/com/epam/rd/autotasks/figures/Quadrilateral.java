package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    Point a,b,c,d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if(a!=null && b!=null && c!=null && d!=null){
            int xd=0;
        }else {
            throw new IllegalArgumentException();
        }
        if(a.equals(b) || a.equals(c) || a.equals(d) || c.equals(b) || b.equals(d) || c.equals(d)){
            throw new IllegalArgumentException();
        }
        if (!isConvex(a, b, c, d)) {
            throw new IllegalArgumentException();
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    private boolean isConvex(Point a, Point b, Point c, Point d) {
        return (crossProduct(a, b, c) * crossProduct(b, c, d) > 0 &&
                crossProduct(b, c, d) * crossProduct(c, d, a) > 0 &&
                crossProduct(c, d, a) * crossProduct(d, a, b) > 0);
    }

    private double crossProduct(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
    }

    @Override
    public Point centroid() {
        Point center1  = centroidTriangle(a,b,c);
        Point center2  = centroidTriangle(a,c,d);
        Point center3  = centroidTriangle(a,d,b);
        Point center4  = centroidTriangle(b,d,c);

        return crossPoint(center1, center2, center3, center4);
    }

    private Point crossPoint(Point e, Point f, Point g, Point h){
        double x1=e.getX();
        double y1=e.getY();
        double x2=f.getX();
        double y2=f.getY();
        double x3=g.getX();
        double y3=g.getY();
        double x4=h.getX();
        double y4=h.getY();
        double a1=y2-y1;
        double b1=x1-x2;
        double c11=a1*x1+b1*y1;
        double a2=(y4-y3);
        double b2=x3-x4;
        double c22=a2*x3+b2*y3;
        double determinant=a1*b2-a2*b1;
        double x5=(b2*c11 - b1*c22)/determinant;
        double y5=(a1*c22-a2*c11)/determinant;
        return new Point(x5,y5);
    }

    private Point centroidTriangle(Point a, Point b, Point c){
        double xx = (a.getX()+b.getX()+c.getX())/3;
        double xy = (a.getY()+b.getY()+c.getY())/3;
        return new Point(xx,xy);
    }
    @Override
    public boolean isTheSame(Figure figure) {
        double ax = ((Quadrilateral)figure).a.getX();
        double ay = ((Quadrilateral)figure).a.getY();
        double bx = ((Quadrilateral)figure).b.getX();
        double by = ((Quadrilateral)figure).b.getY();
        double cx = ((Quadrilateral)figure).c.getX();
        double cy = ((Quadrilateral)figure).c.getY();
        double dx = ((Quadrilateral)figure).d.getX();
        double dy = ((Quadrilateral)figure).d.getY();
        double delta = 4.440892098500626E-16;
        if (((Quadrilateral)figure).a != a){ if ((a.getX()==bx)||(b.getX()==cx)||(c.getX()==dx)||(d.getX()==ax)){
            return true;
        }
        if ((a.getX()==bx)||(b.getX()==ax)||(c.getX()==dx)||(d.getX()==cx)){
            return true;
        }
        if ((a.getX()==cx)||(b.getX()==bx)||(c.getX()==ax)||(d.getX()==dx)){return true;} }
        if ((a.getX()!=ax)||(b.getX()!=bx)||(c.getX()!=cx)||(d.getX()!=dx)){return false;}
        if ((Math.abs(a.getX()-ax)<=delta)||(Math.abs(b.getX()-bx)<=delta)||(Math.abs(c.getX()-cx)<=delta)
            ||(Math.abs(d.getX()-dx)<=delta)){
            return true;
        }
        return false;
    }
}
