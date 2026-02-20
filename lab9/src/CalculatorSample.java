import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorSample implements ActionListener { //
    private JFrame mainFrame;
    private JTextField display;
    private String firstValue = "";
    private String secondValue = "";
    private String operator = "";
    private boolean isOperatorClicked = false;

    public static void main(String[] args) {
        new CalculatorSample();
    }

    public CalculatorSample() {
        mainFrame = new JFrame("My Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        mainFrame.add(display, BorderLayout.NORTH);

        // Buttons
        JPanel centerFrame = new JPanel(new GridLayout(4, 4));
        String[] labels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "0", "C", "=", "/"
        };

        for (String text : labels) {
            JButton btn = new JButton(text);
            btn.addActionListener(this);
            centerFrame.add(btn);
        }

        mainFrame.add(centerFrame, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);

        if (command.equals("C")) {
            display.setText("");
            firstValue = "";
            operator = "";
        } else if (command.equals("=")) {
            if (!firstValue.equals("") && !display.getText().equals("")) {
                secondValue = display.getText();
                calculate(Double.parseDouble(secondValue));
            }
            operator = "";
        } else if ("+-x/".contains(command)) {
            firstValue = display.getText();
            operator = command;
            display.setText("");
        } else {
            display.setText(display.getText() + command);
        }
    }

    private void calculate(double secondValue) {
        double v1 = Double.parseDouble(firstValue);
        String result = "";

        switch (operator) {
            case "+": result = String.valueOf(v1 + secondValue); break;
            case "-": result = String.valueOf(v1 - secondValue); break;
            case "x": result = String.valueOf(v1 * secondValue); break;
            case "/": result = String.valueOf(secondValue != 0 ? v1 / secondValue : "ERROR"); break;
        }
        
        display.setText(String.valueOf(result));
    }
}