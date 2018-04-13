package com.city.connection.process;

public class Node<V>
{
    V name;

    public Node(V name)
    {
        this.name = name;
    }

    public V getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return  this.name.toString() ;
    }
}
