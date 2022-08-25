package io.github.crisstanza.dockerfileenvs;

public final class Main {

    /**
     * Folder where is the Dockerfile.
     */
    public static final String HOME = "C:\\_BITBUCKET.NEUTRINOS\\enforcement_request_service\\src\\main\\docker\\";
    public static final OutputMode OUTPUT_MODE = OutputMode.SINGLE_LINE;

    public static final void main(final String[] args) throws Exception {
        final DockerfileReader reader = new DockerfileReader();
        System.out.println("Success? " + reader.start());
    }

}
