package io.github.crisstanza.dockerfileenvs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public final class Library
{
	private final String in = "Dockerfile";
	private final String out = "Dockerfile-envs";

	public boolean start() throws Exception
	{
		final File inFile = new File(in);
		final File outFile = new File(out);

		final boolean append = false;
		final BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, append));

		final Scanner scanner = new Scanner(inFile);
		while (scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			if (line.startsWith("ENV ")) {
				if (!line.contains("${")) {
					final String parts[] = line.split("\\s+", 3);
					writer.write(parts[1] + "=" + parts[2] + ";");
				}
			}
		}

		writer.close();
		return true;
	}

}
