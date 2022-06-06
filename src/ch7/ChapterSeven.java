package ch7;

import com.sun.source.tree.Tree;

public class ChapterSeven {


    public static void main(String[] args) {

//      bidirectional lists
        BFSTraversal graph = new BFSTraversal(6);

//        graph.insertEdge(0, 1);
//        graph.insertEdge(0, 3);
//        graph.insertEdge(0, 4);
//
//        graph.insertEdge(4, 5);
//        graph.insertEdge(3, 5);
//
//        graph.insertEdge(1, 2);
//
//        graph.insertEdge(1, 0);
//        graph.insertEdge(2, 1);
//        graph.insertEdge(4, 1);
//        graph.insertEdge(3, 1);
//        graph.insertEdge(5, 4);
//        graph.insertEdge(5, 3);

        // bidirectional and with self-loop
//        graph.insertEdge(0, 1);
//        graph.insertEdge(0, 2);
//        graph.insertEdge(1, 2);
//        graph.insertEdge(2, 0);
//        graph.insertEdge(2, 3);
//        graph.insertEdge(3, 3);
//        System.out.println("Breadth First Traversal for the graph is:");
//        graph.BFS(2);


        var N_1 = new TreeNode(1);
        var N_9 = new TreeNode(9);
        var N_8 = new TreeNode(8);
        var N_7 = new TreeNode(7);

        var N_3 = new TreeNode(3, N_1, N_9);
        var N_2 = new TreeNode(2, N_8, N_7);
        var N_5 = new TreeNode(5, N_3,N_2);

        graph.treeBFS(N_5);

// =======================================================================================================================


    }

}

