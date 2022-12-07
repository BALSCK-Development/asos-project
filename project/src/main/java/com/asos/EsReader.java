package com.asos;

import org.apache.spark.*;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.elasticsearch.spark.sql.api.java.JavaEsSparkSQL;

public class EsReader {
    String appName = "Es reader app";
    JavaSparkContext jsc;

    public EsReader() {
        SparkConf config = new SparkConf().setAppName(appName).setMaster("local");
        config.set("es.index.auto.create", "true");
        config.set("es.nodes", "localhost");
        config.set("es.port", "9200");
        this.jsc = new JavaSparkContext(config);
    }

    public void readEsToCsv() {
        SQLContext sql = new SQLContext(jsc);
        Dataset<Row> df = JavaEsSparkSQL.esDF(sql, "spotify/records");
        System.out.println(df.count());
        df.show();
        this.jsc.close();
    }


    public void close() {
        this.jsc.close();
    }
}
