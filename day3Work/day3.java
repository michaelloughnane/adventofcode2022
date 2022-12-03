import java.io.*;
import java.util.*;

// Quick and dirty solution, this one was. Decided to stay up until midnight and give it a go.
// If this comment is still here when you're reading this, that means I haven't gotten around to
// making it any nicer. Time will tell if I ever decide to do this.

public class day3 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day3Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        HashMap<Character,Integer> contents = new HashMap<>();
        int lineCount = 0;
        int priorities = 0;

        while((line = br.readLine()) != null)
        {
            lineCount++;

            if(lineCount == 1)
            {
                contents.clear();
                for(int i = 0; i < line.length(); i++)
                    contents.put(line.charAt(i), 1);
            }
            else if(lineCount == 2)
            {
                for(int i = 0; i < line.length(); i++)
                {
                    if(contents.containsKey(line.charAt(i)))
                        contents.put(line.charAt(i), 2);
                }
            }
            else
            {
                for(int i = 0; i < line.length(); i++)
                    if(contents.getOrDefault(line.charAt(i), 0) == 2)
                    {
                        priorities += getPriority(line.charAt(i));
                        break;
                    }
                
                lineCount = 0;
            }
        }

        System.out.println(priorities);
    }

    public static int getPriority(char s)
    {
        int priority = Character.getNumericValue(s) - 9;
        if(Character.isUpperCase(s))
            priority += 26;
        return priority;
    }
}
