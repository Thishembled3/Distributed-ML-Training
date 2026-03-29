package com.example.ml;

import org.apache.spark.sql.SparkSession;

public class DistributedTrainingApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("DistributedMLTraining")
                .master("local[*]") // In a real scenario, this would be a Kubernetes master
                .getOrCreate();

        System.out.println("Spark session created for distributed ML training.");

        // Simulate some distributed ML training logic
        long dataSize = 1000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            // Simulate processing a batch of data
            spark.range(dataSize / 10).count();
            System.out.println("Processed batch " + (i + 1));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Distributed ML training simulated in " + (endTime - startTime) + " ms.");

        spark.stop();
        System.out.println("Spark session stopped.");
    }
}
