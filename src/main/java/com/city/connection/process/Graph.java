package com.city.connection.process;

import java.util.*;
import java.util.stream.Collectors;

/*
 * uses Map to create connections.
 */
public class Graph<V>
{
    /*
     map - which holds all connected nodes for a particular vertex
     one vertex can be connected to many vertices
      */
    private final Map<V, List<Node<V>>> adjacencyMap;

    public Graph()
    {
        this.adjacencyMap = new HashMap<>();

    }

    /*
      given two vertices, link with each other
      make this bidirectional
     */
    public void addNode(V v1, V v2)
    {
        addNewNode(v1, new Node<>(v2));
        addNewNode(v2, new Node<>(v1));
    }

    /*
     * given two vertices, check if they are related to each other
     */
    public boolean isConnected(V v1, V v2)
    {
        return showPaths(v1, v2).size() != 0;
    }

    // wrapper method around getAllPaths method
    public List<String> showPaths(V v1, V v2)
    {

        List<List<V>> results = getAllPaths(v1, v2);
        List<String> routesList = new ArrayList<>();
        
        if (results.size() == 1) {
            routesList =
                results.stream()
                .flatMap(Collection::stream)
                .map(Object::toString)
                .collect(Collectors.toList());
        } else {
            for (List<V> result : results) {
                routesList.add(result.toString());
            }
        }
        return routesList;
    }

    /* private methods */

    private List<List<V>> getAllPaths(V u, V v)
    {
        List<List<V>> result = new ArrayList<>();
        if (u == v) {
            List<V> temp = new ArrayList<>();
            temp.add(u);
            result.add(temp);
            return result;
        }

        List<Object> visited = new ArrayList<>(); // track visits
        Stack<V> path = new Stack<>(); // once visited, put in stack
        getAllRoutes(u, v, visited, path, result);
        return result;
    }

    // find all path recursively
    private void getAllRoutes(V u, V v, List<Object> visited, Stack<V> path, List<List<V>> result)
    {
        visited.add(u);
        path.add(u);
        if (u == v) {
            result.add(new ArrayList<>(path));
        } else {
            if (adjacencyMap.containsKey(u)) {
                adjacencyMap.get(u).stream()
                    .filter(node -> !visited.contains(node.getName()))
                    .forEach(node -> getAllRoutes(node.getName(), v, visited, path, result));
            }
        }
        path.pop();
        visited.remove(u);
    }

    private void addNewNode(V vertex, Node<V> node)
    {
        // want to add a new node, this can be on existing one or on new
        // check if you can get nodes for v1, if not create a new List and add a node
        // otherwise  you can add on existing list
        List<Node<V>> nodes = adjacencyMap.get(vertex);
        if (nodes != null && !nodes.isEmpty()) {
            nodes.add(node);
        } else {
            nodes = new ArrayList<>();
            nodes.add(node);
        }
        adjacencyMap.put(vertex, nodes);
    }
}
