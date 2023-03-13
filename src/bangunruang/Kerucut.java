package bangunruang;

import bangundatar.Lingkaran;

public class Kerucut extends Lingkaran implements TigaDimensi {
    protected double height;

    public Kerucut(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return 1.0 / 3.0 * getArea() * height;
    }

    @Override
    public double getSurfaceArea() {
        double slantHeight = Math.sqrt(height * height + super.getRadius() * super.getRadius());
        return Math.PI * super.getRadius() * slantHeight + getArea();
    }
}
