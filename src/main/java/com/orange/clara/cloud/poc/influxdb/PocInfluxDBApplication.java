package com.orange.clara.cloud.poc.influxdb;

import org.influxdb.InfluxDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PocInfluxDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocInfluxDBApplication.class, args);
    }

    @Bean
    CommandLineRunner setInfluxDBLogLevel(InfluxDB influxDB) {
        return args -> {
            influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        };
    }
}
