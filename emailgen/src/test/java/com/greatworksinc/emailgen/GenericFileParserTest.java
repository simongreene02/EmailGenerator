package com.greatworksinc.emailgen;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class GenericFileParserTest {

	@Test
	public void next() {
		GenericFileParser parser = new GenericFileParser("fakeFirstNames.txt");
		assertThat(parser.next()).isEqualTo("A");
		assertThat(parser.next()).isEqualTo("B");
		assertThat(parser.next()).isEqualTo("C");
		
	}
	
	@Test
	public void next_callingTooMany() {
		GenericFileParser parser = new GenericFileParser("fakeFirstNames.txt");
		assertThat(parser.next()).isEqualTo("A");
		assertThat(parser.next()).isEqualTo("B");
		assertThat(parser.next()).isEqualTo("C");
		assertThat(parser.next()).isNull();
		assertThat(parser.next()).isNull();
		assertThat(parser.next()).isNull();
		assertThat(parser.next()).isNull();
		assertThat(parser.next()).isNull();
		
	}

}
