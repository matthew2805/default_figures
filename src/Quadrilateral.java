class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return calcTriangleArea(a, b, c, sideLength(a, c)) +
                calcTriangleArea(c, d, a, sideLength(a, c));
    }

    @Override
    public String pointsToString() {
        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)",
                a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(), d.getY());
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX()
                && a.getX() <= d.getX()) return a;
        else if (b.getX() <= a.getX() && b.getX() <= c.getX()
                && b.getX() <= d.getX()) return b;
        else if (c.getX() <= a.getX() && c.getX() <= b.getX()
                && c.getX() <= d.getX()) return c;
        else return d;
    }

    private double calcTriangleArea(Point alpha, Point beta, Point gamma, double sideC) {
        var sideA = sideLength(alpha, beta);
        var sideB = sideLength(beta, gamma);
        var p1 = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(p1 * (p1 - sideA) * (p1 - sideB) * (p1 - sideC));
    }

    private double sideLength(Point alpha, Point beta) {
        return Math.sqrt(Math.pow(beta.getX() - alpha.getX(), 2.0) + Math.pow(beta.getY() - alpha.getY(), 2.0));
    }
}
