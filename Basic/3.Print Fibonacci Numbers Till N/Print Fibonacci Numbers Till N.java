import java.util.*;
  
  public class Main
  {
      public static void main(String[] args) 
      {
          int a =0;
          int b=1,c;
          Scanner sc = new Scanner(System.in);
          int n =sc.nextInt();
          for(int i=1;i<=n;i++)
          {
              System.out.println(a);
              c=a+b;
              a=b;
              b=c;
              
              
          }
      }
  }