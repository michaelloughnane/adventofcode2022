package day11Work;
import java.math.BigInteger;
import java.util.*;

public class Monkey {
    List<Long> items;
    long operationMod;
    boolean operationMult;
    int testMod;
    int inspectCount;

    public Monkey(long[] startItems, long op, boolean mult, int test)
    {
        items = new ArrayList<Long>();
        for(Long item : startItems)
            items.add(item);
        operationMod = op;
        operationMult = mult;
        testMod = test;
        inspectCount = 0;
    }

    public void setOperation(long op)
    {
        operationMod = op;
    }

    public boolean hasItems()
    {
        return (!items.isEmpty());
    }
    public long inspect()
    {
        long curr = items.get(0);
        items.remove(0);
        curr = (operationMult) ? (curr * operationMod) : 
            (curr + operationMod);
        curr %= 2*3*5*7*11*13*17*19;
        inspectCount++;
        if(curr % testMod == 0)
            return curr;
        else
            return -1*curr;
    }

    public long currItem()
    {
        return items.get(0);
    }
    public void addItem(Long item)
    {
        items.add(item);
    }

    public int countInspections()
    {
        return inspectCount;
    }
}
