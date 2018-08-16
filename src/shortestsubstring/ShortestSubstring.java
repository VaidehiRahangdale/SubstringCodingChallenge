package shortestsubstring;
/**
 *
 * @author Vaidehi
 */
import java.util.*;
import java.util.HashMap;
 
class ShortestSubstring {
 
    public static String findShortest(String sentence,
                                     String[] list)
    {   // Make an array of words from given sentence
        // removing punctuations
        String newsent = sentence.replace(".", "");
        newsent = newsent.replace(", ", "");
        newsent = newsent.replace("'", "");
        newsent = newsent.replace("!", "");
        String sent[] = newsent.split(" ");
 
        // hashmap to store given words in a map.
        HashMap<String, Integer> hmap = new HashMap<>();
        int length = list.length;
        for (int i = 0; i < length; i++)
            hmap.put(list[i], -1);
 
        // Traverse and mark appearence in map.
        int len = Integer.MAX_VALUE;
        int count = 0;
        int start = 0, end = 0;
        for (int i = 0; i < sent.length; i++) {
            if (hmap.containsKey(sent[i]) == true) {
 
                // for the first occurence
                int index = hmap.get(sent[i]);
                if (index == -1)
                    count++;
                hmap.put(sent[i], i);
 
                if (count == length) {
 
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<String, Integer> m :
                                     hmap.entrySet()) {
                        int val = m.getValue();
                        if (val < min)
                            min = val;
                    }
 
                    // Check if current length is smaller
                    // then length so far
                    int s = i - min;
                    if (s < len) {
                        start = min;
                        end = i;
                    }
                }
            }
        }
 
        // Printing original substring with punctuations
        String[] original= sentence.split(" ");
        for (int i = start; i <= end; i++)
            System.out.print(original[i] + " ");
        
        return original.toString();
    }
 
    public static void main(String args[])
    {
        String sentence = "health is the real wealth. if we are not healthy,"+
                "wealth does not matter. health is wealth";
        String[] list = { "health", "wealth" , "matter"};
        findShortest(sentence, list);
    }
}
