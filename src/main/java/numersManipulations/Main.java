package numersManipulations;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //2 sums
        int [] arrForSum = {2,5,5,11};
        int [] res = twoSum(arrForSum, 10);
        System.out.println("Location of 2 numbers in list is: [" + res[0] + "][" + res[1]+"]");

        //form largest num
        List<Integer> numList = Arrays.asList(2, 35, 23, 6, 8, 97, 81);
        formLargestNum(numList);

        //remove duplicates
        int [] arr = {3,5,1,1,1,1,3,3,5,4,4,7,7,8};
        System.out.println("NO_DUPLICATES_ARRAY: " + Arrays.toString(removeDuplicates(arr)));

        //min max num matrix
        int [][] matrix = {{1,333,1,3,122,4,2},{13300,12,8,1004, 6,-1,555},{8,12,-5,8765,-999,0},{1,0,15,-2004}};
        minMaxMatrixNumber(matrix);
        minMaxArrayNumber(matrix[0]);
        maxFirstAndSecondArrayNumber(matrix[0]);
        minFirstAndSecondArrayNumber(matrix[0]);

        //print dividers of n
        int n = 25;
        System.out.println("The divisors of " + n + " are: ");
        printDivisors(n);

        //is perfect square of n
        System.out.println("\nIs 33 Perfect Square: "+isPerfectSquare(33));

        //binary search
        System.out.println("\nBinary search for 101: " + binarySearch(1,25/2, 101));


        //get fibonachi
        getFibonachiFOrNumber(10);

        //prime numbers
        printAllPrimeNumbers(100);

        //swap 2 numbers without temp
        swapTwoNumbers(77, 23);

        //calc factorial
        int number = 5;
        System.out.println("\nfactorial of " + number + " = " + factorial(number));

        //reverse number
        number = 1234;
        System.out.println("\nreversed number " + number + " = " + reverse(number));

        //is palindrome number
        number = 1234321;
        System.out.println("\nis number " + number + " is palindrome: " + isPalindrome(number));

        //is palindrome str
        String str = "1234321";
        System.out.println("\nis str " + str + " is palindrome: " + isPalindromeStr(str));
        str = "palinnilap";
        System.out.println("\nis str " + str + " is palindrome: " + isPalindromeStr(str));
        str = "123pukpupkup321";
        System.out.println("\nis str " + str + " is palindrome: " + isPalindromeStr(str));

        //buble sort
        int [] bubleSortArray = {55,33,77,11,0,1,5,3};
        bubbleSort(bubleSortArray);

        String [] bubleSortArrayStr = {"hh","","hat","trs","av", "ab"};
        bubbleSortStr(bubleSortArrayStr);



    }

    private static void formLargestNum(List<Integer> numList) {
        Collections.sort(numList, new Comparator<Integer>() {

            @Override
            public int compare(Integer num1, Integer num2) {
                String a = num1.toString() + num2.toString();
                String b = num2.toString() + num1.toString();
                return b.compareTo(a);
            }
        });
        // Displaying number
        System.out.print("=====Largest number is: ");
        for(Integer i : numList){
            System.out.print(i);
        }
        System.out.println("=====");
    }

    static void printDivisors(int n)
    {
        // Note that this loop runs till square root
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i)
                    System.out.printf("%d ", i);

                else // Otherwise print both
                    System.out.printf("%d %d ", i, n/i);
            }
        }
    }

    public static boolean isPerfectSquare(long target)
    {
        long result;
        long perfSquare = target / 2;
        do{
            result = perfSquare * perfSquare;
            if (result == target)
                return true;
            else if (target < result)
                perfSquare = perfSquare - 1;
            else
                perfSquare = perfSquare / 2;
        }while(target<result);
        return false;
    }

    public static boolean binarySearch(long start,long end,long original)
    {
        long mid = (start + end) / 2;
        if (original == 1)
            return true;
        if (mid * mid == original) { return true; }
        if (start >= end)
            return false;
        if (mid * mid < original)
            return binarySearch(mid + 1, end, original);
        else
            return binarySearch(start, mid - 1, original);


    }

    static void getFibonachiFOrNumber(long count) {
        long n1=0,n2=1;
        System.out.println("\nFibonachi series: ");
        for(int i=1;i<=count;i++) {
            System.out.print(printFibonacci(i) + " ");
        }
    }

    static int printFibonacci(int count){
        if(count<=1) return count;

        else return printFibonacci(count-1) + printFibonacci(count -2);

    }

    public static void printAllPrimeNumbers(int number) {
        for(int i = 1; i<= number; i++) {
            boolean isPrime = isPrimeNumber(i);
            if(isPrime)
                System.out.println("\nNumber " + i + " is prime number");
        }
    }

    public static boolean isPrimeNumber(int number) {
        for(int i = 2; i < number; i++){
            if(number%i == 0)
                return false;
        }
        return true;
    }

    public static void swapTwoNumbers(int a, int b){
        System.out.println("1. Before swap a= " + a + " b=" + b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("1. After swap a= " + a + " b=" + b);

        System.out.println("2. Before swap a= " + a + " b=" + b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("2. After swap a= " + a + " b=" + b);

        System.out.println("3. Before swap a= " + a + " b=" + b);
        a = a*b;
        b = a/b;
        a = a/b;
        System.out.println("3. After swap a= " + a + " b=" + b);
    }


    public static int factorial(int number){
        int result = 1;
        while(number != 0){
            result = result*number;
            number--;
        }

        return result;
    }

    /*
     * reverse a number in Java using iteration
     * @return reverse of number
     */
    public static int reverse(int number){
        int reverse = 0;
        int remainder = 0;
        do{
            remainder = number%10;
            reverse = reverse*10 + remainder;
            number = number/10;

        }while(number > 0);

        return reverse;
    }

    public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        if (number == reverse) {
            return true;
        }
        return false;
    }

    public static boolean isPalindromeStr(String str) {
        char [] palindrome = str.toCharArray();
        int j = palindrome.length - 1;
        int i = 0;
        while(i<j) {
            if(palindrome[i]!=palindrome[j])
                return false;
            j--;
            i++;
        }
        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }


    public static void bubbleSort(int[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));

        // Outer loop - need n-1 iteration to sort n elements
        for(int i=0; i<unsorted.length -1; i++){

            //Inner loop to perform comparision and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<unsorted.length -i; j++){

                //If current number is greater than swap those two
                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
        }
    }

    public static void bubbleSortStr(String[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));

        // Outer loop - need n-1 iteration to sort n elements
        for(int i=0; i<unsorted.length -1; i++){

            //Inner loop to perform comparision and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<unsorted.length -i; j++){

                //If current number is greater than swap those two
                if(unsorted[j-1].compareTo(unsorted[j]) > 1){
                    String temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
        }
    }

    public static int[] removeDuplicates(int [] arr){
        int i = 1;
        int j = 0;
        Arrays.sort(arr);
        while (i < arr.length) {
            if (arr[i] == arr[j]) {
                i++;
            } else {
                arr[++j] = arr[i++];
            }
        }

        return Arrays.copyOf(arr, j+1);
    }

    public static void minMaxMatrixNumber(int [][] matrix) {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for(int i=0; i<matrix.length;i++){
            for(int j=0; j< matrix[i].length; j++) {
                if(matrix[i][j]>max) {
                    max= matrix[i][j];
                } else if(matrix[i][j]<min){
                    min = matrix[i][j];
                }
            }
        }
        System.out.println("Matrix Largest number:  "
                + max + " Smallest number: " + min);
    }

    public static void minMaxArrayNumber(int [] matrix) {
        int min = matrix[0];
        int max = 0;
        int secondMax = 0;
        int secondMin = 0;
        System.out.println("Array = " + Arrays.toString(matrix));

        for(int i=0; i<matrix.length;i++){
                if(matrix[i]>max) {
                    secondMax = max;
                    max= matrix[i];
                } else if(matrix[i]<min){
                    secondMin = min;
                    min = matrix[i];
                } else if(matrix[i]>secondMax) {
                    secondMax = matrix[i];
                } else if(matrix[i]>min && matrix[i]<matrix[i-1]){
                    secondMin=matrix[i];
                }
        }
        System.out.println("Array Largest number:  "
                + max + " Smallest number: " + min);
        System.out.println("Array Second Largest number:  "
                + secondMax + " Second Smallest number: " + secondMin);
    }

    public static void maxFirstAndSecondArrayNumber(int [] matrix) {
        int max = 0;
        int secondMax = 0;
        System.out.println("Array = " + Arrays.toString(matrix));

        for(int i=0; i<matrix.length;i++){
            if(matrix[i]>max) {
                secondMax = max;
                max = matrix[i];
            } else if(matrix[i]>secondMax) {
                secondMax = matrix[i];
            }
        }
        System.out.println("Array Largest number:  "
                + max);
        System.out.println("Array Second Largest number:  "
                + secondMax);
    }

    public static void minFirstAndSecondArrayNumber(int [] matrix) {
        int min = matrix[0];
        int secondMin = 0;
        System.out.println("Array = " + Arrays.toString(matrix));

        for(int i=0; i<matrix.length;i++){
            if(matrix[i]<min){
                secondMin = min;
                min = matrix[i];
            } else if(matrix[i]>min && matrix[i]<matrix[i-1]){
                secondMin = matrix[i];
            }
        }
        System.out.println("Array Smallest number: " + min);
        System.out.println("Array Second Smallest number: " + secondMin);
    }
}
