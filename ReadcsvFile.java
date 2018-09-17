import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class ReadcsvFile {
	
	public static String[] firstLine;
	
	public static ArrayList<Features> reader(String filename, int compareIndex){
		
		String csvFile = filename;
        BufferedReader br = null;
        
        String line = "";
        String cvsSplitBy = ",";
        
        int count = 0;
        ArrayList<Features> lines = new ArrayList<Features>();
        String[] first = new String[84];
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] linesep = line.split(cvsSplitBy);
                if(count == 0){
                	first = linesep;
                	count++;
                	continue;
                }
                Features f1 = new Features(linesep,count,compareIndex);
                count++;
                lines.add(f1);
            }
            firstLine = first;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return lines;
	}
}
