import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Birthday notification using Segment Tree
 *
 * @author Raju Rama Krishna
 *
 */
public class BirthdayCalculator {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        Map<String, String> map = BirthdayHolder.getBirthdayMap();
        SegmentTree tree = new SegmentTree();
        tree.create(1, 366);
        Set<String> set = map.keySet();
        Date date = null;
        for( String s: set ) {
            date = format.parse(map.get(s));
            cal.setTime(date);
            tree.add( s, cal.get( Calendar.DAY_OF_YEAR));
        }

        date = format.parse("27/02/2012");
        cal.setTime(date);
        int start = cal.get(Calendar.DAY_OF_YEAR);
        date = format.parse("03/05/2012");
        cal.setTime(date);
        int end = cal.get(Calendar.DAY_OF_YEAR);
        List<String> list = tree.find( start, end );
        System.out.println("People celebrating birthday :");
        System.out.println(list);
    }

}

class SegmentTree {

    Element root;

    public void create( int start, int end ) {
        root = new Element( start, end );
        create( root );
    }

    private void create( Element e ) {
        int start = e.start;
        int end = e.end;
        if( start < end ) {
            Element l = new Element( start, (start+end)/2 );
            e.left = l;
            Element r = new Element( (start+end)/2+1, end );
            e.right = r;
            create( e.left );
            create( e.right );
        }
    }

    public void add( String s, int val ) {
        add( root, s, val );
    }

    private void add( Element e, String s, int val ) {
        if( e != null && val >= e.start && val <= e.end) {
            e.add(s);
            add( e.left, s, val );
            add( e.right, s, val );
        }
    }

    public List<String> find( int start, int end ) {
        return find( root, start, end );
    }

    private List<String> find( Element e, int start, int end ) {
        if( e == null || e.end < start ) {
            return new ArrayList<String>();
        }
        if( e.start == start && e.end == end ) {
            return e.list;
        } else if( e.left.start <= start && e.left.end >= end ) {
            return find( e.left, start, end );
        } else if( e.right.start <= start && e.right.end >= end ) {
            return find( e.right, start, end);
        } else {
            List<String> list1 = find( e.left, start, e.left.end);
            List<String> list2 = find(e.right, e.right.start, end);
            if( list1 != null ) {
                if( list2 != null) {
                    list1.addAll( list2 );
                }
            } else {
                if( list2 != null ) {
                    list1 = list2;
                }
            }
            return list1;
        }

    }

}

class Element {
    int start;
    int end;
    List<String> list;
    Element left;
    Element right;

    public Element( int start, int end ) {
        this.start = start;
        this.end = end;
    }

    public void add( String s ) {
        if( list == null ) {
            list = new ArrayList<String>();
        }
        list.add(s);
    }

    public String toString() {
        return "[" + start + "-" +end + "]";
    }
}

class BirthdayHolder {

    private static Map<String, String> map = new HashMap<String, String>();

    public static Map<String, String> getBirthdayMap() {
        map.put("Rogers", "11/12/1979");
        map.put("Susan", "02/05/1978");
        map.put("Pratap", "11/11/1975");
        map.put("Maddy", "04/08/1992");
        map.put("Dia", "09/08/2008");
        map.put("Mohan", "14/02/1999");
        map.put("Patrick", "28/02/1952");
        map.put("John", "01/01/2002");
        map.put("Francis", "29/02/1982");
        map.put("Carol", "01/03/2000");
        return map;
    }
}