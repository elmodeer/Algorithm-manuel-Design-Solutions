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


//         if(p==null && q==null)
//            return true;
//        if(p==null || q==null)
//            return false;
//        if(p.val!=q.val)
//            return false;
//        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    public void treeBFS(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.printf(root.val + " ");

            if (root.left != null ) {
                queue.add(root.left);
            }

            if (root.right != null ) {
                queue.add(root.right);
            }
        }
    }

    // really invasive isSameTree
    // Take home lesson: compare node => structure => value
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        //structure
        if(p == null || q == null){
            return false;
        }

        //val
        if(p.val != q.val){
            return false;
        }

        // [1,2]
        // [1,null,2]
        Queue<TreeNode> pQueue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> qQueue = new ArrayDeque<TreeNode>();

        pQueue.add(p);
        qQueue.add(q);

        while (pQueue.size() != 0 && qQueue.size() != 0) {
            p = pQueue.poll(); // 1
            q = qQueue.poll(); // 1


            if(p.val != q.val)  return false;

            // p.left = 2
            // q.left = null
            if(p.left != null && q.left == null ) return false;
            if(p.left == null && q.left != null ) return false;

            if(p.right == null && q.right != null ) return false;
            if(p.right != null && q.right == null ) return false;

            if(p.left != null && q.left != null ) {
                pQueue.add(p.left); // noExec
                qQueue.add(q.left); // noExec
            }

            if(p.right != null && q.right != null ) {
                pQueue.add(p.right); // noExec
                qQueue.add(q.right); // noExec
            }


        }
        return true;

    }

    // optimum solution
    public boolean isSameTreeSmart(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;

        //structure
        if(p == null || q == null) return false;

        //val
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }
}
