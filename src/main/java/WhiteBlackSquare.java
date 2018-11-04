import java.util.*;

public class WhiteBlackSquare {

    //binary search - O(logN)

    public static void main(String a[]) {
        //[1,2,4]
        //[1,3,4]
        ListNode list1= new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2= new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = mergeTwoLists(list1, list2);

        boolean r = validPalindrome("jshabas");

        int [][] matrix1 = {{1,2,4},{3,4,5},{5,6,7},{7,8,9}};

        int res[][] = matrixReshape(matrix1, 2, 6);

        //int [][] input = {{5,4},{6,4},{6,7},{2,3}};
        int [][] input = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        int [][] input2 = {{1,1}};
        maxEnvelopes(input);
        int[] square = {0,0,0,0,1,1,1,1,1,1};
        findMidLine(square);

        String [] str = uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(str.toString());

    }
    public static int findMidLine(int [] square){
        int start = 0;
        int end = square.length - 1;
        int mid = 0;
        while(start<=end) {
            mid = (end - start)/2 + start;
            if(square[mid] == square[end]) {
                end = mid;
            } else if(square[mid] != square[end]) {
                start = mid;
            }
            //success
            if(start == (end-1) && square[start]!=square[end]) {
                System.out.println("Mid location is: [" + start + "][" + end + "]");
                return mid;
            }
            //failure
            if(start >= end) {
                System.out.println("Mid was not found");
                return -1; //not found
            }
        }
        return mid;
    }

    //quick search - O(N*logN)
    public static void quickSort(int [] arrayTest) {

    }

    public class quickFind {

        private int [] id;

        public void QuickFindUF (int N){
            id = new int [N];
            for(int i = 0; i< N; i++){
                id[i]=i;
            }
        }
        public boolean connected(int p, int q){
            return id[p] == id[q];
        }

        public void union(int p, int q){
            int pid = id[p];
            int qid = id[q];
            for(int i =0; i<id.length; i++){
                if(id[i] == pid){
                    id[i] = qid;
                }
            }
        }
    }

    public static String[] uncommonFromSentences(String A, String B) {
        List<String> aList = new LinkedList(Arrays.asList(A.split(" ")));
        List<String> bList = new LinkedList(Arrays.asList(B.split(" ")));
        ListIterator it1 = aList.listIterator();
        ListIterator it2 = bList.listIterator();
        while(it1.hasNext()){
            while(it2.hasNext()) {
                if(it1.next().equals(it2.next())) {
                    it1.remove();
                    it2.remove();
                }
            }
        }
        aList.addAll(bList);
        String [] str = new String[aList.size()];
        for(int i = 0;i< aList.size();i++) {
            str[i] = aList.get(i);
        }

        return str;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int number = 0;
        if(envelopes.length != 0 && envelopes[0].length != 0) {
            int[] maxEnvelope = envelopes[0];
            number = 1;
            if (envelopes.length > 1) {
                for (int i = 1; i < envelopes.length; i++) {
                    int[] current = envelopes[i];
                    if (maxEnvelope[0] <= current[0] && maxEnvelope[1] <= current[1]) {
                        maxEnvelope = current;
                    }
                   /* if(maxEnvelope[0] > envelopes[i][0] && maxEnvelope[1] > envelopes[i][1] && maxEnvelope[0] > envelopes[i][1] && maxEnvelope[1] > envelopes[i][0]) {
                        number++;
                    }*/
                }
                for(int j=0;j<envelopes.length;j++){
                    if(maxEnvelope[0] > envelopes[j][0] && maxEnvelope[1] > envelopes[j][1] && maxEnvelope[0] > envelopes[j][1] && maxEnvelope[1] > envelopes[j][0]) {
                        number++;
                    }
                }
            }
        }
        System.out.println("OUTPUT: " + number);
        return number;
    }


    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int [][] newMatrix = new int[r][c];
        if(nums.length == 0 || r*c != nums.length*nums[0].length){
            return nums;
        }
        int rows = 0, cols = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[0].length;j++) {
                newMatrix[rows][cols] = nums[i][j];
                cols++;
                if(cols==c){
                    rows++;
                    cols=0;
                }
            }
        }
        return newMatrix;
    }

    public static boolean isPalindrome(CharSequence s){
        for(int i=0;i< s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i=0;i<stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            stringBuilder.deleteCharAt(i);
            if (isPalindrome(stringBuilder)) {
                return true;
            }
            stringBuilder.insert(i, c);
        }
        return isPalindrome(s);
    }

    public static class ListNode {
         int val;
          ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p=head;

        ListNode p1=l1;
        ListNode p2=l2;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p=p.next;
        }

        if(p1!=null){
            p.next = p1;
        }

        if(p2!=null){
            p.next = p2;
        }

        return head.next;

    }

}
