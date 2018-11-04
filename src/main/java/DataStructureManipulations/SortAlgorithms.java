package DataStructureManipulations;

public class SortAlgorithms {
    public static void main(String a[]) {
        int [] array = {4,2,3,6,8,1};
        selectionSort(array);
        printArray("selectionSort", array);

        int [] array2 = {4,2,3,6,8,1};
        boubleSort(array2);
        printArray("boubleSort   ", array2);

        int [] array3 = {4,2,3,6,8,1};
        insertionSort(array3);
        printArray("insertionSort", array3);

        int [] array4 = {4,2,3,6,8,1,15,7,2};
        //mergeSort(array4, 0 , array4.length-1);
        //printArray("mergeSort  ", array4);

        int [] array5 = {4,2,3,6,8,1,15,7,2};
        quickSort(array5, 0 , array5.length-1);
        printArray("quickSort    ", array5);
    }

    private static void printArray(String str, int[] array4) {
        System.out.printf("\nPrinting array for " + str + ": ");
        for (int i=0;i< array4.length; i++) {
            System.out.printf(" [" + array4[i] + "] ");
        }
    }

    //Time Complexity: O(n^2) as there are two nested loops.
    //Auxiliary Space: O(1)
    //Selection Sort	Ω(n^2)	θ(n^2)	O(n^2)
    public static int [] selectionSort(int [] array){
        int min;
        for(int i=0; i< array.length-1;i++) {
            min = i;
            // Find the minimum element in unsorted array
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    min = j;
                }
            }
            //swap
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //Time Complexity: O(n^2)
    //Bubble Sort	Ω(n)	θ(n^2)	O(n^2)
    public static int [] boubleSort(int [] array){
        for(int i=0; i< array.length-1;i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    //swap
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    //Time Complexity: O(n*2)
    //Auxiliary Space: O(1)
    //Insertion Sort	Ω(n)	θ(n^2)	O(n^2)
    public static int [] insertionSort(int [] array) {
        for(int i=1; i< array.length;i++) {
            int key = array[i];
            int j = i-1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while(j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }


    /*
    MergeSort(arr[], l,  r)
    If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
     */
    //Merge Sort	Ω(n log(n))	θ(n log(n))	O(n log(n))
    public static void mergeSort(int [] array, int low, int high){
        if(low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            mergeArrays(array, low, middle, high);
        }
    }

    private static void mergeArrays(int [] arr, int low, int middle, int high) {
        //find size for 2 arrays
        int n1 = middle - low + 1;
        int n2 = high - middle;
        int [] lowArray = new int[n1];
        int [] highArray = new int[n2];

        //copy data to temp arrays
        for(int i=0;i<n1;i++){
            lowArray[i] = arr[low+i];
        }
        for(int j=0;j<n1;j++){
            highArray[j] = arr[middle+1+j];
        }
        //merge the temp arrays
        int i=0, j=0;
        int k = low;
        while(i<n1 && j<n2){
            if(lowArray[i]<=highArray[j]){
                arr[k] = lowArray[i];
                i++;
            } else {
                arr[k] = highArray[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of lowArray
        while(i<n1){
            arr[k] = lowArray[i];
            i++;
            k++;
        }
        //copy remaining elements of highArray
        while(i<n2){
            arr[k] = highArray[j];
            j++;
            k++;
        }
    }

    //Heap Sort	Ω(n log(n))	θ(n log(n))	O(n log(n))
    public static void heapSort(int [] array){


    }

    //Bucket Sort	Ω(n+k)	θ(n+k)	O(n^2)
    /*bucketSort(arr[], n)
    1) Create n empty buckets (Or lists).
    2) Do following for every array element arr[i].
    .......a) Insert arr[i] into bucket[n*array[i]]
    3) Sort individual buckets using insertion sort.
    4) Concatenate all sorted buckets.*/
    public static void bucketSort(int [] array){


    }

    //Radix Sort	Ω(nk)	θ(nk)	O(nk)
    public static void radixSort(int [] array){


    }


    ///////////////////////////recursive////
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    public static void quickSort(int [] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int partition(int [] arr, int low, int high){
        int pivot = arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //swap arr[i+1] and arr[high]/pivot
        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }


    ///////////////////////////iteretive////

    public static void quickSortIterative(int [] array){

    }

    /* This function takes last element as pivot,
   places the pivot element at its correct
   position in sorted array, and places all
   smaller (smaller than pivot) to left of
   pivot and all greater elements to right
   of pivot */
    public static int partitionIterative(int [] arr){
        int pivot = arr[arr.length-1];

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=pivot){

            }
        }

        return 0;
    }

    /*
    perm_identity
    Dual pivot Quicksort
    Quick Sort for Doubly Linked List
    Quick Sort for Singly Linked List
    Merge Sort for Singly Linked List
    Merge Sort for Doubly Linked List
    Cycle Sort - best suited for situations where memory write or swap operations are costly.
     */
}
