package com.haryharsono.cloud.config.cloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudServiceApplication.class, args);
  }
}
