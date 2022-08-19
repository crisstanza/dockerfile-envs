package io.github.crisstanza.dockerfileenvs;

public final class Main {

    public static final void main(final String[] args) throws Exception {
        final DockerfileReader reader = new DockerfileReader();
        System.out.println("Success? " + reader.start());
    }

}
