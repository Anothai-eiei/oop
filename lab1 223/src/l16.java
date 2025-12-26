import java.util.*;
public class l16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, max = 0,min = 0;
        boolean hasNumber = false;
        while (true){
            System.out.print("Enter a number (-1 to stop): ");
            num = sc.nextInt();
            if (num == -1){
                break;
            }
            if (!hasNumber){
                max = num;
                min = num;
                hasNumber = true;
            }else{
                if(num > max)max = num;
                if (num < min)min = num;
            }
        }if (!hasNumber){
            System.out.println("No number were entered.");
        }System.out.println("Maximum = "+ max);
        System.out.println("Minimum = "+ min);
    }
    
}
