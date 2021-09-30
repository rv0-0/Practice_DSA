import java.util.*;

public class Main{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        int c = 1;
        while(n!=0)
        {
            int d = n%10;
            i = i + (int)(Math.pow(10,d-1)*c);
            n=n/10;
            c++;
        }
        System.out.println(i);
     }
}