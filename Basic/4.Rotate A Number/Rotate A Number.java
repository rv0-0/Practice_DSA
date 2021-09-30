import java.util.*;
   
   public class Main
   {
       public static void main(String[] args) 
       {
           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           int k = sc.nextInt();
           int m = n;
           int c=0;
           while(m!=0)
           {
               m=m/10;
               c++;
           }
           k=k%c;
           
           if(k<0)
            k = c+k;

           int d = n%((int)Math.pow(10,k));
           int remaining = n/((int)Math.pow(10,k));
           System.out.println(d*(int)Math.pow(10,c-k)+remaining);
       }
   }