package com.catusoft.petshopclient.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner loadData(JdbcTemplate jdbcTemplate) {
        return args -> {
            jdbcTemplate.execute("INSERT INTO product_table (product_name, product_description, product_price, stock) VALUES ('Dog Food', 'High quality dry dog food', '29.99', 100)");
            jdbcTemplate.execute("INSERT INTO product_table (product_name, product_description, product_price, stock) VALUES ('Cat Food', 'Nutritious wet cat food', '24.99', 50)");
            jdbcTemplate.execute("INSERT INTO product_table (product_name, product_description, product_price, stock) VALUES ('Bird Seed', 'Mixed bird seeds for all types of birds', '9.99', 200)");
            jdbcTemplate.execute("INSERT INTO product_table (product_name, product_description, product_price, stock) VALUES ('Fish Tank', 'Glass fish tank with LED lights', '49.99', 20)");
            jdbcTemplate.execute("INSERT INTO product_table (product_name, product_description, product_price, stock) VALUES ('Pet Shampoo', 'Gentle shampoo for pets', '12.99', 150)");
        };
    }
}
