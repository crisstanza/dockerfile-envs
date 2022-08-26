package io.github.crisstanza.dockerfileenvs.enums;

public enum OutputMode {

    SINGLE_LINE(";"), MULTI_LINE(System.lineSeparator());

    public final String lineSeparator;

    OutputMode(final String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
}
