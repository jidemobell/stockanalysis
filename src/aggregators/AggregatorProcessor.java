package aggregators;

import client.StockFileApplication;
import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.List;

public class AggregatorProcessor<T extends Aggregator> {
   T aggregator;
   String file;

   public AggregatorProcessor(T aggregator, String file) {
      super();
      this.aggregator = aggregator;
      this.file = file;
   }

   public double runAggregate(int columnNumber) throws IOException {
       //process column data
      StockFileReader reader = new StockFileReader(file);
      StockFileApplication client = new StockFileApplication();
      StockFileData datProcessors = new StockFileData();
      List<Double> output;
      String columnString = StockFileReader.parseColumn(reader, columnNumber);
      output  = datProcessors.processColumns( client.populateStockFileData(reader.getHeaders(), reader.readFileData()), columnString);

       for (double item : output) {
          aggregator.add(item);
       }

       return aggregator.calculate();
   }
}
