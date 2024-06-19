public class Cuboid extends Shape3D
{	//private members of the class
    private final int width;
    private final int depth;
    private final int height;

    public Cuboid(int w, int d, int h)
    {	//setting the private members in the constructor
        width = w;
        depth = d;
        height = h;
    }
    @Override
    public double Volume()
    {	//returning the volume of the cylinder using the abstract method from Shape3D
        return width * depth * height;
    }
}
