/**
 * This program counts the occurrence of a number in a sorted array - O(log N)
 * @author raju rama krishna
 *
 */
public class OccuranceCountSorted {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = new int[] {1, 3, 4, 6, 9, 10, 11, 14, 15, 16, 17, 18, 20, 22, 23, 27, 27, 27, 27, 27, 27, 28, 29, 33, 33, 41, 49, 55};
        int h = a.length-1;
        int res1 = count( a, 27, 0, h);
        System.out.println("result="+res1);
        int res2 = search( a, 27, 0, h);
        System.out.println("result="+res2);
    }

    /**
     * Using method1
     * @param a
     * @param key
     * @param l
     * @param h
     * @return
     */
    private static int count( int[] a, int key, int l, int h ) {
        System.out.println("call between " +a[l] + " and " +a[h]);
        if( l < h ) {
            if(a[l] == key && a[h] == key)
                return (h-l)+1;

            int m = (l+h)/2;
            if( key < a[m] )
                return count( a, key, l, m);
            else if( key > a[m] )
                return count( a, key, m+1, h);
            else {
                return count( a, key, l, m ) + count( a, key, m+1, h);
            }
        } else {
            if(a[l] == key)
                return 1;
            else
                return 0;
        }
    }

    /**
     * Using method2
     * @param a
     * @param key
     * @param l
     * @param h
     * @return
     */
    private static int search( int[] a, int key, int l, int h ) {
        System.out.println("call between " +a[l] + " and " +a[h]);
        int m = (l+h)/2;
        if( key < a[m] ) {
            return search( a, key, l, m);
        } else if( key > a[m]) {
            return search( a, key, m+1, h);
        } else {
            int i = m-1;
            int count = 1;
            while(a[i] == key ) {
                i--;
                count++;
            }
            i = m+1;
            while( a[i] == key ) {
                i++;
                count++;
            }
            return count;
        }
    }

}