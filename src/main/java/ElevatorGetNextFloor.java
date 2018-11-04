import DataStructureManipulations.TreeManipulations;

import java.util.Arrays;
import java.util.List;

public class ElevatorGetNextFloor {
    public static void main(String a[]){
        int [] seq = {1, 3, 4, 18, 6, 8, 5, 12, 14, 25, 22};
        Arrays.sort(seq);
        int f = getNextFloor(seq, 17);
        //int nextFloor = getNextFloorWithTree(seq, 18);
        System.out.printf("Next floor to stop is " + f + "\n");

    }

    public static int getNextFloorWithTree(int [] floors, int standby){
        TreeManipulations.BinaryTree bt = new TreeManipulations.BinaryTree();
        bt.insertIntoTree(standby);
        Arrays.sort(floors);
        for(int i=0;i<floors.length;i++){
            bt.insertIntoTree(floors[i]);
        }
        if(bt.root.left !=null) {
            return bt.root.left.val;
        } else if(bt.root.right!=null) {
            return bt.root.right.val;
        }
        return 0;
    }

    public static int getNextFloorWithArray(int [] floors, int standby){
        int nextFloor = standby;
        if(floors==null || floors.length==0){
            return nextFloor;
        }
        Arrays.sort(floors);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<floors.length;i++){
            int x = Math.abs(standby - floors[i]);
            if(x==1) {
                return floors[i];
            }
            if(x <= min) {
                min = x;
                nextFloor = floors[i];
            }
        }
        return nextFloor;
    }

    public static int getNextFloor(int [] floors, int standby) {
        int nextFloor = standby;
        //Arrays.sort(floors);
        if(floors==null || floors.length==0){
            return nextFloor;
        }
        //find standby floor on the array with binary search
        int crossOver = findCrossOver(floors, 0, floors.length -1, standby);
        //if standby is last floor
        if(crossOver == floors.length) {
            return floors[crossOver-1];
        }
        //if standby is first floor
        if(crossOver==0) {
            return floors[crossOver+1];
        }
        //find floor that is closer to standby between 2 floors, one before and one after
        return getMinFloor(standby, floors[crossOver], floors[crossOver-1], floors[crossOver+ 1]);
    }

    public  static int getMinFloor(int standby, int crossOver, int low, int high){
        if(Math.abs(standby - crossOver)>0) return crossOver;
        if(Math.abs(standby - low)<Math.abs(standby - high)) return low;
        else return high;
    }

    private static int findCrossOver(int [] floors, int low, int hight, int standby) {
        int mid = (hight + low) / 2;
        //ceiling
        if(floors[hight]<=standby) {
            return hight;
        }
        //start of array
        if(floors[low]>=standby){
            return low;
        }

        if(floors[mid]==standby) {
            return mid;
        }

        if(floors[mid]<=standby && floors[mid+1]>standby){
            return mid;
        }

        if(floors[mid]<standby){
            return findCrossOver(floors, mid+1, hight, standby);
        }
        return findCrossOver(floors, low, mid-1, standby);
    }

}
