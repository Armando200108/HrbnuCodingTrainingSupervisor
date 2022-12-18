package cn.pdteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProblemSet4001Application {
    public static void main(String[] args) {
        SpringApplication.run(ProblemSet4001Application.class, args);
    }
}
