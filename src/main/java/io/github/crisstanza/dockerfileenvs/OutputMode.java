package io.github.crisstanza.dockerfileenvs;

public enum OutputMode {

    SINGLE_LINE("=", ";"), MULTI_LINE("=", System.lineSeparator());

    public final String nameValueSeparator;
    public final String lineSeparator;

    OutputMode(final String nameValueSeparator, final String lineSeparator) {
        this.nameValueSeparator = nameValueSeparator;
        this.lineSeparator = lineSeparator;
    }
}
