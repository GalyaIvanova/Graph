package com.company.Graph;


// A Java program to print topological
// sorting of a graph using degrees

class Graphs {
    public static void runGraphs() {

        // Create a graph given in the above diagram
        GraphUndirected g1 = new GraphUndirected(6);

        g1.addEdge(5, 2);
        g1.addEdge(5, 0);
        g1.addEdge(4, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 1);
        g1.addEdge(4, 3);
        g1.addEdge(0, 3);


        System.out.println("\n\nFollowing is a Topological sort of the given graph");
        // Function Call
        System.out.println("\n");

        g1.getOrderAndDegree();

    }
    public static void main(String args[]) {
        runGraphs();

    }
}