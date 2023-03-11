package bangundatar;

public class Lingkaran {
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

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getArea(double r){
        return Math.PI * r * r;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
