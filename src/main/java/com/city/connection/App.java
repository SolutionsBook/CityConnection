package com.city.connection;

import java.util.List;

import com.city.connection.process.Graph;

public class App
{

    //Test method
    public static void main(String[] args)
    {
        Graph<String> cities = new Graph<>();
        cities.addNode("Washington", "Philadelphia");
        cities.addNode("Philadelphia", "Newark");
        cities.addNode("Newark", "New York");
        cities.addNode("LA", "SFO");
        cities.addNode("Tokyo", "Hong Kong");
        
        List<String> routes = cities.showPaths("Washington", "New York");
        System.out.println(routes);
        
        Graph<String> g = new Graph<>();
        g.addNode("0", "1");
        g.addNode("0", "2");
        g.addNode("0", "3");
        g.addNode("2", "0");
        g.addNode("2", "1");
        g.addNode("1", "3");

        List<String> routes1 = g.showPaths("2", "3");
        System.out.println(routes1);
    }
}
