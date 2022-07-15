package io.github.crisstanza.dockerfileenvs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class Library
{
	private final String in = "Dockerfile";
	private final String out = "Dockerfile-envs";

	public boolean start() throws Exception
	{
		final File inFile = new File(in);
		final File outFile = new File(out);

		final List<String> envs = new ArrayList<>();
		final Scanner scanner = new Scanner(inFile);
		while (scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			if (line.startsWith("ENV ")) {
				if (!line.contains("${")) {
					final String parts[] = line.split("\\s+", 3);
					envs.add(parts[1] + "=" + parts[2]);
				}
			}
		}

		envs.sort(Comparator.comparing(String::toLowerCase));

		final boolean append = false;
		final BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, append));
		writer.write(envs.stream().collect(Collectors.joining(";")));
		writer.close();
		return true;
	}

}
