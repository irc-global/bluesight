package com.vaznoe.bluesight.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component @Getter
public class TestProperty {

    @Value("${base.url}")
    private String baseUrl;
}
