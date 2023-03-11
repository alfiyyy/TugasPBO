package bangunruang;


public class JuringBola extends Bola {

    //Spherical Sector / spherical cone
    private double height,baseOfCone;

    public JuringBola(double radius,double height) {
        super(radius);
        this.height = height;
        this.baseOfCone = setBaseOfCone();

    }
    
    private double setBaseOfCone(){
        return Math.sqrt(Math.pow(radius, 2)-(Math.pow(radius - height, 2)));
    }
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public double getSurfaceArea() {
        return Math.PI * radius * (2 * height + baseOfCone);
    }

    @Override
    public double getVolume() {
        return  2 * Math.PI * Math.pow(radius, 2) * height * 1.0/3.0;
    }



    
    
}
