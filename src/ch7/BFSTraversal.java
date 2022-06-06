package ch7;

import java.util.*;

/* javaPoint Implementation */
public class BFSTraversal {
    private int nodeLength;       /* total number of nodes in the graph */
    private LinkedList<Integer>[] adj;     /* adjacency list  -> an array of LinkedLists */
    private Queue<Integer> que;           /* maintaining a queue */

    BFSTraversal(int nodeLength) {
        this.nodeLength = nodeLength;
        adj = new LinkedList[nodeLength];
        for (int i = 0; i < nodeLength; i++) {
            adj[i] = new LinkedList<>();
        }
        que = new ArrayDeque<>();
    }

    void insertEdge(int x, int y) {
        adj[x].add(y);      /* adding an edge to the adjacency list (edges are bidirectional in this example) */
    }

    void BFS(int startNode) {
        var visitedNodes = new HashSet<Integer>();
        que.add(startNode);      /* root node is added to the top of the queue */
        while (que.size() != 0) {
           // go in levels => that is the queue
            startNode = que.poll(); // 0 | 1 | 3 | 4
            visitedNodes.add(startNode);
            System.out.printf( startNode + " ");
            for (int i = 0; i < adj[startNode].size(); i++) {
                var a = adj[startNode].get(i); // {1, 3, 4} | 2 | 5 | 5

                if (!visitedNodes.contains(a)) {
                    que.add(a); // {1, 3, 4} | 2 | 5
                    visitedNodes.add(a); // {1, 3, 4} | 2 | 5
                }
            }

        }
    }

}
