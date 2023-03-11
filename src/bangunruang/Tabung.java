package bangunruang;

import bangundatar.Lingkaran;

public class Tabung extends Lingkaran {
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

    public double getVolume() {
        return super.getArea() * height;
    }

    public double getSurfaceArea() {
        return 2 * super.getCircumference() * height + 2 * super.getArea();
    }
    
}
