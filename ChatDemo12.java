import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import javax.swing.*;
public class ChatDemo extends JFrame{
    JPanel btnPanel, totalPanel;
    JTextArea console;
    JTextField chat;
    JButton submit,reset;
    ArrayList<ArrayList> logs = new ArrayList<>();
    public ChatDemo(){
        ActionHandler handler = new ActionHandler(this);
        setTitle("ChatDemo");
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        console = new JTextArea();
        console.setSize(45, 20);
        
        chat = new JTextField();
        
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        submit.addActionListener(handler);
        reset.addActionListener(handler);
        
        btnPanel.add(submit);
        btnPanel.add(reset);
        totalPanel = new JPanel();
        totalPanel.setLayout(new BorderLayout());
        totalPanel.add(chat,BorderLayout.NORTH);
        totalPanel.add(btnPanel,BorderLayout.SOUTH);
        add(console,BorderLayout.CENTER);
        add(totalPanel,BorderLayout.SOUTH);
        
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                saveData();
                System.exit(0);
            }
        });
        setVisible(true);
        this.CheckFile();
    }
    public void saveData(){

        try (FileOutputStream fout = new FileOutputStream("ChatDemo.dat")) {

            for ( int i = 0; i < this.logs.size(); i++){

                String data = this.logs.get(i).get(0) + " : " + this.logs.get(i).get(1);

                for ( int j = 0; j < data.length(); j++ ){

                    fout.write(data.charAt(j));

                }

                fout.write('\n');

            }

            System.out.println("File Saved");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public void CheckFile(){

        File file = new File("ChatDemo.dat");
        if ( file.exists() ){
            LogsLoading();
            test();
        } else {
            System.out.println("File not found");
        }

    }
    public void LogsLoading(){

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("ChatDemo.dat")))) {

            String line;

            while ( ( line = reader.readLine() ) != null ){

                ArrayList<String> inLogs = new ArrayList<>();
                String[] parts = line.split(" : ");

                String date = parts[0];
                String message = parts[1];

                inLogs.add(date);
                inLogs.add(message);

                this.logs.add(inLogs);

            }

            this.setConsole();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void test(){

        try (FileInputStream fis = new FileInputStream("ChatDemo.dat")) {
            int data;

            String tempData = "";
            ArrayList<String> inLogs = new ArrayList<>();
            ArrayList<ArrayList> testLogs = new ArrayList<>();

            while ((data = fis.read()) != -1) {
                if ( data == '\n' ) {
                    System.out.println(tempData);
                    String[] parts = tempData.split(" : ");
                    inLogs.add(parts[0]);
                    inLogs.add(parts[1]);
                    testLogs.add(inLogs);
                    tempData = "";
                    inLogs.clear();
                } else {
                    tempData += (char) data;
                }
            }
            System.out.println(testLogs);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public JTextArea getConsole(){
        return console;
    }
    public JTextField getChat(){
        return chat;
    }
    public ArrayList<ArrayList> getLogs(){
        return logs;
    }
    public void setConsole(){
        
        console.setText("");
        
        for(int i = 0; i < this.logs.size(); i++){
            
            String data = logs.get(i).get(0) + ": " + logs.get(i).get(1) + "\n";
            console.setText(console.getText() + data);
            
        }
        
    }
    public static void main(String[] args) {
        new ChatDemo();
    }
}

class ActionHandler implements ActionListener{
    ChatDemo gui;
    public ActionHandler(ChatDemo gui){
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(gui.submit)){
            
            ArrayList<String> inLogs = new ArrayList<>(); 
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            
            String data = gui.getChat().getText();
            
            inLogs.add(String.valueOf(dtf.format(LocalDateTime.now())));
            inLogs.add(data);
            
            gui.getLogs().add(inLogs);
            
            gui.chat.setText("");
            gui.setConsole();
            
        }else if(ev.getSource().equals(gui.reset)){
            
            gui.console.setText("");
            gui.getLogs().clear();
        }
    }
}