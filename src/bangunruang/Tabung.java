package bangunruang;

import bangundatar.Lingkaran;

public class Tabung extends Lingkaran implements TigaDimensi {
    private double height;

    public Tabung(double radius, double height) {
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
        return super.getArea() * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * super.getCircumference() * height + 2 * super.getArea();
    }

}
