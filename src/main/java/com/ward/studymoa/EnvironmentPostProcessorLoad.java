/**
 * EnvironmentPostProcessorLoad.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 외부 설정 파일을 로드하는 클래스
 *
 * @since 2019. 06. 22
 * @version 1.00
 */
public class EnvironmentPostProcessorLoad implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
    private final String WINDOW_PATH = "C:/private-setting.yml";
    private final String MAX_PATH = "/Users/private-setting.yml";
    private final String LINUX_PATH = "../private-setting.yml";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource path = new FileSystemResource(getPrivateResourcePath());
        PropertySource<?> propertySource = loadYaml(path);
        environment.getPropertySources().addLast(propertySource);
    }

    private PropertySource<?> loadYaml(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource : " + path + " does not exist");
        }
        try {
            return this.loader.load("custom-resource", path).get(0);
        } catch (IOException ex) {
            throw new IllegalStateException(
                    "Failed to load yaml configuration from " + path, ex);
        }
    }

    private String getPrivateResourcePath() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            return WINDOW_PATH;
        } else if (osName.contains("mac")) {
            return MAX_PATH;
        } else {
            return LINUX_PATH;
        }
    }
}
