import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class QuickSorting {
	public static void sort(ArrayList<Features> a, Comparator<Features> comparator) {
        sort(a, 0, a.size() - 1, comparator);
        assert isSorted(a, comparator);
    }

    private static void sort(ArrayList<Features> a, int lo, int hi, Comparator<Features> comparator) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi, comparator);
        sort(a, lo, j - 1, comparator);
        sort(a, j + 1, hi, comparator);
        assert isSorted(a, lo, hi, comparator);
    }

    private static int partition(ArrayList<Features> a, int lo, int hi, Comparator<Features> comparator) {
        int i = lo;
        int j = hi + 1;
        Features v = a.get(lo);
        while (true) {

            while (less(a.get(++i), v, comparator))
                if (i == hi) break;

            while (less(v, a.get(--j), comparator))
                if (j == lo) break; 

            if (i >= j) break;

            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;
    }

    private static boolean less(Features v, Features w, Comparator<Features> c){ 
		return c.compare(v, w) < 0; 
	}

    private static boolean isSorted(ArrayList<Features> a, Comparator<Features> comparator) {
        return isSorted(a, 0, a.size() - 1, comparator);
    }

    private static boolean isSorted(ArrayList<Features> a, int lo, int hi, Comparator<Features> comparator) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a.get(i), a.get(i - 1), comparator)) 
            	return false;
        return true;
    }
    
    private static void exch(ArrayList<Features> a, int i, int j){ 
		Features swap = a.get(i); a.set(i, a.get(j)); a.set(j, swap); 
	}
}
