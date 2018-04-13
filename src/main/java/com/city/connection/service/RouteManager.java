package com.city.connection.service;

import java.util.List;

public interface RouteManager
{
    boolean isConnected(String city1, String city2);

    List<String> getRoutes(String city1, String city2);

    void addConnection(String city1, String city2);
    
 
}
