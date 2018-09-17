import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class WritecsvFile {
		
	private static final String[] fileHeader = ReadcsvFile.firstLine;

	public static void writeCsvFile(String fileName, ArrayList<Features> featureArray) {
			
		FileWriter fileWriter = null;
					
		try {
			fileWriter = new FileWriter(fileName);

			for(String word : fileHeader){
				fileWriter.append(word);
				fileWriter.append(",");
			}
			
			fileWriter.append("\n");
			
			for(Features fe : featureArray){
				int i = 0;
				for(;i<83;){
					fileWriter.append(fe.getFeatureArr(i));
					fileWriter.append(",");
					i++;
				}
				fileWriter.append(fe.getFeatureArr(83));
				fileWriter.append("\n");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
	            e.printStackTrace();
			}		
		}
	}
}
