package com.vaznoe.bluesight.config;

import com.vaznoe.bluesight.pages.CostCheckSavingsPage;
import com.vaznoe.bluesight.pages.HomePage;
import com.vaznoe.bluesight.pages.RequestDemoPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.vaznoe.bluesight.pages"})
@PropertySource(value = "classpath:application.properties")
public class PageObjectConfig {

    @Bean
    public HomePage homePage() {
        return new HomePage();
    }

    @Bean
    public RequestDemoPage requestDemoPage() {
        return new RequestDemoPage();
    }

    @Bean
    public CostCheckSavingsPage costCheckSavingsPage() {
        return new CostCheckSavingsPage();
    }
}