import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class HeapSorting {
	
	private static int node;
    private static int heapSize;
    private static int left;
    private static int right;

    public static void sort(ArrayList<Features> array, Comparator<Features> comp) {
        buildHeap(array, comp);
        for (int i = array.size() - 1; i >= 0; i--) {
            exch(array, 0, i);
            heapSize--;
            heapify(array, 0, comp);
        }
    }

    private static void buildHeap(ArrayList<Features> array, Comparator<Features> comp) {
        heapSize = array.size();
        for (int i = (int) Math.floor((array.size()) / 2) - 1; i >= 0; i--) {
            heapify(array, i, comp);
        }
    }

    private static void heapify(ArrayList<Features> array, int i, Comparator<Features> comp) {
        left = getLeft(i);
        right = getRight(i);
        node = ((left <= heapSize - 1) && (comp.compare(array.get(left), array.get(i)) > 0))
                ? left
                : i;
        if ((right <= heapSize - 1) && (comp.compare(array.get(right), array.get(node)) > 0)) {
            node = right;
        }
        if (node != i) {
            exch(array, i, node);
            heapify(array, node, comp);
        }
    }

    private static int getLeft(int i) {
        return (i * 2);
    }

    private static int getRight(int i) {
        return (i * 2 + 1);
    }
    
    private static void exch(ArrayList<Features> a, int i, int j){ 
		Features swap = a.get(i); a.set(i, a.get(j)); a.set(j, swap); 
	}
}
