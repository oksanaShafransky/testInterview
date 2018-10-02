import java.util.ArrayList;

public class WhiteBlackSquare {

    //binary search - O(logN)

    public static void main(String a[]) {
        int[] square = {0,0,0,0,1,1,1,1,1,1};
        findMidLine(square);
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

}
