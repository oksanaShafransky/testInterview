public class LongestIncreasingSequence {

    public static void main(String a[]){
        int [] seq = {1, 5, 3, 4, 6, 1, 2, 4, 8, 5 };
        findLongestSeq(seq);

    }

    public static void findLongestSeq(int [] seq){
        int[] b = new int[seq.length];
        int[] c = new int[seq.length];
        b[0] = seq[0];
        int maxlen = 1;
        int len = 1;
        for(int i=0;i<seq.length;i++){
            if(seq[i] > b[len-1]){
                b[len++] = seq[i];
            } else {
                if(len >maxlen) {
                    maxlen = len;
                    c = b;
                    b = new int[seq.length];
                    len=1;
                    b[0] = seq[i];
                } else {
                    b= new int[seq.length];
                    len=1;
                    b[0]=seq[i];
                }
            }
        }

        if(len > maxlen) {
            c = b;
        }

        System.out.println("Longest Increasing Subsequence is of length :" +maxlen);
        for( int i = 0; i < maxlen; i++ ) {
            if( i == 0 ) {
                System.out.print("{" +c[i]+ ",");
            } else if( i == maxlen-1) {
                System.out.print( c[i] + "}");
            } else {
                System.out.print( c[i] + ",");
            }
        }

    }
}
