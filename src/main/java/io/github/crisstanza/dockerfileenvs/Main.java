package io.github.crisstanza.dockerfileenvs;

import io.github.crisstanza.dockerfileenvs.enums.OutputMode;

public final class Main {

    /**
     * Folder where is the Dockerfile. It must ends with the path separator slash.
     */
    public static final String DOCKERFILE_HOME = System.getenv("DOCKERFILE_HOME");
    public static final OutputMode OUTPUT_MODE = OutputMode.SINGLE_LINE;

    public static final void main(final String[] args) throws Exception {
        if (DOCKERFILE_HOME == null) {
            throw new RuntimeException("Missing environment variable DOCKERFILE_HOME.");
        }
        final DockerfileReader reader = new DockerfileReader();
        System.out.println("Success? " + reader.start());
    }

}
