package bangunruang;

public class TemberengBola extends Bola {
    
   //Spherical Cap
    private double height;
    private double baseRadius;

    public TemberengBola(double radius, double height) {
        super(radius);
        this.height = height;
        this.baseRadius = getBaseRadius();
    }


    private double getBaseRadius(){
        return Math.sqrt(Math.pow(radius, 2)-(Math.pow(radius-height, 2)));
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getCapArea(){
        return 2 * Math.PI * radius * height;
    }

    @Override
    public double getVolume() {
        // double h = radius - height;
        return (1.0 / 3.0) * Math.PI * height * height *(3*radius-height);
    }

    @Override
    public double getSurfaceArea(){
        return 2 * Math.PI * radius * height + Math.PI * baseRadius*baseRadius;
    }


    
}
