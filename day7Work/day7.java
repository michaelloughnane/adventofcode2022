package day7Work;

import java.io.*;

public class day7 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day7Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        Node files = new Node("start!", null);
        Node curr = files;

        // Approached this one in the way that seemed most intuitive - file storage is a recursive
        // tree setup, so I implemented a tree! No easy way for non-binary trees native to Java,
        // so I went ahead and made my own class for it. After mapping it all out, using some
        // recursion to solve from there was simple enough.

        while((line = br.readLine()) != null)
        {
            if(line.charAt(0) == '$')
            {
                if(line.substring(2).equals("ls"))
                    continue;
                else if(line.contains(".."))
                    curr = curr.getParent();
                else
                {
                    if(curr.getChild(line.substring(5)) == null)
                        curr.addChild(new Node(line.substring(5), curr));
                    curr = curr.getChild(line.substring(5));
                }
            }
            else if(line.charAt(0) == 'd')
            {
                if(curr.getChild(line.substring(4)) == null)
                    curr.addChild(new Node(line.substring(4), curr));
            }
            else
            {
                int divide = line.indexOf(' ');
                int size = Integer.parseInt(line.substring(0, divide));
                String name = line.substring(divide+1);
                if(curr.getChild(name) == null)
                    curr.addChild(new Node(name, size, curr));
            }
        }

        if(br != null)
            br.close();

        files = files.getFirstChild();
        computeSize(files);
        System.out.println(maxInCapacity(files));
        System.out.println(minOversize(files, files.getCumValue()-40000000));
    }

    public static int computeSize(Node n)
    {
        if(n.getFirstChild() == null)
        {
            n.setCumValue(0);
            return n.getVal();
        }

        if(n.getCumValue() != -1)
            return n.getCumValue();

        int size = n.getVal();
        Node child = n.getFirstChild();
        while(child != null)
        {
            size += computeSize(child);
            child = n.getNextSibling(child);
        }
        n.setCumValue(size);
        return size;
    }

    public static int maxInCapacity(Node n)
    {
        int sum = 0;
        if(n.getCumValue() < 100000 && n.getCumValue() > 0)
            sum += n.getCumValue();
        
        Node child = n.getFirstChild();
        while(child != null)
        {
            sum += maxInCapacity(child);
            child = n.getNextSibling(child);
        }

        return sum;
    }

    public static int minOversize(Node n, int csz)
    {
        if(n.getFirstChild() == null)
            return n.getVal();
        
        int min = n.getCumValue();
        int temp;
        Node child = n.getFirstChild();
        while(child != null)
        {
            if(child.getCumValue() > csz && child.getCumValue() < min)
                min = child.getCumValue();
            if(child.getCumValue() >= min)
                if((temp = minOversize(child, csz)) > csz && temp < min)
                    min = temp;
            child = n.getNextSibling(child);
        }

        return min;
    }
}