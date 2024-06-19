import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;
//import java.sql.*;

public class AssignmentMethods
{
    static void Assignment02() {
        ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.5, 2.35, -4.7, 0.01)); //creating the ArrayList
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
        String format = """
                The volume of the cube is %.2f
                The volume of the cylinder is %.2f
                This means the volume of the cube is %s the cylinder.
                ---------------------------------------------------------------
                """;
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
    static void constructGUI() //this method creates a MyFrame object that calls the initialization of my JFrame
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MyFrame frame = new MyFrame();
        frame.setVisible(true);

    }

//Assignment07 is commented out due to the fact that there is no SQL table made to run with it in this project
//The assignment turned in did have a table that it connected to however I decided not to recreate it.

//    static void Assignment07() {
//        //create formating for the table
//        String format = "+----------------------------------------+\n| %25s	         |\n+--------------+------------+------------+\n| %-12s | %-10s | %-10s |\n+--------------+------------+------------+\n";
//        String formatEmployee = "| %-12s | %-10s | %-10s |\n+--------------+------------+------------+\n";
//        //create variables to be used to capture the table data
//        Connection connection;
//        ResultSet results = null;
//        Statement stmnt;
//        try //try to find the server
//        {
//            try //try to find the driver
//            {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            //create a connection from the driver if the driver has been found
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "cop2805");
//            //create the statement to be able to form queries to the database
//            stmnt = connection.createStatement();
//            //add the lines of code to send the statement "SELECT * from Employees;" and catch the result.
//            results = stmnt.executeQuery("SELECT * FROM Employees;");
//            System.out.printf(format, "Employees", "Employee Id", "Last Name", "First Name");
//            while (results.next())//while there is data in the table
//            {
//                //Print the results to the screen.
//                String id = results.getString("employeeId");
//                String lname = results.getString("lastName");
//                String fname = results.getString("firstName");
//                System.out.printf(formatEmployee, id, lname, fname);
//            }
//        } //results should print if no connection found then catch error here
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    static void Assignment08()
    {
        Random rand = new Random();
        int n = rand.nextInt(50); //get a random value to do a Fibonacci sequence on
        //create the objects and set n through the constructor
        RecursiveThread recursive = new RecursiveThread(n);
        DynamicThread dynamic = new DynamicThread(n);
        //start the threads with the overridden run function
        recursive.start();
        dynamic.start();
    }
}

