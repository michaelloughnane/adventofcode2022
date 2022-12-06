import java.io.*;
import java.util.*;

public class day6 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day6Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line = br.readLine();

        ArrayDeque<Character> buffer = new ArrayDeque<Character>();

        for(int i = 0; i < line.length(); i++)
        {
            if(!buffer.contains(line.charAt(i)))
            {
                // Since we haven't actually added line.charAt(i) yet, we want
                // the buffer to be n-1 letters long. We can add one to offset
                // i starting at 0.
                if(buffer.size() == 13)
                {
                    System.out.println(i+1);
                    break;
                }
            }
            else
            {
                while(buffer.contains(line.charAt(i)))
                    buffer.remove();    
            }
            buffer.add(line.charAt(i));
        }

        br.close();
    }
}
