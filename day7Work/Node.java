package day7Work;
import java.util.*;

public class Node {
    String key;
    int value, cumValue;
    ArrayList<Node> children;
    Node parent;

    public Node(String k, Node p)
    {
        key = k;
        value = 0;
        parent = p;
        cumValue = -1;
        children = new ArrayList<Node>();
    }

    public Node(String k, int v, Node p)
    {
        key = k;
        value = v;
        parent = p;
        cumValue = -1;
        children = new ArrayList<Node>();
    }

    public void setKey(String k)
    {
        key = k;
    }
    public void setVal(int v)
    {
        value = v;
    }

    public void setParent(Node n)
    {
        parent = n;
    }

    public void setCumValue(int v)
    {
        cumValue = v;
    }

    public String getKey()
    {
        return key;
    }

    public int getVal()
    {
        return value;
    }

    public Node getParent()
    {
        return parent;
    }

    public int getCumValue()
    {
        return cumValue;
    }

    public void addChild(Node n)
    {
        children.add(n);
    }

    public Node getChild(String k)
    {
        if(children == null)
            return null;
        Node temp;
        for(int i = 0; i < children.size(); i++)
        {
            temp = children.get(i);
            if(temp.key.equals(k))
                return temp;
        }
        return null;
    }

    public Node getFirstChild()
    {
        return (children != null && children.size() != 0) ? children.get(0) : null;
    }

    public Node getNextSibling(Node n)
    {
        if(children == null)
            return null;

        int loc = children.indexOf(n);
        if(loc == children.size()-1)
            return null;
        else
            return children.get(loc+1);
    }
}
