import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class StudentView extends JFrame {

    private JLabel idLabel, nameLabel, moneyLabel;
    private JTextField idField, nameField, moneyField;
    private JButton depositBtn, withdrawBtn;
    private JPanel idPanel, namePanel, moneyPanel, btnPanel;
    private int money;

    public StudentView(){

        ActionHandler handler = new ActionHandler(this);

        setTitle("Student View");
        setLayout(new GridLayout(4,1));

        idLabel = new JLabel("ID: ");
        nameLabel = new JLabel("Name: ");
        moneyLabel = new JLabel("Money: ");

        idField = new JTextField();
        nameField = new JTextField();
        moneyField = new JTextField();
        moneyField.setEditable(false);
        moneyField.setText(String.valueOf(money));

        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(handler);
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(handler);

        idPanel = new JPanel();
        idPanel.setLayout(new GridLayout());
        namePanel = new JPanel();
        namePanel.setLayout(new GridLayout());
        moneyPanel = new JPanel();
        moneyPanel.setLayout(new GridLayout());
        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout());

        idPanel.add(idLabel);
        idPanel.add(idField);

        namePanel.add(nameLabel);
        namePanel.add(nameField);

        moneyPanel.add(moneyLabel);
        moneyPanel.add(moneyField);

        btnPanel.add(depositBtn);
        btnPanel.add(withdrawBtn);

        add(idPanel);
        add(namePanel);
        add(moneyPanel);
        add(btnPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e){
                saveData();
                System.exit(0);
            }

        });

        setVisible(true);

        this.checkFile();

    }

    public void saveData(){

        Student std = new Student(this.nameField.getText(), Integer.parseInt(this.idField.getText()), this.money);

        try (
                FileOutputStream fout = new FileOutputStream("StudentM.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fout);
        ){

            oout.writeObject(std);
            System.out.println("Saved Object");

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void checkFile(){

        File file = new File("StudentM.dat");

        if ( file.exists() ){
            this.loadStd();
        }else{
            System.out.println("File not found");
        }

    }

    public void loadStd(){

        try ( FileInputStream fin = new FileInputStream("StudentM.dat");
              ObjectInputStream oin = new ObjectInputStream(fin);
        ){

            Student std = (Student) oin.readObject();
            this.nameField.setText(std.getName());
            this.idField.setText(String.valueOf(std.getID()));
            this.moneyField.setText(String.valueOf(std.getMoney()));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new StudentView();
    }

    public JButton getDepositBtn() {
        return depositBtn;
    }

    public JButton getWithdrawBtn() {
        return withdrawBtn;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public JTextField getMoneyField() {
        return moneyField;
    }

}


class ActionHandler implements ActionListener{

    private StudentView gui;

    public ActionHandler(StudentView gui){

        this.gui = gui;

    }

    @Override
    public void actionPerformed(ActionEvent ev){

        if ( ev.getSource().equals( this.gui.getDepositBtn()) ){

            this.gui.setMoney(this.gui.getMoney() + 100);
            this.gui.getMoneyField().setText(String.valueOf(this.gui.getMoney()));

        } else if ( ev.getSource().equals( this.gui.getWithdrawBtn()) ){

            this.gui.setMoney(this.gui.getMoney() - 100);
            this.gui.getMoneyField().setText(String.valueOf(this.gui.getMoney()));

        }

    }
}
