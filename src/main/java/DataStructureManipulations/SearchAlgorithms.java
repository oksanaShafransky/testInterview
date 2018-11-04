package DataStructureManipulations;

public class SearchAlgorithms {

    public static void main(String a[]) {
        //linear search
        int [] arr1 = {5,6,2,8,12,1,3,44,21};
        int elementToFind = 44;
        int index = search(arr1, arr1.length, elementToFind);
        System.out.println("Linear search found element " + elementToFind + " at index " + search(arr1, arr1.length, elementToFind));

        //binary search
        int [] arr2 = {5,6,8,12,14,23,44,61,93};
        elementToFind = 61;
        System.out.println("Binary search found element " + elementToFind + " at index " + binarySearch(arr2, 0, arr2.length, elementToFind));
        System.out.println("Ternary search found element " + elementToFind + " at index " + ternarySearch(arr2, 0, arr2.length, elementToFind));

    }

    //Linear search - O(n)
    // Java code for linearly search x in arr[].  If x
    // is present  then return its  location,  otherwise
    // return -1
    // This function returns index of element x in arr[]
    static int search(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    //Binary search - O(Log n) - for SORTED ARRAY
    // A recursive binary search function. It returns location of x in
    // given array arr[l..r] is present, otherwise -1
    public static int binarySearch(int [] array, int low, int high, int element){
        if(low<high) {
            int mid = (low + high) / 2;
            if(array[mid] == element){
                return mid;
            }
            if(array[mid] > element){
                return binarySearch(array, low, mid, element);
            }
            else if(array[mid] < element){
                return binarySearch(array, mid +1, high, element);
            }
        }
        return -1;
    }

    //Ternary search - O(Log3n)
    // A recursive ternary search function. It returns location of x in
    // given array arr[l..r] is present, otherwise -1
    public static int ternarySearch(int [] array, int low, int high, int element){
        if(low<high) {
            int mid1 = low + (high - low)/3;
            int mid2 = mid1 + (high - low)/3;
            if(array[mid1] == element){
                return mid1;
            }
            if(array[mid2] == element){
                return mid2;
            }

            if(array[mid1] > element){
                return binarySearch(array, low, mid1, element);
            }
            else if(array[mid2] < element){
                return binarySearch(array, mid2 +1, high, element);
            }
            return binarySearch(array, mid1, mid2, element);
        }
        return -1;
    }

    //Jump search - SORTED ARRAYS
    //Time Complexity : O(√n)
    //Auxiliary Space : O(1)
    public static void jumpSearch(int [] array){

    }

    //Interpolation search - SORTED ARRAYS with values uniformly distributed
    //Time Complexity : O (log log n))
    //Auxiliary Space : O(1)
    public static void interpolationSearch(int [] array){

    }

    //Exponential search - SORTED ARRAYS
    //Time Complexity : O (log n))
    //Auxiliary Space : O(Log n)
    //Steps: 1. Find range where element is present
    //       2. Do Binary Search in above found range.
    public static void exponentialSearch(int [] array){

    }

    //Fibonachi search - SORTED ARRAYS
    //Time Complexity : O (log n))
    public static void fibonachiSearch(int [] array){

    }

    //Sublist Search (Search a linked list in another list)
    //Time Complexity : O(m*n) where m is the number of nodes in second list and n in first
    /*
    Algorithm:
    1- Take first node of second list.
    2- Start matching the first list from this first node.
    3- If whole lists match return true.
    4- Else break and take first list to the first node again.
    5- And take second list to its second node.
    6- Repeat these steps until any of linked lists becomes empty.
    7- If first list becomes empty then list found else not.
    SEE LIST MANIPULATION
    public static void sublistSearch(Node head1, Node head2){

    }*/
}
