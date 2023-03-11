package bangunruang;

import bangundatar.Lingkaran;

public class Bola extends Lingkaran {

    public Bola(double radius) {
        super(radius);
    }

    public double getVolume() {
        return 4.0 / 3.0 * getArea() * radius;
    }

    public double getSurfaceArea() {
        return 4 * getArea();
    }
    
}
