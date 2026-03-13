import java.awt.Font;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class MyClockTimer extends JLabel implements Runnable{
    int sec, min, hour;
    
    public MyClockTimer(){
        this.setFont(new Font("Arial", Font.BOLD, 50));
    }
    @Override
    public void run(){
        while(true){
            min = (sec/60) % 60;
            hour = sec/3600;
            this.setText(String.format("%02d", hour)+":"+ String.format("%02d", min) + ":" + String.format("%02d", sec % 60));
            sec++;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                Logger.getLogger(MyClockTimer.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}
