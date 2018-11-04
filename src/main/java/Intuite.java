import java.util.*;

public class Intuite {
    public static void main(String a[]){
        Node node1 = new Node(6);
        Node node2 = new Node(7);
        node1.next = node2;
        Node node3 = new Node(9);
        node2.next = node3;
        Node node4 = new Node(10);
        node3.next = node4;
        Node node5 = new Node(16);
        node4.next = node5;
        Node node10 = new Node(1);
        node5.next = node10;
        Node node20 = new Node(8);
        node10.next = node20;
        Node node30 = new Node(12);
        node20.next = node30;
        Node newNode = removeElementFromList(node1, 6);
        System.out.printf("\nPrint list: ");
        while (newNode != null){
            System.out.printf(" [" + newNode.val + "]->");
            newNode= newNode.next;
        }

        int [] arr = {3,2,5,6,1,7,4,2,3};
        int [] newArray = multiplyEveryElement(arr, 4);
        System.out.printf("\nMultiply elements int array exept one: ");
        for(int i=0;i<newArray.length;i++){
            System.out.printf(" [" + newArray[i] + "] ");
        }

        int [] arr2 = {1,0,1,0,1,0,0,1,1,0,1,0};
        orderArray(arr2);
        System.out.printf("\nORDER ARRAY: ");
        for(int i=0;i<arr2.length;i++){
            System.out.printf(" [" + arr2[i] + "] ");
        }

        System.out.printf("\n");
        Integer [] arr3 = {5,6,1,40,4,3,7,12,2,0,8,15};
        calcPlusMinusNumOfWays(arr3, 10);
        //System.out.printf("\nNUMBER OF WAYS: " + n);

        int [] arr4 = {1,2,3,9};
        int [] arr5 = {1,2,4,4};

        System.out.printf("\nisSumInsideArray: " + isSumInsideArray(arr4,8));
        System.out.printf("\nisSumInsideArray: " + isSumInsideArray(arr5, 8));
        System.out.printf("\nisSumInsideArray: " + isSumInsideArray(arr4, 10));
        System.out.printf("\nisSumInsideArray: " + isSumInsideArray(arr5, 5));

        int [] arr6 = {9,5,9};
        int [] newarr = addOne(arr6);
        System.out.printf("\naddOne: ");
        for(int i=0;i<newarr.length;i++){
            System.out.printf(" [" + newarr[i] + "] ");
        }

        char [] chrs = {'a','b','c','e','d','f','a'};
        char c = recurringChar(chrs);
        System.out.printf("\nRecuring char is = " + c);

        int [] subset = {2,3,1};
        System.out.printf("\nGet all subsets:");
        getAllSubsets(subset);

        int [] sums = {4,3,2,5,8,1};
        int n = allPossibleSumSubset(sums, 5);
        System.out.printf("\nAll possible sum of array: " + n);
    }



    public static void getAllSubsets(int [] arr){
        int [] subset = new int[arr.length];
        allPossibleSubsetsHelper(arr, subset, 0);
    }

    public static void allPossibleSubsetsHelper(int [] arr, int [] subset, int index){
        if(index==arr.length){
            System.out.printf("\nSubset = " );
            for(int i=0;i<subset.length;i++){
                System.out.printf(" [" + subset[i] + "] ");
            }
        } else {
            subset[index]=0;
            allPossibleSubsetsHelper(arr, subset, index+1);
            subset[index]=arr[index];
            allPossibleSubsetsHelper(arr, subset, index+1);
        }
    }

    public static int allPossibleSumSubset(int [] arr, int sum){
        HashSet<String> memo = new HashSet<String>();
        return allPossibleSumSubsetHelper(arr, sum, arr.length-1);
    }

    public static Integer allPossibleSumSubsetHelper(int [] arr, int sum, int index){
        if(sum==0){
            return 1;
        } else if(index<0 || sum<0){
            return 0;
        } else if(sum<arr[index]){
            return allPossibleSumSubsetHelper(arr, sum, index-1);
        } else {
            return allPossibleSumSubsetHelper(arr, sum - arr[index], index-1) +
                    allPossibleSumSubsetHelper(arr, sum, index-1);
        }
    }

    public static int [] addOne(int [] arr){
        int [] newArray = new int [arr.length];
        int carry = 1;
        for(int i = arr.length-1;i>=0;i--){
            int res = arr[i] + carry;
            if(res==10){
                carry=1;
            } else {
                carry = 0;
            }
            newArray[i] = res%10;
        }
        if(carry==1){
            newArray = new int [arr.length+1];
            newArray[0]=1;
        }
        return newArray;
    }


    public static String encode(String str){
        StringBuffer buf = new StringBuffer();
        for(int i =0; i< str.length();i++) {
            int c = Character.getNumericValue(str.charAt(i));
            buf.append(c);
        }
        System.out.printf("String " + str + " encoded to: " + buf.toString());
        return buf.toString();
    }

    public static String decode(String str){
        StringBuffer buf = new StringBuffer();
        for(int i =0; i< str.length();i++) {
            char c = Character.valueOf(str.charAt(i));
            buf.append(c);
        }
        System.out.printf("String " + str + " decoded to: " + buf.toString());
        return buf.toString();
    }

    public static String regexStr(String str){

        return null;
    }

    public static Node removeElementFromList(Node node, int val){
        if(node != null && node.next !=null){
            Node prev = node;
            Node current = node;
            if(current.val == val){
                current = current.next;
                return current;
            }
            while(current!=null){
                if(current.val == val){
                    current = current.next;
                    prev.next = current;
                    return current;
                }
                prev = current;
                current = current.next;
            }
        }
        return node;
    }

    static class Node {
        int val;
        Node next;

        public Node( int val ) {
            this.val = val;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    //Unsorted - O(N)
    //BST - sorted: O(logn)
    public static int getMaxValueOfUnsortedTree(){

        return -1;
    }

    public static int [] multiplyEveryElement(int [] arr, int num){
        int arr1Length = num;
        int arr2Length = arr.length - arr1Length -1;
        int [] arr1 = new int [arr1Length];
        int [] arr2 = new int [arr2Length];

        int res1 = 1, res2 = 1;
        for(int i=0;i<arr1Length;i++){
            res1 = res1*arr[i];
            arr1[i] = res1;
        }
        for(int j =0;j<arr2Length;j++){
            res2 = arr[j]*res2;
            arr2[j] = res2;
        }
        int [] newArray = new int[arr.length];
        int s = 0;
        for(int k =0;k<arr.length;k++){
            if(k!=num) {
                if(k<arr1Length) {
                    newArray[k] = arr1[k];
                } else if(k>arr2Length){
                    newArray[k] = arr2[s];
                    s++;
                }
            }
        }
        return newArray;
    }

    //O(n)
    public static void orderArray(int [] arr){
        int j = arr.length-1;
        int count = 0;
        for(int i=0;i<j;i++){
            if(arr[i] == 0 && arr[j]==1){
                arr[i] = 1;
                arr[j]=0;
                j--;
            } else if(arr[j]==0){
                j--;
            }
            if(arr[i]==0){
                i--;
            }
            count++;
        }
        System.out.printf("\nOrder Array iteration = " + count);
    }

    //O(2^n)
    public static void calcPlusMinusNumOfWays(Integer [] arr, int target){
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.addAll(Arrays.asList(arr));
        calcPlusMinusNumOfWaysHelper(arr2, target, new ArrayList<Integer>());
    }

    public static void calcPlusMinusNumOfWaysHelper(ArrayList<Integer> arr, int target, ArrayList<Integer> partial){
        int s = 0;
        for (int x: partial) {
            s += x;
        }
        if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
        if (s >= target)
            return;

        for(int i=0;i<arr.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = arr.get(i);
            for (int j=i+1; j<arr.size();j++){
                remaining.add(arr.get(j));
            }
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            calcPlusMinusNumOfWaysHelper(remaining,target,partial_rec);
        }
    }

    public static char recurringChar(char [] chars){
        char rec = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<chars.length;i++){
            if(set.contains(chars[i])){
                return chars[i];
            }
            set.add(chars[i]);
        }
        return rec;
    }

    public static boolean isSumInsideArray(int [] arr, int sum){
        Set<Integer> vec = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(vec.contains(arr[i])){
                return true;
            }
            else {
                vec.add(sum - arr[i]);
            }
        }

        return false;
    }

}
