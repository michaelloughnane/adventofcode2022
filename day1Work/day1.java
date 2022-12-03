import java.io.*;

public class day1
{
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day1Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        int[] max = new int[3];
        int curr = 0;

        while((line = br.readLine()) != null)
        {
            if(line.isBlank())
            {
                if(curr > max[0])
                {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = curr;
                }
                else if(curr > max[1])
                {
                    max[2] = max[1];
                    max[1] = curr;
                }
                else if(curr > max[2])
                    max[2] = curr;
                curr = 0;
            }
            else
                curr += Integer.parseInt(line);
        }

        if(br != null)
            br.close();

        System.out.println(max[0]+max[1]+max[2]);
    }
}