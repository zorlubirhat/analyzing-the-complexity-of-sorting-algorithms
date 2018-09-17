import java.util.Comparator;
/**
 * @author Birhat Zorlu 21427564
 *
 */
public class Features{
	public static final Comparator<Features> BY_INDEX = new byIndex();
	private String[] featureArr;
	private int index;
	public static int compIndex;
	
	public Features(String[] featureAr, int ind, int compareIndex){
		this.featureArr = featureAr;
		this.index = ind;
		compIndex = compareIndex;
	}

	public String getFeatureArr(int i) {
		return featureArr[i];
	}

	public void setFeatureArr(String[] featureArr) {
		this.featureArr = featureArr;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private static class byIndex implements Comparator<Features> {
		@Override
		public int compare(Features f1, Features f2) {
			// TODO Auto-generated method stub
			int f1s = (int) Float.parseFloat(f1.getFeatureArr(compIndex));
			int f2s = (int) Float.parseFloat(f2.getFeatureArr(compIndex));
			return f1s - f2s;
		}
		
	}
}
