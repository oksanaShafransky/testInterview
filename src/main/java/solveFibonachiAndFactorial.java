import java.util.LinkedList;
import java.util.List;

public class solveFibonachiAndFactorial {

    public static void main(String a[]) {
        //multiply all elements in array without current
        int array[] = {6,7,1,8,3,6,5};
        array = multiplyAllElementsInArray(array);
        System.out.printf("Multiply array: ");
        for(int i=0;i<array.length;i++) {
            System.out.printf(" [" + array[i] + "] ");
        }

        int array2[] = {6,7,1,8,3,6,5};
        array2 = multiplyAllElementsInArray2(array2);
        System.out.printf("\nMultiply array: ");
        for(int i=0;i<array2.length;i++) {
            System.out.printf(" [" + array2[i] + "] ");
        }

        //fibonachi - sum all 2 previous elements
        int n = 5;
        System.out.printf("\nFibonachi serie for " + n + ": ");
        for(int i=1;i<=n;i++) {
            System.out.printf(" " + fibonachi(i));
        }
        linearFibonachi(n);


        //replace char to another
        String str = "\nhello world, i am a java program, how are you today?";
        char from = 'a';
        char to = '/';
        System.out.println("replaceChar: " + replaceChar(str, from, to));
        System.out.println("replace recursively: " + replaceCharRecursively(str, from, to));

        //factorial - multiply all elements
        System.out.println("linear factorial for " + n + ": " + factorialLinear(n));
        System.out.println("recursive factorial for " + n + ": " + factorialRecursive(n));
    }

    public static String replaceChar(String str, char from, char to){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==from){
                sb.append(to);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String replaceCharRecursively(String str, char from, char to){
        if(str.length()<1){
            return str;
        } else {
            char first = str.charAt(0)==from?to:str.charAt(0);
            return first + replaceCharRecursively(str.substring(1), from, to);
        }

    }

    //plus of 2 prev
    public static int fibonachi(int num){
        if(num<=1) return num;
        else {
            return fibonachi(num - 2) + fibonachi(num - 1);
        }
    }

    public static void linearFibonachi(int num){
        System.out.printf("\nLinear fibonachi serie for " + num + ": ");
        if(num<=1){
            return;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i=0;i<num;i++){
            sum = a + b;
            a=b;
            b = sum;
            System.out.printf(sum + " ");
        }
    }

    //multiplication of all prev
    public static int factorialRecursive(int num){
        if(num==0){
            return 1;
        } else {
            return num * factorialRecursive(num-1);
        }
    }

    public static int factorialLinear(int num){
        if(num==0){
            return 0;
        }
        if(num==1){
            return 1;
        }
        int res = num;
        for(int i=num-1;i>0;i--){
            res = res*i;
        }
        return res;
    }

    //O(n^2)
    public static int[] multiplyAllElementsInArray(int [] array) {
        int [] tempArray = new int [array.length];
        for(int i=0; i < array.length; i++) {
            int res1 = 1;
            int res2 = 1;
            int res3 = 1;
            for(int w = 0; w<i; w++) {
                res3 = array[w] * res3;
            }
            for(int j=(array.length - 1); j>i; j--) {
                   res2 = array[j]*res2;
            }
            if(i>0) {
                res1 = res3 * res2;
            } else {
                res1 = res2;
            }
            tempArray[i] = res1;
        }
        return tempArray;
    }

    //O(2N)
    public static int[] multiplyAllElementsInArray2(int [] array) {
        int [] tempArray = new int [array.length];
        int [] tempArray1 = new int [array.length];
        int [] tempArray2 = new int [array.length];
        int res1 = 1, res2 = 1, j=array.length-1;
        for(int i=0; i < array.length; i++) {
            res1 = res1*array[i];
            tempArray1[i]= res1;
            res2 = res2*array[j];
            tempArray2[j] = res2;
            j--;
        }

        for(int k=0;k<array.length;k++){
            int left =1, right = 1;
            if(k-1>=0) {
                left = tempArray1[k - 1];
            }
            if(k+1<=array.length-1){
                right = tempArray2[k + 1];
            }
            tempArray[k]=left*right;
        }
        return tempArray;
    }

}
