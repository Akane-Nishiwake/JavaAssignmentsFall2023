public class Cylinder extends Shape3D
{	//private members of the class
    private final int radius;
    private final int height;

    public Cylinder(int r, int h)
    {
        //setting the private members in the constructor
        radius = r;
        height = h;
    }

    @Override
    public double Volume()
    {	//returning the volume of the cylinder using the abstract method from Shape3D
        return Math.PI * radius * radius * height;
    }
}
