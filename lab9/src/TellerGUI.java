import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TellerGUI implements ActionListener{
    private JFrame mainFrame;
    private JTextField balanceField, amountField;
    private JButton depositBt, withdrawBt, exitBt;
    private double balance = 6000;
    public static void main(String[] args) {
        new TellerGUI();
    }
    public TellerGUI(){
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel northFrame = new JPanel(new GridLayout(1,2));
        balanceField = new JTextField(String.valueOf(balance));
        balanceField.setEditable(false);
        northFrame.add(new JLabel(" Balance"));
        northFrame.add(balanceField);
        
        JPanel centerFrame = new JPanel(new GridLayout(1,2));
        amountField = new JTextField();
        centerFrame.add(new JLabel(" Amount: "));
        centerFrame.add(amountField);
        
        JPanel southFrame = new JPanel(new GridLayout(1,3));
        depositBt = new JButton("Deposit");
        withdrawBt = new JButton("Withdraw");
        exitBt = new JButton("Exit");
        
        depositBt.addActionListener(this);
        withdrawBt.addActionListener(this);
        exitBt.addActionListener(this);
        
        southFrame.add(depositBt);
        southFrame.add(withdrawBt);
        southFrame.add(exitBt);
        
        mainFrame.add(northFrame);
        mainFrame.add(centerFrame);
        mainFrame.add(southFrame);
        
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            double amount = Double.parseDouble(amountField.getText());
            if (e.getSource() == depositBt){
                balance += amount;
            }else if(e.getSource() == withdrawBt){
                if(amount <= balance){
                    balance -= amount;
                }else{
                    JOptionPane.showMessageDialog(mainFrame,"Not Enougn Money");
                }
            }
            balanceField.setText(String.valueOf(balance));
            amountField.setText("");
        }catch (NumberFormatException ex){
            System.exit(0);
        }
    }
}

