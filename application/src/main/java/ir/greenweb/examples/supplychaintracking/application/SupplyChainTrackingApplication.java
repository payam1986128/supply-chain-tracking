package ir.greenweb.examples.supplychaintracking.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ir.greenweb.examples.supplychaintracking")
@EnableJpaRepositories(basePackages = "ir.greenweb.examples.supplychaintracking.persistence.repository")
@EntityScan(basePackages = "ir.greenweb.examples.supplychaintracking.persistence.entity")
public class SupplyChainTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainTrackingApplication.class, args);
    }

}
