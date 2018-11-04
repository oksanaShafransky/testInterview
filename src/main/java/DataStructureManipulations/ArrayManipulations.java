package DataStructureManipulations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

//TODO
//Find duplicates in O(n) time and O(1) extra space
//Find the minimum distance between two numbers
//Find closest number in array
//Find k closest elements to a given value
//Find common elements in three sorted arrays
//Find the closest pair from two sorted arrays
//Given an array of of size n and a number k, find all elements that appear more than n/k times
//Median of two sorted arrays of same size
//Search an element in a sorted and rotated array
//Find the minimum element in a sorted and rotated array
//LRU Cache Implementation
//How to implement LRU caching scheme? What data structures should be used?

public class ArrayManipulations {

    public static void main(String[] args) throws Exception {
        int [] arr1 = {2,4,5,6,8,9,12};
        int [] arr2 = {1,5,6,7,8,10,12};
        int [] arr3 = findUnionForSortedArrays(arr1, arr2);
        System.out.printf("\nArray union: ");
        for(int i=0;i<arr3.length;i++){
            System.out.printf(" [" + arr3[i] + "] ");
        }

        int [] arr4 = findIntersectionForSortedArrays(arr1, arr2);
        System.out.printf("\nArray intersection: ");
        for(int i=0;i<arr4.length;i++){
            System.out.printf(" [" + arr4[i] + "] ");
        }

        int [] array = {5, 6, 7, 5, 15, 42, 10, 3};

        System.out.println("\n" + 4 + "th largest array number is " + findNthLargest(array, 4));

        int n = numOfWayToGetSum(array, 10);

        //order array to be 1 first
        int [] array1 = {1,1,0,0,0,1,0,1,0,1,1};
        array1=orderArray(array1);
        System.out.printf("\nOrder array with 1: ");
        for(int i=0;i<array1.length;i++){
            System.out.printf(" [" + array1[i] + "] ");
        }
        int [] array2=orderArray2(array1);
        System.out.printf("\nOrder array2 with 1: ");
        for(int i=0;i<array2.length;i++){
            System.out.printf(" [" + array2[i] + "] ");
        }

        int [] array3=orderArray3(array1);
        System.out.printf("\nOrder array3 with 1: ");
        for(int i=0;i<array3.length;i++){
            System.out.printf(" [" + array3[i] + "] ");
        }
    }

    public static int numOfWayToGetSum(int [] array, int sum) {
        int count = 0;
        for(int i=0;i< array.length-1;i++){
            for(int j=1;j<array.length; j++) {
                if (array[i] + array[j] == sum || array[i] - array[j] == sum || array[j] - array[i] == sum) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] orderArray(int [] array) {
        int [] temp = new int [array.length];
        int currentLocation = 0;
        int numOfIteration = 0;
        for(int i=0;i<array.length;i++){
            numOfIteration++;
            if(array[i]==1){
                temp[currentLocation] = 1;
                currentLocation++;
            }
        }
        System.out.println("\nnum of iteration orderArray = " + numOfIteration);
        return temp;
    }


    public static int findNthLargest(int [] array, int k){
        int [] sorted = new int[k];
        for(int i=0;i<array.length;i++){

        }
        return array[k-1];
    }

    public static int [] findUnionForSortedArrays(int [] arr1, int [] arr2){
        int [] arr3 = new int [arr1.length + arr2.length];
        int i=0, j=0, k = 0;
        while(i< arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                arr3[k] = arr1[i];
                i++;
                j++;
            } else if(arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<arr1.length){
            arr3[k] = arr1[i];
            k++;
        }
        while(j<arr2.length){
            arr3[k] = arr2[j];
            k++;
        }

        return Arrays.copyOf(arr3, k);
    }

    public static int [] findIntersectionForSortedArrays(int [] arr1, int [] arr2){
        int [] arr3 = new int [arr1.length>arr2.length?arr1.length:arr2.length];
        int k = 0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    arr3[k] = arr1[i];
                    k++;
                }
            }
        }
        return Arrays.copyOf(arr3, k);
    }

    public static int[] orderArray2(int [] array) {
        int [] temp = new int [array.length];
        int currentLocation = 0;
        int count = array.length-1;
        int numOfIteration = 0;
        for(int i=0;i<=(array.length-1)/2;i++){
            numOfIteration++;
            if(array[i]==1){
                temp[currentLocation] = 1;
                currentLocation++;
            }
            if(array[count]==1){
                temp[currentLocation] = 1;
                currentLocation++;
            }
            count--;
        }
        System.out.println("\nnum of iteration orderArray2 = " + numOfIteration);
        return temp;
    }

    public static int[] orderArray3(int [] array) {
        int count = array.length-1;
        int i = 0;
        int numOfIteration = 0;
        while(i<count) {
        //for(int i=0;i<=(array.length-1)/2;i++){
            numOfIteration++;
            if(array[i]==0 && array[count]==1){
                array[i]=1;
                array[count]=0;
            }
            i++;
            count--;
        }
        System.out.println("\nnum of iteration orderArray2 = " + numOfIteration);
        return array;
    }
}
