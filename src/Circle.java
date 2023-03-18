class Circle extends Figure {
    private final Point a;
    private final double b;

    public Circle(Point a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(b, 2.0);
    }

    @Override
    public String pointsToString() {
        return String.format("(%.1f,%.1f)", a.getX(), a.getY());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + b + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(a.getX() - b, a.getY());
    }
}
