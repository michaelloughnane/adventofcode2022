package day10Work;
import java.io.*;

public class day10 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day10Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        int register = 1;
        int cycleProcessing = 0;
        int cycleNum = -1;

        while((line = br.readLine()) != null)
        {
            cycleNum++;
            if(cycleNum % 40 == 0)
            {
                System.out.println();
                cycleNum = 0;
            }
            
            if(Math.abs(cycleNum-register) <= 1)
                System.out.print("#");
            else
                System.out.print(".");

            if(line.charAt(0) != 'n')
            {
                cycleNum++;
                if(cycleNum % 40 == 0)
                {
                    System.out.println();
                    cycleNum = 0;
                }
            
                if(Math.abs(cycleNum-register) <= 1)
                    System.out.print("#");
                else
                    System.out.print(".");

                cycleProcessing = Integer.parseInt(line.substring(5));
            }
            else
                cycleProcessing = 0;

            register += cycleProcessing;
        }

        if(br != null)
            br.close();
    }
}
