package DataStructureManipulations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO:
//Merge Two Balanced Binary Search Trees
//Print Common Nodes in Two Binary Search Trees
//Construct all possible BSTs for keys 1 to N
//Inorder Tree Traversal without Recursion


public class TreeManipulations {
    //BFS - breadth-first search (BFS) and depth-first search (DFS)
    //all operation is O(Logn) time for BST
    public static void main(String[] args) throws Exception {
        BinaryTree bt = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();
        bt.insertIntoTree(8);
        bt.insertIntoTree(2);
        bt.insertIntoTree(9);
        bt.insertIntoTree(3);
        bt.insertIntoTree(6);
        bt.insertIntoTree(16);
        bt.insertIntoTree(7);
        bt.insertIntoTree(1);
        bt.insertIntoTree(12);
        int max1 = bt.getMaxNode(bt.root);

        bt2.insertIntoTree(8);
        bt2.insertIntoTree(2);
        bt2.insertIntoTree(16);
        bt2.insertIntoTree(3);
        bt2.insertIntoTree(6);
        bt2.insertIntoTree(9);
        bt2.insertIntoTree(1);
        bt2.insertIntoTree(7);
        bt2.insertIntoTree(12);
        int max2 = bt2.getMaxNode(bt2.root);
        System.out.printf("\nMAX NODE b1 = " + max1 + " MAX NODE BT2 = " + max2 + "\n");

        bt.traverseTree(bt.root);
        boolean wasFound = bt.findNode(bt.root, 12); //DFS
        System.out.println("\nIs node with value " + " was found in tree? " + wasFound);
        System.out.println("\nMax tree depth = " + bt.findMaxDepthOfTree(bt.root));
        System.out.println("\nSize of tree = " + bt.calcSizeOfTree(bt.root));
        System.out.println("\nCount of leaves of tree = " + bt.calcLeafsOfTree(bt.root));
        System.out.println("\nAre 2 trees identical = " + bt.are2TreesIdentical(bt.root, bt2.root));
        System.out.println("\nSum of tree nodes = " + bt.calcSumOfTreeNodes(bt.root));
        System.out.println("\nIs tree BST = " + bt.isTreeBST(bt2.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("\nBFS traversal: " + " breadth = " + bt.getTreeBreadth(bt.root));

        List<Node> allTrees = bt.constructTrees(1,3);
        for(int i=0;i<allTrees.size();i++){
            bt.traverseTree(allTrees.get(i));
        }
    }

    static public class BinaryTree {
        public Node root;

        public BinaryTree(){
            root = null;
        }

        public void insertIntoTree(int val){
            root = add(root, val);
        }

        public Node add(Node root, int val) {
            if(root == null) {
                root = new Node(val);
                return root;
            }
            if (val < root.val) {
                root.left = add(root.left,val);
            } else {
                root.right = add(root.right, val);
            }
            return root;
        }

        public int getMaxNode(Node root){
            int max = 0;
            if(root==null){
                return Integer.MIN_VALUE;
            }
            if(root.left==null && root.right== null) {
                return root.val;
            }
            max = Math.max(root.val, getMaxNode(root.left));
            max = Math.max(max, getMaxNode(root.right));
            return max;
        }


        public void traverseTree(Node currentNode) {
            if(currentNode==null){
                return;
            }
            System.out.printf(" [" + currentNode.val + "] ");
            traverseTree(currentNode.left);
            traverseTree(currentNode.right);

        }

        public int getTreeBreadth(Node root) {
            Stack<Node> stack = new Stack<>();
            int breadthLeft = 0;
            int breadthRight = 0;

            if(root!=null) {
                stack.push(root);
            }
            while(!stack.isEmpty()) {
                Node temp = stack.firstElement();
                System.out.printf(" [" + temp.val + "] ");
                if(temp.left!= null){
                    stack.push(temp.left);
                    breadthLeft++;
                }
                if(temp.right!=null){
                    stack.push(temp.right);
                    breadthRight++;
                }
                stack.remove(temp);
            }

            return breadthLeft>breadthRight?breadthLeft:breadthRight;
        }

        public boolean findNode(Node currentNode, int val) {
            if(currentNode==null){
                return false;
            }
            if(currentNode.val == val) {
                return true;
            }
            if(val < currentNode.val) {
                return findNode(currentNode.left, val);
            } else if(val > currentNode.val) {
                return findNode(currentNode.right, val);
            }
            return false;
        }

        public int findMaxDepthOfTree(Node currentNode) {
            if (currentNode == null) {
                return 0;
            }

            int leftDepth = findMaxDepthOfTree(currentNode.left);
            int rightDepth = findMaxDepthOfTree(currentNode.right);
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }

        public int calcSizeOfTree(Node currentNode) {
            if (currentNode == null) {
                return 0;
            }
            return calcSizeOfTree(currentNode.left) + 1 + calcSizeOfTree(currentNode.right);
        }

        public int calcSumOfTreeNodes(Node currentNode) {
            if (currentNode == null) {
                return 0;
            }
            return currentNode.val + calcSumOfTreeNodes(currentNode.left) + calcSumOfTreeNodes(currentNode.right);
        }

        public int calcLeafsOfTree(Node currentNode) {
            if (currentNode == null) {
                return 0;
            }
            if(currentNode.left == null && currentNode.right == null) {
                return 1;
            }
            return calcLeafsOfTree(currentNode.left) + calcLeafsOfTree(currentNode.right);
        }

        public boolean are2TreesIdentical(Node root1, Node root2){
            if(root1 == null && root2 == null) {
                return true;
            } else if(root1 != null && root2 != null){
                return (root1.val == root2.val) && are2TreesIdentical(root1.left, root2.left) && are2TreesIdentical(root1.right, root2.right);
            }
            return false;
        }

        public boolean isTreeBST(Node root, int min, int max){
            if(root == null) {
                return true;
            }
            if(root.val < min || root.val > max) {
                return false;
            }
            return isTreeBST(root.left, min, root.val -1) && isTreeBST(root.right, root.val+1, max);
        }


        public int numOfElementsInNthLevel(Node root, int k){
            return 0;
        }

        public int numOfElementsTillNthLevel(Node root, int k){
            return 0;
        }

        public Node predecessor(Node root, int val){
            return null;
        }

        public Node accessor(Node root, int val){
            return null;
        }

        public int numOfElementsLessThenK(Node root){
            return 0;
        }

        public List<Node> constructTrees(int start, int end) {
            List<Node> listOfTrees = new ArrayList<Node>();
            if(start>end){
                listOfTrees.add(null);
                return listOfTrees;
            }
            for(int i=start;i<end;i++){
                List<Node> leftSubTree = constructTrees(start, i -1);
                List<Node> rightSubTree = constructTrees(i+1, end);
                for(int j=0;j<leftSubTree.size();j++){
                    Node left = leftSubTree.get(j);
                    for(int k=0;k<rightSubTree.size();k++){
                        Node right = rightSubTree.get(i);
                        Node node = new Node(i);
                        insertIntoTree(node.val);
                        node.left = left;
                        node.right = right;
                        listOfTrees.add(node);
                    }
                }
            }
            return listOfTrees;
        }
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node( int val ) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public String toString() {
            return String.valueOf(val);
        }
    }
}
