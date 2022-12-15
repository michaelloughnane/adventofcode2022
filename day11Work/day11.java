package day11Work;
import java.util.*;

public class day11 {
    public static void main(String[] args)
    {

        // This one was not fun! Lots of fiddling with int/long etc. to try and 
        // make it work. I probably should have gotten the solution sooner, but
        // I suppose these things always look more obvious with hindsight.

        Monkey monkey0 = new Monkey(new long[] {64}, 7, true, 13);
        Monkey monkey1 = new Monkey(new long[] {60, 84, 84, 65}, 7, false, 19);
        Monkey monkey2 = new Monkey(new long[] {52, 67, 74, 88, 51, 61}, 3, true, 5);
        Monkey monkey3 = new Monkey(new long[] {67, 72}, 3, false, 2);
        Monkey monkey4 = new Monkey(new long[] {80, 79, 58, 77, 68, 74, 98, 64}, 80, true, 17);
        Monkey monkey5 = new Monkey(new long[] {62, 53, 61, 89, 86}, 8, false, 11);
        Monkey monkey6 = new Monkey(new long[] {86, 89, 82}, 2, false, 7);
        Monkey monkey7 = new Monkey(new long[] {92, 81, 70, 96, 69, 84, 83}, 4, false, 3);

        for(int i = 0; i < 10000; i++)
        {
            while(monkey0.hasItems())
            {
                long curr = monkey0.inspect();
                if(curr > 0)
                    monkey1.addItem(curr);
                else
                    monkey3.addItem(curr*-1);
            }

            while(monkey1.hasItems())
            {
                long curr = monkey1.inspect();
                if(curr > 0)
                    monkey2.addItem(curr);
                else
                    monkey7.addItem(curr*-1);
            }

            while(monkey2.hasItems())
            {
                long curr = monkey2.inspect();
                if(curr > 0)
                    monkey5.addItem(curr);
                else
                    monkey7.addItem(curr*-1);
            }

            while(monkey3.hasItems())
            {
                long curr = monkey3.inspect();
                if(curr > 0)
                    monkey1.addItem(curr);
                else
                    monkey2.addItem(curr*-1);
            }

            while(monkey4.hasItems())
            {
                monkey4.setOperation(monkey4.currItem());
                long curr = monkey4.inspect();
                if(curr > 0)
                    monkey6.addItem(curr);
                else
                    monkey0.addItem(curr*-1);
            }

            while(monkey5.hasItems())
            {
                long curr = monkey5.inspect();
                if(curr > 0)
                    monkey4.addItem(curr);
                else
                    monkey6.addItem(curr*-1);
            }

            while(monkey6.hasItems())
            {
                long curr = monkey6.inspect();
                if(curr > 0)
                    monkey3.addItem(curr);
                else
                    monkey0.addItem(curr*-1);
            }

            while(monkey7.hasItems())
            {
                long curr = monkey7.inspect();
                if(curr > 0)
                    monkey4.addItem(curr);
                else
                    monkey5.addItem(curr*-1);
            }
        }

        long[] counts = new long[] {monkey0.countInspections(),
        monkey1.countInspections(),
        monkey2.countInspections(),
        monkey3.countInspections(),
        monkey4.countInspections(),
        monkey5.countInspections(),
        monkey6.countInspections(),
        monkey7.countInspections()};

        Arrays.sort(counts);
        System.out.println(counts[counts.length-1]*counts[counts.length-2]);
    }
}
