import java.io.*;
import java.util.*;

public class day4 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day4Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line, r1, r2;
        int start1, end1, start2, end2, overlapCount = 0;

        while((line = br.readLine()) != null)
        {
            // Extract the numbers.
            r1 = line.substring(0, line.indexOf(','));
            r2 = line.substring(line.indexOf(',') + 1);
            start1 = Integer.parseInt(r1.substring(0, r1.indexOf('-')));
            start2 = Integer.parseInt(r2.substring(0, r2.indexOf('-')));
            end1 = Integer.parseInt(r1.substring(r1.indexOf('-') + 1));
            end2 = Integer.parseInt(r2.substring(r2.indexOf('-') + 1));
            
            // If one interval starts between the other two, there's an overlap.
            if(start1 <= end2 && start1 >= start2 || start2 <= end1 && start2 >= start1)
                overlapCount++;
            
        }

        if(br != null)
            br.close();
        
        System.out.println(overlapCount);
    }
}
