import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Meeting Schedule calculator
 *
 * Output
 * 0000 - 0900
 * 1700 - 2045
 * @author raju rama krishna
 *
 */
public class MeetingPlanner {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        List<String> slots = CalendarSlot.getBusySlots();
        int n = 24 * 60; // 24 hours * 60 min
        int[] watch = new int[n];
        String[] sArr = new String[2];
        for( String s: slots ) {
            sArr = s.split(" ");
            String start = sArr[0];
            int startMin = Integer.parseInt(start.substring(2)) + Integer.parseInt(start.substring(0, 2))*60;
            String end = sArr[1];
            int endMin = Integer.parseInt(end.substring(2)) + Integer.parseInt(end.substring(0, 2))*60;
            for(int i=startMin; i <= endMin; i++) {
                watch[i] = 1;
            }
        }

        int duration = 120;
        int curr = watch[0];
        boolean free = ( curr == 0 )? true: false;
        int i = 0;
        int j = 0;
        while( i < n-1 ) {
            i++;
            if(watch[i] == curr ) {
                continue;
            } else {
                if( free && (i-j) >= duration ) {
                    System.out.println(getTime(j) + " - " +getTime(i));
                }
                j = i-1;
                curr = watch[i];
                free = !free;
            }
        }
    }

    private static String getTime( int val ) {
        int h = val/60;
        int m = val%60;
        NumberFormat formatter = new DecimalFormat("00");
        return formatter.format(h) + formatter.format(m);
    }

}

class CalendarSlot {

    private static List<String> filledSlot = new ArrayList<String>();

    public static List<String>  getBusySlots() {
        filledSlot.add("1600 1700");
        filledSlot.add("1030 1530");
        filledSlot.add("2045 2215");
        filledSlot.add("1000 1325");
        filledSlot.add("0900 1100");
        return filledSlot;
    }
}