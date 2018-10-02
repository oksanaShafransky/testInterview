package stringOperations;

import java.util.LinkedList;

public class reverseStringByWorlds {
    static MyLinkedList myLinkedList = new MyLinkedList();

    public static void main(String[] args) {
        final LinkedList<String> linkedlist = new LinkedList<String>();
        linkedlist.add("one");
        linkedlist.add("two");
        linkedlist.add("tree");
        linkedlist.add("four");
        linkedlist.add("five");

        System.out.println("Hello World!");
        System.out.println(reverseStringByWorlds("Hello my dear baby!"));
        reverseLinkedListNotRecursive(linkedlist).forEach(elem -> System.out.println(elem));
        System.out.printf("=======\n");
        myLinkedList.add("one");
        myLinkedList.add("two");
        myLinkedList.add("tree");
        myLinkedList.add("four");
        myLinkedList.add("five");
        myLinkedList.add("six");
        boolean isCyclic= isCyclic(myLinkedList.head);
        System.out.printf("=======The list isCyclic = " + isCyclic + "\n");
        System.out.printf(myLinkedList.toString());
        //myLinkedList.reverseList();
        //System.out.printf("=======\n");
        //System.out.printf(myLinkedList.toString());


        //iterative method to reverse String in Java
        String str = "kukupapalala";
        String reverseStr = reverse(str);
        System.out.println("Reverse String in Java using Iteration: " + reverseStr);

        //recursive method to reverse String in Java
        reverseStr = reverseRecursively(str);
        System.out.println("Reverse String in Java using Recursion: " + reverseStr);

        //reverse aaray in place
        String [] array = {"One", "Two", "Tree", "Four", "Five"};
        System.out.println("Original array:\n");
        for(int i=0; i<array.length;i++) {
            System.out.println(array[i] + "\n");
        }
        reverseArrayInPlace(array);
        System.out.println("Reversed array:\n");
        for(int i=0; i<array.length;i++) {
            System.out.println(array[i] + "\n");
        }
    }

    public static String reverseStringByWorlds(String worlds) {
        StringBuilder newWorlds = new StringBuilder();
        String[] splittedWorlds = worlds.split(" ");
        for (int i = splittedWorlds.length - 1; i >= 0; i--) {
            newWorlds.append(splittedWorlds[i] + " ");
        }
        return newWorlds.toString();
    }

    public static LinkedList<String> reverseLinkedListNotRecursive(LinkedList<String> linkedlist){
        int size = linkedlist.size();
        LinkedList<String> temp = new LinkedList<String>();
        for(int i = size-1; i>=0;i--){
            temp.add(linkedlist.get(i));
        }
        return temp;
    }

    public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }


    static class MyLinkedList {
        ListNode head = null;
        private int count;

        public MyLinkedList(){
            head = new ListNode(null);
            count = 0;
        }
        public void add(String data){
            if(head==null){
                head = new ListNode(data);
            }
            ListNode listNewNode = new ListNode(data);
            ListNode currentNode = head;
            if(currentNode != null){
                while(currentNode.nextNode != null){
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode = listNewNode;
            }
            count++;
        }

        public void reverseList(){
            if(head != null) {
                 head = recursiveReverse(head, head.nextNode);
            }
        }

        private ListNode recursiveReverse(ListNode prev, ListNode curr){
           ListNode next = curr.nextNode;
           curr.nextNode = prev;
           if(next==null) {
               return curr;
           }
           else {
               return recursiveReverse(curr, next);
           }
        }

        public String toString(){
            StringBuilder str = new StringBuilder();
            if(head!=null){
                ListNode curr = head.nextNode;
                while(curr != null) {
                    str.append(curr.nodeValue + "\n");
                    curr = curr.nextNode;
                }
            }

            return str.toString();
        }
    }

    static class ListNode {
        public String nodeValue;
        public ListNode nextNode;

        ListNode(String nodeValue){
            this.nodeValue = nodeValue;
            nextNode = null;
        }
    }

    /* If singly LinkedList contains Cycle then following would be true * 1) slow and fast will point to same node i.e. they meet
    On the other hand if fast will point to null or next node of * fast will point to null then LinkedList does not contains cycle. */
    public static boolean isCyclic(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.nextNode != null){
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            //if fast and slow pointers are meeting then LinkedList is cyclic
            if(fast == slow )
            {
                return true;
            }
        } return false;
    }

    public static void reverseArrayInPlace(String[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
