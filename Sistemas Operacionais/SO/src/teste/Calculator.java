package teste;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField resultField;
    private JButton[] buttons;
    private String[] buttonLabels = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/" };
    private String input = "";
    private int result = 0;
    private char operator = ' ';

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 200));

        // Create the result field
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField, BorderLayout.NORTH);

        // Create the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();

        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText.charAt(0);
                result = Integer.parseInt(input);
                input = "";
                break;
            case "C":
                input = "";
                result = 0;
                operator = ' ';
                break;
            case "=":
                int secondOperand = Integer.parseInt(input);
                switch (operator) {
                    case '+':
                        result += secondOperand;
                        break;
                    case '-':
                        result -= secondOperand;
                        break;
                    case '*':
                        result *= secondOperand;
                        break;
                    case '/':
                        result /= secondOperand;
                        break;
                }
                input = Integer.toString(result);
                resultField.setText(input);
                break;
            default:
                input += buttonText;
                resultField.setText(input);
                break;
        }
    }
}