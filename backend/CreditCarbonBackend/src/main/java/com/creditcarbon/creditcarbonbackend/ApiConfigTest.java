package com.creditcarbon.creditcarbonbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiConfigTest {


    @Bean
    CommandLineRunner messageCommandLineRunner() {
        return args -> {

        TransactionRequest t1 = new TransactionRequest(
                "123",
                "2842",
                25,
                "MA"
        );

        ApiClient apiClient = new ApiClient();

        apiClient.sendTransactionData(List.of(t1));

        };
    }

}
