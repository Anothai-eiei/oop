import java.util.*;
public class l14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String allChar = "",consonant="";
        while (true){
            System.out.print("Enter a character: ");
            char ch = sc.next().charAt(0);
            if (ch == 'z'){
                break;
            }if (ch < 'a' || ch > 'z'){
                System.out.println("Invaild input.Only lowercase a-z are allowed.");
                continue;
            }allChar += ch;
            if (ch != 'a' &&ch !='e'&&ch !='i'&&ch !='o'&&ch !='u'){
                consonant += ch;
            }
            
    }System.out.println("All characters entered: "+ allChar);
    System.out.println("Consonants only: "+ consonant);
        
    }
    
}
