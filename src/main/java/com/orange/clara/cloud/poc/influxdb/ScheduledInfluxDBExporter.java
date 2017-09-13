package com.orange.clara.cloud.poc.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledInfluxDBExporter {

    @Autowired
    private InfluxDB influxDB;

    @Scheduled(fixedRate = 5000)
    public void sendData() throws Exception {

        Random rand = new Random();
        int value = rand.nextInt(10);

        Point point = Point.measurement("a_metric")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("value", value)
                .build();
        this.influxDB.write(point);
    }
}
