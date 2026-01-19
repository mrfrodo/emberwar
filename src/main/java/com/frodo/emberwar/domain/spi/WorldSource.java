package com.frodo.emberwar.domain.spi;

import java.io.IOException;
import java.io.InputStream;

/**
 * Domain abstraction for where a GameWorld comes from.
 * No technical details allowed here.
 */
public interface WorldSource {
    InputStream open() throws IOException;
}