package Graph;

/**
 * Created by xuanwang on 1/1/17.
 */
/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;
        for(int i = 0; i < edges.length; i++){
            int r1 = find(edges[i][0], roots);
            int r2 = find(edges[i][1], roots);
            if(r1 != r2){
                roots[r1] = r2;
                n--;
            }
        }
        return n;
    }

    private int find(int i, int[] roots){
        while(roots[i] != i){
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
