package com.asos;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.elasticsearch.spark.sql.api.java.JavaEsSparkSQL;

public class CsvReader {
    String appName = "CSV reader app";
    SparkSession spark;

    public CsvReader() {
        this.spark = SparkSession.builder().appName(appName).master("local")
                .config("es.index.auto.create", "true")
                .config("es.nodes", "localhost")
                .config("es.port", "9200")
                .getOrCreate();
    }

    public void readCsv(String csvFile) {
        Dataset<Row> csv = spark.read().format("csv").option("header", "true")
                .load(csvFile);
        csv.show();

        JavaEsSparkSQL.saveToEs(csv.limit(100000), "spotify/records");        
    }

    public void close() {
        this.spark.close();
    }

}
