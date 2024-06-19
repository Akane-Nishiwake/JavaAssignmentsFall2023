import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;

public class AssignmentMethods
{
    static void Assignment02() {
        ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(1.5, 2.35, -4.7, 0.01)); //creating the ArrayList
        String newHeaderFormat = "-------------------\n| %-16s| \n-------------------\n"; //header formatting
        System.out.printf(newHeaderFormat, "Original List");
        PrintList(list); //calling function to print the ArrayList
        Collections.sort(list); //sorting the list in ascending order
        System.out.printf(newHeaderFormat, "Sorted List");
        PrintList(list);
        int index = Collections.binarySearch(list, 1.5); //searching for the index of 1.5
        System.out.printf("Found value 1.5 at index: %d \n\n", index);
        Collections.fill(list, 0.0); //replace all data in the ArrayList with 0.0
        System.out.printf(newHeaderFormat, "Zero List");
        PrintList(list);
    }

    static void PrintList(ArrayList<Double> arrayList) {
        String newListFormat = "| Index %d | %-5.2f |\n-------------------\n"; //Body format
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf(newListFormat, i, arrayList.get(i)); //printing out the index and value at that index in the ArrayList
        }
        System.out.println();
    }

    static void Assignment03() {
        //Creating the 3 array types
        String[] stringArray = {"Red", "Green", "Blue"};
        Integer[] integerArray = {1, 2, 3};
        Double[] doubleArray = {3.0, 5.9, 2.9};
        //printing the results as well as calling the method in the same line
        System.out.print("Minimum's found\n----------------------\n");
        System.out.printf("Colors\t\t|%5s\n----------------------\n", min(stringArray));
        System.out.printf("Numbers\t\t|%5d\n----------------------\n", min(integerArray));
        System.out.printf("Circle Radius\t|%5.1f\n----------------------\n", min(doubleArray));

    }

    static <E extends Comparable<E>> E min(E[] list) {
        E result = list[0]; //sets a default minimum to the first element in the array
        for (E e : list) {
            if (e.compareTo(result) < 0) //compares the 2 values looking for the smaller value
            {
                result = e; //replaces the default value with the smaller value if found
            }
        }
        return result; //returns the smallest value found
    }

    static void Assignment04()
    {
//readable format for the user to verify the volumes and result
        String format = "The volume of the cube is %.2f\nThe volume of the cylinder is %.2f\n"
                + "This means the volume of the cube is %s the cylinder.\n"
                + "---------------------------------------------------------------\n";
        String less = "less than";
        String great = "greater than";
        String equal = "equal to";
        //create random number generator
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            //creating random numbers to test multiple values in one test
            int num1 = rand.nextInt(1, 50);
            int num2 = rand.nextInt(1, 50);
            int num3 = rand.nextInt(1, 50);
            int num4 = rand.nextInt(1, 50);
            int num5 = rand.nextInt(1, 50);
            //create cuboid and cylinder with random values
            Cuboid cube = new Cuboid(num1, num2, num3);
            Cylinder cyl = new Cylinder(num4, num5);
            //return result of volume comparison
            int result = cube.compareTo(cyl);
            //take result and output the appropriate response
            switch (result) {
                case 1:
                    System.out.printf(format, cube.Volume(), cyl.Volume(), great);
                    break;
                case 0:
                    System.out.printf(format, cube.Volume(), cyl.Volume(), equal);
                    break;
                case -1:
                    System.out.printf(format, cube.Volume(), cyl.Volume(), less);
                    break;
            }
        }


    }

    static void Assignment05()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();} //calls the constructGUI method
        });
    }
    static void constructGUI() //this method creates a MyFram object that calls the initialization of my JFrame
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MyFrame frame = new MyFrame();
        frame.setVisible(true);

    }
}

