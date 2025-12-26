import java.util.*;
public class l15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total= 0,n=0;
        while (true){
            System.out.print("Enter deposit amount: ");
            int money = sc.nextInt();
            total = total + money;
            n += 1;
            if (total >= 1000)
                break;
        }System.out.println("Target reached!");
        System.out.println("Total amount saved = "+ total);
        System.out.println("Number of deposits = "+ n);
    }
    
}
