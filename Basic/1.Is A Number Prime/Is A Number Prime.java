import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) 
  {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-- != 0)
      {
          int n = sc.nextInt();
          int flag = 1;
          for(int i=2; i*i <= n; i++)
          {
              if(n%i==0)
              {
                  
                  flag = 0;
                  break;
              }
          }
          if(flag==1)
            System.out.println("prime");
          else
            System.out.println("not prime");
      }
      
      
      
  
   }
  }