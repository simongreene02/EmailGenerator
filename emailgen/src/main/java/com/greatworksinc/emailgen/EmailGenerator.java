package com.greatworksinc.emailgen;

import java.io.PrintStream;

import com.google.common.annotations.VisibleForTesting;

public class EmailGenerator {
	
	private final int numEmails;
	private final String firstNameFile;
	private final String lastNameFile;
	private final String hostNameFile;
	private final PrintStream output;
		
	@VisibleForTesting EmailGenerator(int numEmails, String firstNameFile, String lastNameFile, String hostNameFile,
			PrintStream output) {
		this.numEmails = numEmails;
		this.firstNameFile = firstNameFile;
		this.lastNameFile = lastNameFile;
		this.hostNameFile = hostNameFile;
		this.output = output;
	}
	
	public EmailGenerator(int numEmails, PrintStream output) {
		this(numEmails, "first200sort.txt", "last1000sort.txt", "hosts2k.txt", output);
	}

	void generate() {
		int emailsCreated = 0;
		GenericFileParser firstNamesParser = new GenericFileParser(firstNameFile);
		GenericFileParser lastNamesParser = new GenericFileParser(lastNameFile);
		GenericFileParser hostNamesParser = new GenericFileParser(hostNameFile);
		String firstName = firstNamesParser.next();
		String lastName = lastNamesParser.next();
		String hostName = hostNamesParser.next();
		
		while (emailsCreated < numEmails && hostName != null) {
			//Return Email
			firstName = firstNamesParser.next();
			if (firstName == null) {
				firstNamesParser = new GenericFileParser(firstNameFile);
				firstName = firstNamesParser.next();
				lastName = lastNamesParser.next();
				if (lastName == null) {
					lastNamesParser = new GenericFileParser(lastNameFile);
					lastName = lastNamesParser.next();
					hostName = hostNamesParser.next();
				}
			}
		}
	}
}
