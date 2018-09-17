import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class InsertionSorting {
	public static void sort(ArrayList<Features> a, Comparator<Features> comparator){
		int N = a.size();
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0 && less(comparator,a.get(j),a.get(j - 1)); j--)
				exch(a, j, j-1);
	}
	
	private static boolean less(Comparator<Features> c, Features v, Features w){ 
		return c.compare(v, w) < 0; 
	}
	
	private static void exch(ArrayList<Features> a, int i, int j){ 
		Features swap = a.get(i); a.set(i, a.get(j)); a.set(j, swap); 
	}
}
