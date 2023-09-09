package fileprocessors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		List<String> lines = new ArrayList<String>();
		// Insert your code here..
		lines = readOtherLine();
	    return lines;
	}

	public List<String> readOtherLine() throws IOException {
		List<String> lines = new ArrayList<String>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
//			return br.lines().collect(Collectors.joining(System.lineSeparator()));
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}

	public static String parseColumn( StockFileReader fr, int columnNumber) throws IOException {
		List<String> line;
		line = fr.getHeaders();
		return line.get(columnNumber);
	}

	public static void main(String[] args) throws IOException {
		StockFileReader stockFileReader = new StockFileReader("table.csv");
		System.out.println(stockFileReader.getHeaders());
	}
	

}
