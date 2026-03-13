import javax.swing.JFrame;
public class MyFrame {
    public MyFrame(){
        JFrame frame = new JFrame("Clock");
        MyClock clock = new MyClock();
        
        frame.add(clock);
        
        Thread t = new Thread(clock);
        t.start();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
