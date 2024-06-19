import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame
{
    public JTextField firstNumber;
    public JTextField secondNumber;
    public JButton confirmButton;
    public String[] options = {"Add", "Subtract", "Multiply", "Division", "Remainder"};
    public JComboBox<String> dropDownBox;
    public JLabel result;

    public MyFrame()
    {
        super();
        init(); //calling the init on construction of the class.
    }
    public void init()
    {
        //initializing all the variables
        firstNumber = new JTextField();
        secondNumber = new JTextField();
        confirmButton = new JButton("Calculate");
        dropDownBox = new JComboBox<>(options);
        result = new JLabel(" ");

        //basic exit, title, and layout created
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Simple Calculator");
        this.setLayout(new GridLayout(5,2));

        //First Row this will grab the first number of the operation
        this.add(new JLabel("First Number:"));
        this.add(firstNumber);

        //Second Row this will grab the second number of the operation
        this.add(new JLabel("Second Number:"));
        this.add(secondNumber);

        //Third Row this will allow the user to choose desired operation
        this.add(new JLabel("Operation:"));
        this.add(dropDownBox);

        //Fourth Row this will "listen" for the action of the Calculate button being clicked to then perform the desired operation
        this.add(new JLabel("Confirm Operation:"));
        confirmButton.addActionListener(e -> CalculateResult());
        this.add(confirmButton);

        //Fifth Row this will display the users result of the operation
        this.add(new JLabel("Result: "));
        this.add(result);

        //Setting up where the window will appear as well as the button appearance
        int frameWidth = 300;
        int frameHeight = 200;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) (screenSize.getWidth() /2) - frameWidth, (int) (screenSize.getHeight()/2) - frameHeight , frameWidth, frameHeight);
    }
    public void CalculateResult()

    {
        //grabs the necessary values to initialize the variables
        Double firstNum = Double.parseDouble(firstNumber.getText());
        Double secondNum = Double.parseDouble(secondNumber.getText());
        double res = 0.00;
        String option = (String) dropDownBox.getSelectedItem();
        //performs the desired operation
        res = switch (option) {
            case "Add" -> firstNum + secondNum;
            case "Subtract" -> firstNum - secondNum;
            case "Multiply" -> firstNum * secondNum;
            case "Division" -> firstNum / secondNum;
            case "Remainder" -> firstNum % secondNum;
            default -> {
                yield res;
            }
        };
        //sets the result to the result of the operation.
        result.setText(Double.toString(res));
    }
}

