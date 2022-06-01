package com.company;


// A Java program to print topological
// sorting of a graph using indegrees
import java.util.*;


// Driver program to test above functions
class Graphs {
    public static void runGraphs(){
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        //g.addEdge(2, 5);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(g.GetAdjacencyMatrix());
        //g.toString();
        System.out.println(
                "Following is a Topological Sort");
        g.topologicalSort();

        // Create a graph given in the above diagram
        GraphUndirected g1 = new GraphUndirected(6);
        g1.addEdge(0, 1);
        g1.addEdge(5, 2);
        g1.addEdge(5, 0);
        g1.addEdge(5, 4);
        g1.addEdge(5, 1);
        g1.addEdge(4, 0);
        g1.addEdge(4, 1);
        g1.addEdge(2, 3);
        g1.addEdge(3, 1);


        System.out.println("\n\nFollowing is a Topological sort of the given graph");
        // Function Call
        g1.topologicalSort();

        System.out.println("\n");
        System.out.println(g1.GetAdjacencyMatrix());

    }
    public static void main(String args[])
    {
        //runGraphs();



    }
}