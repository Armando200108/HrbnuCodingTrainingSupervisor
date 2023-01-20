package cn.pdteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Contest4002Application {
    public static void main(String[] args) {
        SpringApplication.run(Contest4002Application.class, args);
    }
}
