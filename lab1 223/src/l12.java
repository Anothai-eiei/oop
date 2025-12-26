import java.util.*;
public class l12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entyer nember of digits: ");
        int n = sc.nextInt(),num,result = 0;
        for (int i = 1;i<=n;i++){
            System.out.print("Enter digit "+i+": ");
            num = sc.nextInt();
            result = result * 10 + num;
        }System.out.println("Final Code = "+ result);
    }
    
}
