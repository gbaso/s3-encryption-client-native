package com.example.s3encryption;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.Nullable;

import software.amazon.encryption.s3.internal.ApiNameVersion;

public class ApiNameVersionHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
        var resource = new ClassPathResource("project.properties", ApiNameVersion.class.getClassLoader());
        hints.resources().registerResource(resource);
    }
    
}