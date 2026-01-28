package com.frodo.emberwar.infrastructure.out.file;

import com.frodo.emberwar.application.spi.WorldSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonWorldSource implements WorldSource {

    private final String source;

    // Constructor to ignore anything else and always use the default JSON file
    public JsonWorldSource() {
        this.source = "gameworld.json"; // this file must be in src/main/resources
    }

    @Override
    public InputStream open() throws IOException {
        // If it looks like raw JSON, use it directly
        if (source.trim().startsWith("{")) {
            return new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
        }

        // Otherwise treat as filename (classpath first)
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream(source);

        if (is != null) return is;

        return new FileInputStream(source);
    }
}
