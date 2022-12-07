package com.asos;

import java.util.Map;

import org.apache.spark.*;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.elasticsearch.spark.rdd.api.java.JavaEsSpark;
import org.spark_project.guava.collect.ImmutableList;
import org.spark_project.guava.collect.ImmutableMap;

public final class App {
    public static void main(String[] args) {
        execExample(3);
    }

    public static void execExample(Integer exampleNumber) {
        if (exampleNumber == 1) {
            basicExample();
        } else if (exampleNumber == 2) {
            sparkSqlExample();
        } else if (exampleNumber == 3){
            sparkSqlReadExample();
        }
    }

    public static void sparkSqlExample() {
        String csvFile = "/Users/jurajlapcak/school/asos-project/charts_smaller.csv";
        CsvReader csvReader = new CsvReader();
        csvReader.readCsv(csvFile);
        csvReader.close();
    }

    public static void sparkSqlReadExample(){
        EsReader esReader = new EsReader();
        esReader.readEsToCsv();
        esReader.close();
    }

    public static void basicExample() {
        String appName = "Simple Application";
        SparkConf config = new SparkConf().setAppName(appName).setMaster("local");
        config.set("es.index.auto.create", "true");
        config.set("es.nodes", "localhost");
        config.set("es.port", "9200");

        JavaSparkContext jsc = new JavaSparkContext(config);

        Map<String, ?> numbers = ImmutableMap.of("one", 1, "two", 2);
        Map<String, ?> airports = ImmutableMap.of("OTP", "Otopeni", "SFO", "SanFran");

        JavaRDD<Map<String, ?>> javaRDD = jsc.parallelize(ImmutableList.of(numbers,
                airports));
        JavaEsSpark.saveToEs(javaRDD, "spark/docs");

        jsc.close();
    }
}
