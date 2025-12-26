import java.util.*;
public class l17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int n = sc.nextInt();
        for (int i = 1;i <= n ;i ++){
            if (i % 5 == 0){
                System.out.print("/");
            }else{
                System.out.print("|");
            }
        }
    }
    
}
