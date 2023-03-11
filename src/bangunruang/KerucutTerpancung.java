package bangunruang;

public class KerucutTerpancung extends Kerucut {
    private double topRadius;

    public KerucutTerpancung(double radius, double height,double topRadius) {
        super(radius, height);
        this.topRadius = topRadius;
    }

    public double getTopRadius() {
        return topRadius;
    }

    public void setTopRadius(double topRadius) {
        this.topRadius = topRadius;
    }

    @Override
    public double getVolume(){
        double r1 = radius;
        double r2 = topRadius;
        return 1.0/3.0 * Math.PI * height * (r1 * r1 + r1 * r2 + r2 * r2);
    }
    
    @Override
    public double getSurfaceArea(){
        double slant = Math.sqrt(Math.pow(topRadius - radius, 2) + Math.pow(height, 2));
        return Math.PI * (radius + topRadius) * slant + super.getArea() + super.getArea(topRadius);

    }

    

}
