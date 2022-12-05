import java.io.*;
import java.util.*;

public class day5 {
    public static void main(String[] args) throws Exception
    {
        File input = new File("C:\\Users\\micha\\adventofcode\\day5Work\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        List<Stack<Character>> piles = new ArrayList<Stack<Character>>();
        Stack<Character> pile1 = new Stack<Character>();
        Stack<Character> pile2 = new Stack<Character>();
        Stack<Character> pile3 = new Stack<Character>();
        Stack<Character> pile4 = new Stack<Character>();
        Stack<Character> pile5 = new Stack<Character>();
        Stack<Character> pile6 = new Stack<Character>();
        Stack<Character> pile7 = new Stack<Character>();
        Stack<Character> pile8 = new Stack<Character>();
        Stack<Character> pile9 = new Stack<Character>();

        // My great shame. Sometimes in life you know when to pick your battles -
        // parsing this input automatically was not one of those days. 
        pile1.add('Q');
        pile1.add('S');
        pile1.add('W');
        pile1.add('C');
        pile1.add('Z');
        pile1.add('V');
        pile1.add('F');
        pile1.add('T');

        pile2.add('Q');
        pile2.add('R');
        pile2.add('B');

        pile3.add('B');
        pile3.add('Z');
        pile3.add('T');
        pile3.add('Q');
        pile3.add('P');
        pile3.add('M');
        pile3.add('S');

        pile4.add('D');
        pile4.add('V');
        pile4.add('F');
        pile4.add('R');
        pile4.add('Q');
        pile4.add('H');

        pile5.add('J');
        pile5.add('G');
        pile5.add('L');
        pile5.add('D');
        pile5.add('B');
        pile5.add('S');
        pile5.add('T');
        pile5.add('P');

        pile6.add('W');
        pile6.add('R');
        pile6.add('T');
        pile6.add('Z');

        pile7.add('H');
        pile7.add('Q');
        pile7.add('M');
        pile7.add('N');
        pile7.add('S');
        pile7.add('F');
        pile7.add('R');
        pile7.add('J');

        pile8.add('R');
        pile8.add('N');
        pile8.add('F');
        pile8.add('H');
        pile8.add('W');

        pile9.add('J');
        pile9.add('Z');
        pile9.add('T');
        pile9.add('Q');
        pile9.add('P');
        pile9.add('R');
        pile9.add('B');

        piles.add(pile1);
        piles.add(pile2);
        piles.add(pile3);
        piles.add(pile4);
        piles.add(pile5);
        piles.add(pile6);
        piles.add(pile7);
        piles.add(pile8);
        piles.add(pile9);

        while((line = br.readLine()) != null)
        {
            int r1 = line.indexOf(' ');
            int r2 = line.indexOf(' ', r1+1);
            int quantity = Integer.parseInt(line.substring(r1+1, r2));
            int pileFrom = Character.getNumericValue(line.charAt(line.length()-6));
            int pileTo = Character.getNumericValue(line.charAt(line.length()-1));
            Stack<Character> temp = new Stack<Character>();

            for(int i = 0; i < quantity; i++)
                temp.add(piles.get(pileFrom-1).pop());
    
            for(int i = 0; i < quantity; i++)
                piles.get(pileTo-1).add(temp.pop());
        }

        if(br != null)
            br.close();

        for(int i = 0; i < piles.size(); i++)
            System.out.print(piles.get(i).peek());
        System.out.println();
    }
}
