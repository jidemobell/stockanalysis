package client;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import fileprocessors.StockFileReader;

import java.io.IOException;

public class AggregratorApp {


    public static void main(String[] args) throws IOException {
        MeanAggregator aggregator = new MeanAggregator();
//        StockFileReader stockFileReader = new StockFileReader("table.csv");
        AggregatorProcessor<MeanAggregator> aggregatorProcessor = new AggregatorProcessor<>(aggregator, "table.csv");
        double value = aggregatorProcessor.runAggregate(1);
        System.out.println(value);
    }


}
