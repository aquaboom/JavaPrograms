package JavaPrograms;
import java.lang.StringBuilder;
import java.lang.*;

public class Permutation{
  public static void main(String[] args)
  {
   if(!(args.length==0))
   {
   String str1=args[0];
   String str2=args[1];
   Permutation obj= new Permutation();
   String str3=obj.Rev(str2);
   if(str1.equals(str3))
   {
   System.out.println("The given two strings are permutation");
   }
   else
   {
     System.out.println("The given two strings are Not Permutation");
   }
   
  }
  
  /* Reverses a particular string*/
  public static String Rev(String str)
  {
  StringBuilder word= new StringBuilder(str);
  word.reverse();	  
  return word.toString();
  }
  }