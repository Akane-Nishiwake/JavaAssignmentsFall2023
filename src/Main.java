import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menuChoice = 0;
        while(menuChoice != 9)
        {
            System.out.println("____MENU____\n" +
                    "1. Assignment 1\n" +
                    "2. Assignment 2\n" +
                    "3. Assignment 3\n" +
                    "4. Assignment 4\n" +
                    "5. Assignment 5 : WARNING : THIS PROGRAM WILL CLOSE THE PROGRAM DOWN ONCE FINISHED!\n" +
                    "6. Assignment 6\n" +
                    "7. Assignment 7\n" +
                    "8. Assignment 8\n" +
                    "9. Exit Program\n" +
                    "Please choose a program to run: ");
            menuChoice = input.nextInt();
            switch (menuChoice) {
                case 1:
                    AssignmentMethods.Assignment01();
                    break;
                case 2:
                    AssignmentMethods.Assignment02();
                    break;
                case 3:
                    AssignmentMethods.Assignment03();
                    break;
                case 4:
                    List<Double> myList = new ArrayList<>();
                    myList = AssignmentMethods.ReadFile("data.txt", myList);
                    System.out.println("Original List: " + myList);
                    AssignmentMethods.Assignment04();
                    List<Double> mySortedList = new ArrayList<>();
                    mySortedList = AssignmentMethods.ReadFile("data-sorted.txt", mySortedList);
                    System.out.println("Sorted List: " + mySortedList);
                    break;
                case 5:
                    AssignmentMethods.Assignment05();
                    break;
                case 6:
                    AssignmentMethods.Assignment06();
                    break;
                case 7:
                    //AssignmentMethods.Assignment07();
                    System.out.println("This Assignment is commented out in the class. " +
                            "This is due to the fact that is used an SQL table that does not exist in the current context." +
                            "The table does not exist due to the fact that I currently do not have SQL installed on this system."
                            );
                    break;
                case 8:
                    AssignmentMethods.Assignment08();
                    break;
                case 9:
                    System.out.println("Closing Program.");
                    break;
                default:
                    System.out.println("Please try again.");
                    break;
            }
        }
        input.close();
    }

}