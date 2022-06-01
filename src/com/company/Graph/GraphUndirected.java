package com.company.Graph;

import java.io.*;
import java.util.*;

public class GraphUndirected {

    // This class represents a directed graph
    // using adjacency list representation

    // No. of vertices
    private int V;
    private boolean adjMatrix[][];
    private int degreeArray[];
    private int topologicalSorted[];
    // Adjacency List as ArrayList of ArrayList's
    private ArrayList < ArrayList < Integer > > adj;

    // Constructor
    GraphUndirected(int v) {
        V = v;
        adj = new ArrayList < ArrayList < Integer > > (v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList < Integer > ());
        adjMatrix = new boolean[V][V];
        degreeArray = new int[V];
        topologicalSorted = new int[V];
        String str = this.GetAdjacencyMatrix();

    }

    private ArrayList < Integer > SortByDegree(ArrayList < Integer > adjSort) {
        int tempArr[] = new int[adjSort.size()];

        int k = 0;

        Iterator < Integer > it = adjSort.iterator();
        while (it.hasNext()) {
            tempArr[k] = it.next();
            k++;
        }

        int n = tempArr.length;
        for (int i = 1; i < n; ++i) {
            int key = degreeArray[tempArr[i]];
            int keyValue = tempArr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && degreeArray[tempArr[j]] < key) {
                tempArr[j + 1] = tempArr[j];
                j = j - 1;
            }
            tempArr[j + 1] = keyValue;
        }
        ArrayList < Integer > adjSorted = new ArrayList < Integer > ();

        for (int i = 0; i < n; i++) {
            adjSorted.add(tempArr[i]);
        }
        return adjSorted;
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
                             Stack < Integer > stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex

        Iterator < Integer > it = SortByDegree(adj.get(v)).iterator();
        //System.out.println(v+" "+adj.get(v)+" visiting: ");
        while (it.hasNext()) {
            i = it.next();

            //System.out.println(v+" "+adj.get(v)+" visiting: "+i); за проверка
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(Integer.valueOf(v));
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    void topologicalSort() {
        Stack < Integer > stack = new Stack < Integer > ();

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

        int i = -1;
        // Print contents of stack
        while (stack.empty() == false) {
            topologicalSorted[++i] = stack.pop();
        }

    }



    public String GetAdjacencyMatrix() {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < V; i++) {
            int degree = 0;

            s.append(i + ": ");
            for (boolean j: adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
                degree += (j ? 1 : 0);
            }
            this.degreeArray[i] = degree;
            s.append(" degree:" + degree + "\n");
        }
        return s.toString();
    }

    public void getOrderAndDegree() {
        String str = this.GetAdjacencyMatrix();
        this.topologicalSort();

        for (int i = 0; i < V; i++) {
            System.out.println(i + ". Vertex(възел): " + topologicalSorted[i] + ", Degree(степен): " + degreeArray[topologicalSorted[i]]);
        }
    }


}