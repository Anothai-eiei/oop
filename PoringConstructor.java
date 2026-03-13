package lab13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoringConstructor extends JFrame{
    int countFrame;
    JButton addBtn;
    
    public PoringConstructor(){
        this.setLayout(new FlowLayout());
        
        addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                countFrame++;
                new Poring(countFrame);
            }
        });
        
        this.setLocationRelativeTo(null);
        this.add(addBtn);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new PoringConstructor();
    }
}
