package shortestsubstring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vaidehi
 */
public class ShortestSubstringIT {
    
    public ShortestSubstringIT() {
    }
    
   
    @Test
    //this test case checks null
    public void testNull() {
        System.out.println("test: null");
        String sentence = "";
        String[] list = null;
        String expected = "";
        String output= ShortestSubstring.findShortest(sentence, list);
        
        assertEquals(expected, output);
       
    }
    
    
    @Test
    //this test case checks if there is no match of words from the given list
    public void testNotFound(){
        System.out.println("Test: not found");
        String sentence = "On good days, work out"+
                "on bad days, work out harder";
        String[] list = {"fitness", "gym"};
        String expected = "";
        String output = ShortestSubstring.findShortest(sentence, list);
       
        assertEquals(expected, output);
        
     }
    
    @Test
    //this test case checks if substring is present
    public void testSubstring(){
        System.out.println("Test: not found");
        String sentence = "My cat was missing today. I hope she comes back."
                            +"She was chased by the dog next door. I love my cat";
        String[] list = {"cat", "dog", "chased"};
        String expected = "chased by the dog next door. I love my cat";
        String output = ShortestSubstring.findShortest(sentence, list);
       
        assertEquals(expected, output);
        
    }
    
}
