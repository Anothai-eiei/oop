import java.util.*;
public class l10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num , odd = 0, even = 0 ;
        while (true){
            num = sc.nextInt();
            if (num == -1){
                break;
            }if (num % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }System.out.println("Odd number = "+odd+" and Even number = "+even);

    }
    
}
