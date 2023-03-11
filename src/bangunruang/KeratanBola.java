package bangunruang;


public class KeratanBola extends Bola {

//Spherical segment of two bases
     private double height,topRadius;
     private double sphereRadius;

    public KeratanBola(double baseRadius, double topRadius, double height) {
        super(baseRadius);
        this.topRadius = topRadius;
        this.height = height;
        this.sphereRadius = calculateSphereRadius();
    }

    private double calculateSphereRadius(){
        return Math.sqrt(Math.pow(super.getRadius(), 2) + Math.pow((super.getRadius() * super.getRadius() - topRadius * topRadius - height * height)/(2*height), 2));
    }

    public double getSpehreRadius(){
        return sphereRadius;
    }    


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * sphereRadius * height;
    }

    @Override
    public double getVolume() {
        
        return 1.0/6.0 * Math.PI * height * (3*Math.pow(super.getRadius(), 2) + 3*Math.pow(topRadius, 2) + Math.pow(height, 2));
    }












    

}
