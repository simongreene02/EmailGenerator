package com.greatworksinc.emailgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;

public class BufferedFileParser {
	private static final Logger log = LoggerFactory.getLogger(BufferedFileParser.class);
	
	// buffering
	public void bufferFile() {

		try {
			List<String> data = Files.readAllLines(getPath("first200sort.txt"));
			System.out.println(data.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void streamFilePerLine() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(getFile("first200sort.txt")));
		// int count = 0;
		// br.readLine(); // stream file each line as an atomit unit.
	}

	public static File getFile(String name) {
		try {
			return new File(Resources.getResource(name).toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static Path getPath(String name) {
		try {
			return Paths.get(Resources.getResource(name).toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
