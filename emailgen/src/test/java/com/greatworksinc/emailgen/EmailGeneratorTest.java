package com.greatworksinc.emailgen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static com.google.common.truth.Truth.assertThat;

import java.io.PrintStream;


/**
 * Created by acorn on 6/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailGeneratorTest extends Mockito {

    private static final String FAKE_FIRST_NAMES_TXT = "FakeFirstNames.txt";
    private static final String FAKE_LAST_NAMES_TXT = "fakeLastNames.txt";
    private static final String FAKE_HOST_NAMES_TXT = "fakeHostNames.txt";
    private static final String REAL_FIRST_NAMES_TXT = "first200sort.txt";
    private static final String REAL_LAST_NAMES_TXT = "last1000sort.txt";
    private static final String REAL_HOST_NAMES_TXT = "hosts2k.txt";
    private @Mock PrintStream printStream;

    @Test
    public void generate_zeroEmail() {
        EmailGenerator emailGenerator = new EmailGenerator(0,
                FAKE_FIRST_NAMES_TXT,
                FAKE_LAST_NAMES_TXT,
                FAKE_HOST_NAMES_TXT,
                printStream);
        emailGenerator.generate();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void generate_oneEmail() {
        EmailGenerator emailGenerator = new EmailGenerator(1,
                FAKE_FIRST_NAMES_TXT,
                FAKE_LAST_NAMES_TXT,
                FAKE_HOST_NAMES_TXT,
                printStream);
        emailGenerator.generate();
        verify(printStream).println("Stephen.Weil@gmail.com");
        verifyNoMoreInteractions(printStream);
    }

    @Test(expected = IllegalStateException.class)
    public void generate_tooMany() {
        EmailGenerator emailGenerator = new EmailGenerator(5,
                FAKE_FIRST_NAMES_TXT,
                FAKE_LAST_NAMES_TXT,
                FAKE_HOST_NAMES_TXT,
                printStream);
        emailGenerator.generate();
    }
    
    @Test
    public void getMaxEmails_fakeFiles() {
    	EmailGenerator emailGenerator = new EmailGenerator(1,
                FAKE_FIRST_NAMES_TXT,
                FAKE_LAST_NAMES_TXT,
                FAKE_HOST_NAMES_TXT,
                printStream);
    	assertThat(emailGenerator.getMaxEmails()).isEqualTo(4);
    }
    
    @Test
    public void getMaxEmails_realFiles() {
    	EmailGenerator emailGenerator = new EmailGenerator(1,
                REAL_FIRST_NAMES_TXT,
                REAL_LAST_NAMES_TXT,
                REAL_HOST_NAMES_TXT,
                printStream);
    	assertThat(emailGenerator.getMaxEmails()).isEqualTo(570800000);
    }

}