package com.greatworksinc.emailgen;

import static java.nio.file.Files.newBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nullable;

public class GenericFileParser {
	private BufferedReader br;
	private boolean isClosed = false;

	protected GenericFileParser(String fileName) {
		try {
			this.br = newBufferedReader(BufferedFileParser.getPath(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public @Nullable String next() {
		if (isClosed) {
			return null;
		}
		try {
			String nextLine = br.readLine();
			if (nextLine == null) {
				br.close();
				isClosed = true;
			}
			return nextLine;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
