package medium.graphvalidtree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static class GraphNode {
        final int num;
        final List<GraphNode> links;

        GraphNode(int i) {
            num = i;
            links = new ArrayList(2);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        GraphNode[] nodes = new GraphNode[n];
        for (int i=0; i<n; i++)
            nodes[i] = new GraphNode(i);
        for (int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            nodes[n1].links.add(nodes[n2]);
            nodes[n2].links.add(nodes[n1]);
        }
        boolean[] visited = new boolean[n];
        int[] vcount = new int[1];
        return walktree(nodes[0], visited, -1, vcount) && vcount[0]==n;
    }

    private boolean walktree(GraphNode node, boolean[] visited, int previous, int[] vcount) {
        visited[node.num] = true;
        vcount[0]++;
        for (GraphNode next : node.links) {
            if (next.num != previous) {
                if (visited[next.num] || !walktree(next, visited, node.num, vcount)) return false;
            }
        }
        return true;
    }
}
