import javax.swing.JFrame;
public class MyClockTimerFrame {
    public MyClockTimerFrame(){
        JFrame frame = new JFrame("Clock");
        MyClockTimer watch = new MyClockTimer();
        
        frame.add(watch);
        
        Thread t = new Thread(watch);
        t.start();
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new MyClockTimerFrame();
    }
}
