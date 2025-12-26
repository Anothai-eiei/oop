import java.util.*;
public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String password = "PASS2025";
        System.out.print("Enter password: ");
        String input = sc.nextLine();
        if (password.equals(input)) {
            System.out.println("Access granted.");
        }else{
            System.out.println("Try again.");
        }
    }
}