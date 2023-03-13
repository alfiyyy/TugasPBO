package bangundatar;

public class Lingkaran implements DuaDimensi {
    protected double radius;

    public Lingkaran(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getArea(double r){
        return Math.PI * r * r;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
