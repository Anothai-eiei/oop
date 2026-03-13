import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
public class MyClock extends JLabel implements Runnable{
    public MyClock(){
        this.setFont(new Font("Arial", Font.BOLD, 50));
    }
    @Override
    public void run(){
        while(true){
            Calendar d = Calendar.getInstance();
            String sec = String.format("%02d",d.get(Calendar.SECOND));
            String min = String.format("%02d", d.get(Calendar.MINUTE));
            String hour = String.format("%02d",d.get(Calendar.HOUR_OF_DAY));
            this.setText(hour + ":" + min + ":" + sec);
            
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
