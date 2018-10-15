package com.example.shalomhalbert.problemsolving.october2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    @Test
    public void test() {
        int[][] input = {{1,2}, {3}, {3}, {}};
        List<List<Integer>> result = allPathsSourceTarget(input);
//        Output: [[0,1,3],[0,2,3]]
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
