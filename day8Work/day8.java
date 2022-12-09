package day8Work;
import java.io.*;

public class day8 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day8Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        int upperBound = 99;
        int[][] trees = new int[upperBound][upperBound];
        boolean[][] vis = new boolean[upperBound][upperBound];
        int currLine = 0, numVis = 0;
        
        // A messy solution to a messy problem. I attempted to save space by 
        // negating the values of seen trees (instead of the wholly separate
        // boolean array) but ran into trouble with trees of size zero. Of course
        // I could have just added one to every entry and got the same answer...
        // but I didn't. Might change that later. Anyway I've got a day to catch
        // up on!

        while((line = br.readLine()) != null)
        {
            for(int i = 0; i < upperBound; i++)
                trees[currLine][i] = Character.getNumericValue((line.charAt(i)));
            currLine++;
        }

        int currMax = 0;
        for(int i = 0; i < upperBound; i++)
        {
            currMax = trees[i][0];
            vis[i][0] = true;
            for(int j = 1; j < upperBound; j++)
            {
                if(trees[i][j] > currMax)
                {
                    vis[i][j] = true;
                    currMax = trees[i][j];
                }
                else
                    vis[i][j] = false;
            }
        }
        for(int i = 0; i < upperBound; i++)
        {
            currMax = trees[i][upperBound-1];
            vis[i][upperBound-1] = true;
            for(int j = upperBound-2; j >= 0; j--)
            {
                if(trees[i][j] > currMax)
                {
                    vis[i][j] = true;
                    currMax = trees[i][j];
                }
            }
        }
        for(int j = 0; j < upperBound; j++)
        {
            currMax = trees[0][j];
            vis[0][j] = true;
            for(int i = 1; i < upperBound; i++)
            {
                if(trees[i][j] > currMax)
                {
                    vis[i][j] = true;
                    currMax = trees[i][j];
                }
            }
        }
        for(int j = 0; j < upperBound; j++)
        {
            currMax = trees[upperBound-1][j];
            vis[upperBound-1][j] = true;
            for(int i = upperBound-2; i >= 0; i--)
            {
                if(trees[i][j] > currMax)
                {
                    vis[i][j] = true;
                    currMax = trees[i][j];
                }
            }
        }

        int maxVis = 0, temp = 0;
        for(int i = 0; i < upperBound; i++)
            for(int j = 0; j < upperBound; j++)
            {
                if(vis[i][j])
                    numVis++;
                if((temp = scenicScore(trees, i, j)) > maxVis)
                    maxVis = temp;
            }

        if(br != null)
            br.close();

        System.out.println(numVis);
        System.out.println(maxVis);
    }    

    public static int scenicScore(int[][] trees, int i, int j)
    {
        int lowerBound = 0, upperBound = trees.length;

        if(i == lowerBound || i == upperBound-1 || j == lowerBound || j == upperBound-1)
            return 0;

        int k = i-1;
        int[] treesVis = new int[4];
        for(int l = 0; l < 4; l++)
            treesVis[l] = 1;

        while(k >= lowerBound && trees[k][j] < trees[i][j])
        {
            k--;
            if(k != lowerBound-1)
                treesVis[0]++;
        }
        k = i+1;
        while(k < upperBound && trees[k][j] < trees[i][j])
        {
            k++;
            if(k != upperBound)
                treesVis[1]++;     
        }
        k = j-1;
        while(k >= lowerBound && trees[i][k] < trees[i][j])
        {
            k--;
            if(k != lowerBound-1)
                treesVis[2]++;
        }
        k = j+1;
        while(k < upperBound && trees[i][k] < trees[i][j])
        {
            k++;
            if(k != upperBound)
                treesVis[3]++;    
        }

        return treesVis[0]*treesVis[1]*treesVis[2]*treesVis[3];
    }
}