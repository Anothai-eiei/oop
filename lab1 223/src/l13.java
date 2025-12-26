import java.util.*;
public class l13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = sc.nextInt(),score,e=0,g=0,f=0,p=0;
        for (int i =1;i <= num;i++){
            System.out.print("Enter score for student "+i+": ");
            score = sc.nextInt();
            if (score >= 80){
                System.out.println("Excellent");
                e++;
            }else if (79 > score & score>60){
                System.out.println("Good");
                g++;
            }else if (59 > score & score>50){
                System.out.println("Fair");
                f++;
            }else{
                System.out.println("Poor");
                p++;
            }
        }System.out.println("Summary:");
        System.out.println("Excellent: "+e);
        System.out.println("Good: "+g);
        System.out.println("Fair: "+f);
        System.out.println("Poor: "+p);
    }
    
}
