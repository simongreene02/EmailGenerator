package com.greatworksinc.emailgen;

import static java.nio.file.Files.newBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

public abstract class AbstractFileParser {
	private BufferedReader br;

	protected AbstractFileParser(Path filePath) {
		try {
			this.br = newBufferedReader(filePath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String next() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
