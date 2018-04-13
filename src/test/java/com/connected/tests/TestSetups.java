package com.connected.tests;

import java.util.LinkedList;
import java.util.List;

public class TestSetups
{
    public static List<String> loadRoutes_wa_to_ny()
    {
        //Washington, Philadelphia, Newark, New York
        List<String> expected = new LinkedList<>();
        expected.add("Washington");
        expected.add("Philadelphia");
        expected.add("Newark");
        expected.add("New York");

        return expected;
    }

    public static List<String> loadRoutes_ny_to_wa()
    {
        //Washington, Philadelphia, Newark, New York
        // New York, Newark, Philadelphia, Washington
        List<String> expected = new LinkedList<>();
        expected.add("New York");
        expected.add("Newark");
        expected.add("Philadelphia");
        expected.add("Washington");

        return expected;
    }

}
