package io.github.crisstanza.dockerfileenvs;

import io.github.crisstanza.dockerfileenvs.enums.OutputMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class DockerfileReader {

    private final String in = Main.DOCKERFILE_HOME + "Dockerfile";
    private final String out = Main.DOCKERFILE_HOME + "Dockerfile-envs";

    private final OutputMode outputMode = Main.OUTPUT_MODE;

    public boolean start() throws Exception {
        final File inFile = new File(in);
        final File outFile = new File(out);

        final List<String> envs = new ArrayList<>();
        final Scanner scanner = new Scanner(inFile);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (line.startsWith("ENV ")) {
                if (!line.contains("${")) {
                    final String[] parts = line.split("\\s+", 3);
                    envs.add(this.cleanName(parts[1]) + "=" + this.unquote(parts[2]));
                }
            }
        }

        envs.sort(Comparator.comparing(String::toLowerCase));

        final boolean append = false;
        final BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, append));
        writer.write(envs.stream().collect(Collectors.joining(this.outputMode.lineSeparator)));
        writer.close();
        return true;
    }

    private String cleanName(final String name) {
        if (name.endsWith(":")) {
            return name.substring(0, name.length() - 1);
        }
        return name;
    }

    private String unquote(final String value) {
        if (value == null) {
            return null;
        }
        if (value.length() == 1) {
            return value;
        }
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

}
