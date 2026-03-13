package lab13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Poring extends JFrame{
    ImageIcon img;
    JLabel pic,count;
    
    public Poring(int countFrame){
        this.setLayout(new FlowLayout());
        img = new ImageIcon(getClass().getResource("/lab13/Character.png"));
        pic = new JLabel(img);
        pic.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Poring.this.dispose();
            }
        });
        count = new JLabel(String.valueOf(countFrame));
        this.add(pic);
        this.add(count);
        
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
}
