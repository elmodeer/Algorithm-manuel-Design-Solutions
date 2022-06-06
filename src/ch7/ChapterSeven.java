package ch7;

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
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 0);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 3);

        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(2);

// =======================================================================================================================


    }

}

