package DataStructureManipulations;

/*
Print the Middle of a given linked list - DONE
Flattening a linked list
Delete the elements in an linked list whose sum is equal to zero
Delete middle of linked list
Remove duplicate elements from sorted linked list
Add 1 to a number represented as a linked list
Reverse a linked list in groups of given size
Detect loop in linked list - DONE
Remove loop in linked list
Find nth node from the end of linked list - DONE
Function to check if a singly linked list is a palindrome
Reverse alternate k node in a singly linked list
Delete last occurrence of an item from linked list
Rotate a linked list.
Delete n nodes after m nodes of a linked list.
Merge a linked list into another linked list at alternate positions.
Write a function to delete a linked list.
Write a function to reverse the nodes of a linked list - DONE
Why quicksort is preferred for arrays and merge sort for linked lists.
linked list in java
 */
public class ListManipuliations {
    public static void main(String a[]) {
        //find nth element of list from the end
        Node n1 = new Node(8);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(9);
        n2.next = n3;
        Node n4 = new Node(3);
        n3.next = n4;
        Node n5 = new Node(6);
        n4.next = n5;
        Node n6 = new Node(16);
        n5.next = n6;
        Node n7 = new Node(7);
        n6.next = n7;
        Node n8 = new Node(1);
        n7.next = n8;
        Node nth = findNthFromEndListElement(n1, 6);
        nth = findNthFromEndListElement2(n1, 6);

        System.out.printf("List length recursive = " + getListLengthRecursive(n1) + ", linear = " + getListLengthLinear(n1));

        Node head = insertIntoMiddleList(n1, new Node(5));

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
        Node node20 = new Node(8);
        node10.next = node20;
        Node node30 = new Node(12);
        node20.next = node30;

        Node mergedList = merge2SortedLists(node1, node10);

        int sum = countSum2Lists(n1, n2, 10);

        deleteNthNode(n1, 4);

        sortList(n1);

        Node reversed = reverseList(n1);

        //swap nodes of 2 given keys
        swapNodes(n1, 2, 60);

        //find length of loop
        //n8.next = n4;
        //int length = findLengthOfLoop(n1);
    }


    //to do
    public static int findLengthOfLoop(Node head){
        Node fast = head;
        Node slow = head;
        int length = 1;
        //count nodes
        while(slow != null && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        Node temp = slow;
        while(temp.next != slow){
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static Node findNthFromEndListElement(Node head, int n){
        Node node = head;
        Node current = head;
        int counter = 0;

        while(node.next != null){
            counter++;
            if(counter>=n && current.next!=null){
                current = current.next;
            }
            node = node.next;
        }
        return current;
    }

    public static Node findNthFromEndListElement2(Node head, int n){
        Node node = head;
        Node current = head;
        if(head==null || n<1) {
            return null;
        }

        for(int i=0;i<n-1;i++) {
            if(node==null){
                return null;
            }
            node = node.next;
        }

        while(node.next!=null) {
            node= node.next;
            current = current.next;
        }
        return current;
    }

    public static Node reverseList(Node head) {
        Node current = head;
        Node prev = null;
        while(current!=null){
            head = current.next;
            current.next = prev;
            prev= current;
            current = head;
        }
        return prev;
    }



    public static void deleteNthNode(Node head, int n){
        Node current = head;
        Node prev = null;
        int counter = 1;
        while(current!=null && counter < n){
            prev = current;
            current = current.next;
            counter++;
        }
        Node temp = current;
        current = prev;
        prev.next = temp.next;
    }

    public static void swapNodes(Node head, int x, int y){
        Node nodeX = null;
        Node nodeY = null;
        Node current = head;
        Node prevX = head;
        Node prevY = head;
        Node prev = head;
        int position = 0;
        while(current != null && current.next != null){
            if(current.val == x) {
                nodeX = current;
                prevX = position == 0 ? null:prev;
            } else if(current.val == y) {
                nodeY = current;
                prevY = prev;
            }
            position++;
            //swap
            if (nodeY != null && nodeX != null) {
                Node node1 = prevX.next;
                Node node2 = prevY.next;
                Node node1Next = node1.next;
                Node node2Next = node2.next;
                prevX.next = node2;
                prevY.next = node1;
                node2.next = node1Next;
                node1.next = node2Next;
                return;
            }
            prev = current;
            current = current.next;
        }
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

    public static int countSum2Lists(Node list1, Node list2, int sum){
        Node current1 = list1;
        Node current2  =list2;
        int counter = 0;
        while(current1.next != null) {
            if(current1.val < sum) {
                while (current2.next != null) {
                    if (current1.val + current2.val == sum) {
                        counter++;
                    }
                    current2 = current2.next;
                }
                current2 = list2;
            }
            current1 = current1.next;
        }
        return counter;
    }

    public static void sortList(Node head) {
        Node finalNode = new Node(0);
        Node finalNodePrev = null;
        Node current1 = head;
        Node current2 = head.next;
        Node prev = null;
        while (current1.next != null) {
            if(current1.val > current2.val) {
                finalNode = current2;
            }
            prev = current1;
            current1 = current1.next;
        }
    }

    public static Node merge2SortedLists(Node head1, Node head2){
        if(head1 == null) {
            return head2;
        }
        if(head2 == null){
            return  head1;
        }
        if(head1.val<head2.val){
            head1.next = merge2SortedLists(head1.next, head2);
            return head1;
        } else {
            head2.next = merge2SortedLists(head1, head2.next);
            return head2;
        }
    }

    public static Node insertIntoMiddleList(Node head, Node newNode) {
        int count = 1;
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while(fast.next.next!=null){
            count++;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(count%2==0) {
            Node temp = slow;
            slow = newNode;
            newNode.next = temp;
            prev.next = slow;
        } else {
            Node temp = slow.next;
            slow.next = newNode;
            newNode.next = temp;
            prev.next = slow;
        }
        return head;
    }


    //TODO
    public static boolean isListPalindrome(Node head) {
        Node current = head;

        while(current.next!=null){

            current = current.next;
        }
        return false;
    }

    public static int getListLengthRecursive(Node head) {
        if(head == null) {
            return 0;
        }
        return 1 + getListLengthRecursive(head.next);
    }

    public static int getListLengthLinear(Node head) {
        Node current = head;
        int count = head != null? 1 : 0;
        while(current.next!=null){
            count++;
            current = current.next;
        }
        return count;
    }

    public static Node removeDuplicatesFromList(Node head) {
        Node current = head;
        while(current != null && current.next != null){

        }
        return current;
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
     */
    public static void sublistSearch(Node head1, Node head2){

    }

}
