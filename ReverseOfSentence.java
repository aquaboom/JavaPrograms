package JavaPrograms;
import java.lang.*;
import java.util.Scanner;

public class ReverseOfSentence{
   public static void main(String[] args)
   {
    System.out.println("Enter a sentence");
	Scanner sc = new Scanner(System.in);
	String str=sc.nextLine();
	System.out.println("Entered sentence is: "+ str);
	
	
	String a[]=str.split("");
	
	/*for(int i=0;i<a.length;i++)
	{
	 System.out.print(a[i]+"");
	} */
	
	//String str1="";
	for(int i=a.length-1;i>=0;i--)
	{
	 System.out.print(a[i]+"");
	}
	
   // System.out.print("The reversed sentence is="+ str1);
    
   }
}