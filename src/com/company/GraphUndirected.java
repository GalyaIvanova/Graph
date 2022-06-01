package com.company;
// A Java program to print topological
// sorting of a DAG

import java.io.*;
import java.util.*;

public class GraphUndirected {



    // This class represents a directed graph
// using adjacency list representation

        // No. of vertices
        private int V;
    private boolean adjMatrix[][];
        // Adjacency List as ArrayList of ArrayList's
        private ArrayList<ArrayList<Integer> > adj;

        // Constructor
        GraphUndirected(int v)
        {
            V = v;
            adj = new ArrayList<ArrayList<Integer> >(v);
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<Integer>());
            adjMatrix = new boolean[V][V];
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v);
            adjMatrix[w][v] = true;
            adjMatrix[v][w] = true;
        }

        // A recursive function used by topologicalSort
        void topologicalSortUtil(int v, boolean visited[],
                                 Stack<Integer> stack)
        {
            // Mark the current node as visited.
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent
            // to thisvertex
            Iterator<Integer> it = adj.get(v).iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }

            // Push current vertex to stack
            // which stores result
            stack.push(Integer.valueOf(v));
        }

        // The function to do Topological Sort.
        // It uses recursive topologicalSortUtil()
        void topologicalSort()
        {
            Stack<Integer> stack = new Stack<Integer>();

            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper
            // function to store
            // Topological Sort starting
            // from all vertices one by one
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            // Print contents of stack
            while (stack.empty() == false)
                System.out.print(stack.pop() + " ");
        }



    public String GetAdjacencyMatrix() {
        System.out.println("   0 1 2 3 4 5 ");
        System.out.println("_  _ _ _ _ _ _");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < V; i++) {
            int degree=0;

            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
                degree+=(j ? 1 : 0);
            }
            s.append(" degree:"+degree+"\n");
        }
        return s.toString();
    }


}
