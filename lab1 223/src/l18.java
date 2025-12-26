import java.util.*;
public class l18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int n = sc.nextInt();
        for (int i = 1;i <= n ;i ++){
            System.out.print("|");
            if (i % 5 == 0){
                System.out.println();
            }
        }
    }
    
}