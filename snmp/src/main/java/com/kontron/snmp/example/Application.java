package com.kontron.snmp.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.logging.SocketHandler;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        File bootCounterFile = new File("./SampleAgent.bc");
        File configFile = new File("./SampleAgent.cfg");

        bootCounterFile.delete();
        configFile.delete();

        SampleAgent.runAgent(args);
    }
}
