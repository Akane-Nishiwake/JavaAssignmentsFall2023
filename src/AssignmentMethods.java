
import java.io.*;
import java.util.*;
import javax.swing.*;
//import java.sql.*;

public class AssignmentMethods
{
    static void Assignment01()
    {
        String leftFormat = " | %-8s | %5s  |%n ----------------------%n"; //formatting for header
        String newFormat = " | %-8.2f | %5.2f |%n ----------------------%n"; //formatting for body
        System.out.printf(leftFormat, "SALES", "INCOME"); //header
        for(double i = 1000; i <= 20000; )
        {
            double base = 5000;
            base += computeIncome(i); //adding commission earned to base Salary
            System.out.printf(newFormat, i, base); //body
            i += 1000; //adding 1k to each sale
        }
    }
    static double computeIncome(double sales)
    {
        double result = 0.00f;
        //commission rate
        // 0 <= 5000 = 0.08
        if(sales <= 5000)
        {
            result += ((sales - 0) * 0.08);
        }
        //5000.01 <= 10000 = 0.10
        else if(sales > 5000.00 && sales <= 10000)
        {
            result += ((5000) * 0.08); //take out the first 5k at 8%
            result += ((sales - 5000) * 0.10); //commission the remaining amount at 10%
        }
        // x > 10000.01 = 0.12
        else if(sales > 10000)
        {
            result += ((5000) * 0.08); //take out the first 5k at 8%
            result += ((10000 - 5000) * 0.10); //take out the second 5k at 10%
            result += ((sales - 10000) * 0.12); //commission the remaining amount at 12%
        }
        return result;
    }

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
        List<Double> myList = new ArrayList<>(); //create list to hold data
        String myFile = "data.txt"; //give the file name to look for
        myList = ReadFile(myFile, myList); //call the read file method and fill the List
        Collections.sort(myList); //sorts the file in ascending order
        String outputFile = "data-sorted.txt"; //file name of the file to be created/written to
        WriteFile(outputFile, myList); //Writes the sorted data to the intended file
    }
    static List<Double> ReadFile(String myFile, List<Double> myList)
    {
        try (BufferedReader read = new BufferedReader(new FileReader(myFile))) //try to read the file
        {
            String currentLine; //need this to store the current line
            while((currentLine = read.readLine()) != null) //store the current line if it is not null
            {
                try
                {
                    double num = Double.parseDouble(currentLine); //convert string to double
                    myList.add(num); //add to list
                }catch(NumberFormatException e) //if we cannot convert throw and exception
                {
                    e.printStackTrace();
                }
            }
            //read.close(); //close the file
        } catch (IOException e) //if the file cannot be read throw an exception
        {
            e.printStackTrace();
        }
        return myList; //return the list
    }
    static void WriteFile(String myFile, List<Double> myList)
    {
        try(PrintWriter write = new PrintWriter(new FileWriter(myFile))) //creating a new file if needed/creating a object to use to write to the file
        {
            for( Double num : myList) //goes through the entire List to print each number to a line in the file
            {
                write.println(num.toString());
            }
            //write.close(); //close the file
        }catch (IOException e) //exception thrown if file creation or finding fails
        {
            e.printStackTrace();
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

    static void Assignment06()
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

