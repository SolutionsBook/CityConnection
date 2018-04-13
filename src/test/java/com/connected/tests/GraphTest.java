package com.connected.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.city.connection.CityConnection.Service.RouteManager;
import com.city.connection.CityConnection.Service.RouteManagerImpl;

public class GraphTest
{
    private final RouteManager routeManager;

    public GraphTest()
    {
        routeManager = new RouteManagerImpl();
    }

    @Before
    public void populate_map()
    {

        routeManager.addConnection("Washington", "Philadelphia");
        routeManager.addConnection("Philadelphia", "Newark");
        routeManager.addConnection("Newark", "New York");
        routeManager.addConnection("Tokyo", "HongKong");

    }

    @Test
    public void test_check_routes()
    {

        List<String> expected_route_wa_to_ny = TestSetups.loadRoutes_wa_to_ny();
        List<String> actual_routes_wa_to_ny = routeManager.getRoutes("Washington", "New York");

        List<String> expected_route_ny_to_wa = TestSetups.loadRoutes_ny_to_wa();
        List<String> actual_route_ny_to_wa = routeManager.getRoutes("New York", "Washington");

        assertEquals(expected_route_ny_to_wa, actual_route_ny_to_wa);
        assertEquals(expected_route_wa_to_ny, actual_routes_wa_to_ny);

        List<String> empty = Collections.emptyList();
        assertEquals(empty, routeManager.getRoutes("New York", "Tokyo"));

    }

    @Test
    public void test_connection()
    {

        assertEquals(true, routeManager.isConnected("Washington", "New York"));
        assertEquals(true, routeManager.isConnected("New York", "Washington"));
        assertEquals(false, routeManager.isConnected("New York", "Tokyo"));

    }

}
