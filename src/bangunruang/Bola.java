package bangunruang;

import bangundatar.Lingkaran;

public class Bola extends Lingkaran implements TigaDimensi {

    public Bola(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return 4.0 / 3.0 * getArea() * radius;
    }

    @Override
    public double getSurfaceArea() {
        return 4 * getArea();
    }
    
}
