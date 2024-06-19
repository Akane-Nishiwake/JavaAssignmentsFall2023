public abstract class Shape3D implements Comparable<Shape3D>
{
    //Contains an abstract method called Volume() that returns a double
    //There are no input parameters to this method
    public abstract double Volume();

    //Defines a compareTo method that compares itself to another Shape3D classes
    public int compareTo(Shape3D shape)
    {
        int result = 0;
        // returns 1 if shape 1 is greater than shape 2
        if(this.Volume() > shape.Volume())
            result = 1;
            //returns -1 if shape 1 is less than shape 2
        else if (this.Volume() < shape.Volume())
            result = -1;
            //returns 0 if shape1 is equal to shape 2

        return result;
    }
}
