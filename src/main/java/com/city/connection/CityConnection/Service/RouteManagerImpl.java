package com.city.connection.CityConnection.Service;

import java.util.List;

import com.city.connection.process.Graph;

public class RouteManagerImpl implements RouteManager
{
    private final Graph<String> graph;
   
    public RouteManagerImpl()
    {
        graph = new Graph<>();
    }

    @Override
    public boolean isConnected(String city1, String city2)
    {

        return graph.isConnected(city1, city2);
    }

    @Override
    public List<String> getRoutes(String city1, String city2)
    {
        return graph.showPaths(city1, city2);
    }

    @Override
    public void addConnection(String city1, String city2)
    {
        graph.addNode(city1, city2);
    }

}
