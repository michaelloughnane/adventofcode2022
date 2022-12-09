package day9Work;
import java.io.*;

public class day9 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day9Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        // Pretty simple one (that I got stuck on due to a frustrating misreading of
        // directions) - just implementing the movement like the prompt specifies, and
        // the rest comes together from there.

        int upperLim = 1000;
        char[][] grid = new char[upperLim][upperLim];
        int[][] ropePos = new int[10][2];
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 2; j++)
                ropePos[i][j] = upperLim/2;

        for(int i = 0; i < upperLim; i++)
            for(int j = 0; j < upperLim; j++)
                grid[i][j] = '*';

        while((line = br.readLine()) != null)
        {
            char dir = line.charAt(0);
            int dist = Integer.parseInt(line.substring(2));

            tailMove(grid, ropePos, dir, dist);
        }

        if(br != null)
            br.close();

        int visited = 0;
        for(int i = 0; i < upperLim; i++)
            for(int j = 0; j < upperLim; j++)
                if(grid[i][j] == '#')
                    visited++;

        System.out.println(visited);
    }

    public static void tailMove(char[][] grid, int[][] ropePos, char dir, int dist)
    {
        int[][] temp = new int[10][2];
        for(int k = 0; k < dist; k++)
        {
            for(int i = 0; i < 10; i++)
                for(int j = 0; j < 2; j++)
                    temp[i][j] = ropePos[i][j];

            switch(dir)
            {
                case 'U':
                ropePos[0][1]++;
                break;
                case 'D':
                ropePos[0][1]--;
                break;
                case 'R':
                ropePos[0][0]++;
                break;
                case 'L':
                ropePos[0][0]--;
                break;
            }

            for(int i = 0; i < 9; i++)
                if(!isAdjacent(ropePos[i], ropePos[i+1]))
                {
                    if(ropePos[i+1][0] == ropePos[i][0])
                    {
                        if(ropePos[i+1][1] > ropePos[i][1])
                            ropePos[i+1][1]--;
                        else
                            ropePos[i+1][1]++;
                    }
                    else if(ropePos[i+1][1] == ropePos[i][1])
                    {
                        if(ropePos[i+1][0] > ropePos[i][0])
                            ropePos[i+1][0]--;
                        else
                            ropePos[i+1][0]++;
                    }
                    else
                    {
                        if(ropePos[i+1][0] > ropePos[i][0])
                            ropePos[i+1][0]--;
                        else
                            ropePos[i+1][0]++;
                        if(ropePos[i+1][1] > ropePos[i][1])
                            ropePos[i+1][1]--;
                        else
                            ropePos[i+1][1]++;
                    }
                }
            grid[ropePos[9][0]][ropePos[9][1]] = '#';
        }
    }

    public static boolean isAdjacent(int[] headPos, int[] tailPos)
    {
        return ((Math.abs(tailPos[0]-headPos[0]) <= 1) && (Math.abs(tailPos[1]-headPos[1]) <= 1));
    }
}