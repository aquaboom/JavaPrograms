/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concatenationofstrings;
import java.io.*;
import static java.time.Clock.system;

/**
 *
 * @author Sonic
 */
public class ConcatenationOfStrings {

    /**
     * @param args the command line arguments
     */
    public String joinwords(String[] words)
    {
        String sentence="";
    for(String w: words) // iteration
    {
        sentence= sentence + w;
    }
    return sentence;
    }
    public static void main(String[] args) {
        
        ConcatenationOfStrings obj = new ConcatenationOfStrings();
        String[] words= {"Sonali","Rege"};
        obj.joinwords(words);
        System.out.println(obj);
        System.out.println("SONALI IS GREAT");
        
    }
    
}
