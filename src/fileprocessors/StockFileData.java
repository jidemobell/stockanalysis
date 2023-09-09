package fileprocessors;

import java.util.*;

public class StockFileData {
	
	List<HashMap<String, Double>> data = new LinkedList<>();
	
	public void printData(){
		System.out.println(data);
	}
	
	public void addData(List<HashMap<String, Double>> dataIn){
		data = dataIn;
	}

	public List<Double> processColumns(List<HashMap<String, Double>> dataIn, String column){
		System.out.println(column);
		List<Double> list = new ArrayList<>();
		for (HashMap<String, Double> row: dataIn){
//			System.out.println(row);
//			System.out.println(row.get(column));
			list.add(row.get(column));
		}
		return list;
	}
}
