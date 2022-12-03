import java.io.*;
import java.util.Arrays;

public class day2 
{
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day2Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        int score = 0;
        char[] plays = {'A', 'B', 'C'};
        char opp = 'a';
        char result = 'a';

        while((line = br.readLine()) != null)
        {
            int temp = 0;
            opp = line.charAt(0);
            result = line.charAt(2);

            // We need to lose.
            if(result == 'X')
                score += ((temp = Arrays.binarySearch(plays, opp)) != 0) ? temp : 3;

            // We need to draw.
            if(result == 'Y')
                score += (Arrays.binarySearch(plays, opp) + 1) + 3;

            // We need to win.
            if(result == 'Z')
                score += (((temp = Arrays.binarySearch(plays, opp) + 2) <= 3) ? temp : 1) + 6;
        }

        if(br != null)
            br.close();

        System.out.println(score);
    }
}
