package com.greatworksinc.emailgen;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class FirstNameFileParserTest {

	@Test
	public void next() {
		FirstNameFileParser parser = new FirstNameFileParser("fakeFirstNames.txt");
		assertThat(parser.next()).isEqualTo("A");
		assertThat(parser.next()).isEqualTo("B");
		assertThat(parser.next()).isEqualTo("C");
		
	}
	
	@Test
	public void next_callingTooMany() {
		FirstNameFileParser parser = new FirstNameFileParser("fakeFirstNames.txt");
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
