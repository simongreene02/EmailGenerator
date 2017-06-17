package com.greatworksinc.emailgen;

import java.nio.file.Path;

import com.google.common.annotations.VisibleForTesting;

public class FirstNameFileParser extends AbstractFileParser {

	public FirstNameFileParser() {
		this("first200sort.txt");
		// TODO Auto-generated constructor stub
	}
	
	@VisibleForTesting FirstNameFileParser(String fileName) {
		super(FileParser.getPath(fileName));
		// TODO Auto-generated constructor stub
	}
	
	

}
