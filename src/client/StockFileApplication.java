package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
//		StockFileReader fr = new StockFileReader("table.csv");
//
//		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
//		StockFileData fileData = new StockFileData();
//		fileData.addData(dataResult);
//		fileData.printData();
//		System.out.println(dataResult.size());
//		System.out.println(dataResult);
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public  List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		// Insert your code here..
		for(String line : lines){
//			System.out.println("each line: " + line);
			HashMap<String, Double> headersMap = new HashMap<>();
			List<String> eachLine = new ArrayList<>(Arrays.asList(line.split(",")));

			for (int i = 0; i < eachLine.size(); i++) {
				headersMap.put(headers.get(i),Double.parseDouble(eachLine.get(i)));
			}
			dataResult.add(headersMap);
		}
		return dataResult;
	}

	public List<Double> processDataColumn(List<HashMap<String, Double>> data){
		List<Double> result = new ArrayList<Double>();
		return result;
	}
}
