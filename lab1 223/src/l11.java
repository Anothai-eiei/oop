import java.util.*;
public class l11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of items: ");
        int n = sc.nextInt(),total =0;
        double price;
        
        for (int i = 1;i <= n; i ++){
            System.out.print("Enter price for item "+ i +": ");
            price = sc.nextDouble();
            total += price;
        }
        System.out.println("Total = "+ total);
        System.out.print("Enter amount paid: ");
        int paid = sc.nextInt();
        double change = paid - total;
        System.out.println("Change = "+ change);
    }
    
}
