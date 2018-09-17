import java.util.ArrayList;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class Assignment1 {
	
	public static void main(String[] args) {
		
		String csvfile = args[0];
		ArrayList<Features> linesArray = ReadcsvFile.reader(csvfile, Integer.parseInt(args[1]));
		
		QuickSorting.sort(linesArray, Features.BY_INDEX);
		
		if(args[2].equals("T")){
			WritecsvFile.writeCsvFile(csvfile, linesArray);
		}
		else if(args[2].equals("F")){
			//NOTHING
		}
	}
}