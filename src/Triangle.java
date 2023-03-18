class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        var sideA = sideLength(a, b);
        var sideB = sideLength(b, c);
        var sideC = sideLength(c, a);
        var p = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String pointsToString() {
        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)",
                a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX()) return a;
        else if (b.getX() <= a.getX() && b.getX() <= c.getX()) return b;
        else return c;
    }

    private double sideLength(Point alpha, Point beta) {
        return Math.sqrt(Math.pow(beta.getX() - alpha.getX(), 2) + Math.pow(beta.getY() - alpha.getY(), 2));
    }

}
