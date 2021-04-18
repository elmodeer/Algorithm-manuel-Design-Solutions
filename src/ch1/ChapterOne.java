package ch1;

import java.util.*;

public class ChapterOne {



    public static void main(String[] args) {

//        System.out.println(ChapterOne.divideWithoutSlashOrAsterisk(5,1));
//        int[] in = {77,77,77,77,77,41,77,41,41,77};
//        int[] out = ChapterOne.dailyTemperatures(in);

//        var head = new ListNode(1);
//        head.next = new ListNode( 2);
//        head.next.next = new ListNode( 3);
//        head.next.next.next = new ListNode( 4);
//        head.next.next.next.next = new ListNode( 5);
//
//        ChapterOne.printNodeList(head);
//        System.out.println("\n------------------");
//        ChapterOne.printNodeList(ChapterOne.rotateRight(head, 1));

//        int[] in = {1,1,2,2,2,1};
//        int[] in = {1,5,4,5,6,7,1,1,1,1};
//        int[] in = {1,1,2,1,2,1};
//        int[] in = {1,1,2,2,2,1};
//        int[] in = {1,3,1,1,2,2,4,7,5,6};
//        ChapterOne.wiggleSort(in);
//        ChapterOne.print(in);

//        var integers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        System.out.println(Arrays.toString(ChapterOne.rotateLeft(1, integers).toArray()));


        // 0, 3, 4, 2 => YES
        // 0, 2, 5, 3 => NO
        // 2, 5, 4, 2 =>  NO *
        // 1, 4, 6, 1 => NO *
        // 1, 4, 5, 2 => YES
        // 1571, 4240, 9023, 4234
//        System.out.println(ChapterOne.kangaroo( 1, 4, 6, 1 ));

        try {
            Scanner sc = new Scanner(System.in);
            int i, j, n, ans;
            while (sc.hasNext()) {
                i = sc.nextInt();
                j = sc.nextInt();
                ans = 0;
                for (n = Math.min(i, j); n <= Math.max(i, j); n++) {
                    ans = Math.max(cycle(n), ans);
                }
                System.out.println(String.format("%d %d %d", i, j, ans));
            }
        } catch (Exception e) {
            // Nothing to do here
        } finally {
            System.exit(0);
        }
        
    }

    private static int cycle(long n) {
        int count = 0;
        while(true) {
            count++;
            if (n == 1) return count;
            if (n%2 == 1 ) n = 3*n +1;
            else n = n/2;
        }
    }

    // Interview problems
    // 32
    public static int divideWithoutSlashOrAsterisk(int a, int n) {
        return a >>= n;
    }

    /**
     * leetCode
     *  1
     * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
     */

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        result[T.length - 1] = 0;
        for (int i = 0; i < T.length - 1; i++) {
            var first = T[i];
            if (T[i+1] > first) result[i] = 1;
            else {
                var days = 1;
                var j = i ;
                // go all the way till there is bigger OR there is not
                while (j < T.length - 1) {
                    if (T[j+1] <= first) {
                        days += 1;
                        // if end and there is no bigger element
                        if (j + 1 == T.length - 1 && T[j + 1] <= first) days = 0;
                        j++;
                    } else break;
                }
                result[i] = days;
            }
        }
        return result;
    }


    static void printNodeList(ListNode head) {

        while (head.next != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    // 2
    static ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return null;
        if (head.next == null) {
            return head;
        }
        //1- get length
        var length = 1;
        var copyHead = head;
        while (copyHead.next != null) {
            // if last wind
            length++;
            copyHead = copyHead.next;
        }
        // wind
        copyHead.next = head;



        // rotate
        ListNode cutAt = head;
        k = length - (k % length);
        for (int j = 0; j < k ; j++) {
            head = head.next;
            if (j == k -2) {
                cutAt = head;
            }
        }
        // cut where you wind
        cutAt.next = null;
        return head;
    }

    // [1,3,2,2,2,3,4,5]
    // {1,3,2,2,3,1};
    // {1,3,1,1,1,1,4,2,5,6};
    // [1,3,6,6,6,3,4,5]
    //[ 1, 5, 1, 1, 6, 4 ]
    // =================================================================================================================

    // {1,1,2,2,2,1}

    // 3
    static void wiggleSort(int[] nums) {

        // Just for debugging
//        ChapterOne.print(nums);

        // complete shit

        // Just for debugging
//        ChapterOne.print(nums);
    }

    static int[] swap(int[] n, int i) {
        var temp = n[i];
        n[i] = n[i+1];
        n[i+1] = temp;
        return n;
    }

    /**
     * HackerRank
     */
    // [1, 2, 3, 4, 5] d =2 -> [3, 4, 5, 1, 2]
    // 1
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        // slow
        //        for (int i = 0; i < d; i++) {
        //            Integer first = arr.get(0);
        //            for (int j = 0; j < arr.size() - 1 ; j++) {
        //                Integer next = arr.get(j+1);
        //                arr.set(j, next);
        //            }
        //            arr.set(arr.size() -1, first);
        //        }

        // better approach
        d = d % arr.size();
        List<Integer> firsts = new ArrayList<>();

        for (int i = 0; i < d ; i++) {
            firsts.add(arr.get(i));
        }


        for (int j = 0; j < arr.size() - d ; j++) {
            Integer next = arr.get(j+d);
            arr.set(j, next);
        }

        for (int i = arr.size() -d, j=0; i < arr.size(); i++, j++) {
            arr.set(i, firsts.get(j));
        }
        return arr;
    }

    // 2
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // x2 > x1 is a constraint
        // 1, 4, 6, 1
        if (v1 > v2) {
            while ( (x1 + v1) < Integer.MAX_VALUE  && (x1 + v1)  > 0 & (x2 + v2) < Integer.MAX_VALUE && (x2 + v2)  > 0 ) {

                // 5 | 9 | 13 |  17
                x1 += v1;
                // 7 | 8 | 9 | 10
                x2 += v2;

                if (x1 == x2) {
                    return "YES";
                }
            }
        }
        return "NO";


//        if (v1 > v2) {
//
//            int jumpsNumber = (x1 - x2) % (v2 - v1);
//
//            if (jumpsNumber == 0) {
//                return "YES";
//            }
//        }
//        return "NO";

//        return v1>v2 ? (x1 - x2) % (v2 - v1) ==0 ? "YES" : "NO": "NO";

    }



}

//2 147 483 645 + 4 = 2,147,483,647







