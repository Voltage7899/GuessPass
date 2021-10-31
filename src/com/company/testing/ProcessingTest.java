package com.company.testing;

import com.company.Processing;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ProcessingTest {

    @Test
    public void setWordTest() {
        //given
        Processing processing = new Processing();

        //then
        assertTrue(processing.setWord("word"));
        assertFalse(processing.setWord("two words"));
        assertFalse(processing.setWord("w0rd"));
    }

    @Test
    public void buildSecretWordTest() {
        Processing processing = new Processing();
        processing.setWord("wordoo");

        assertEquals(processing.buildSecretWord("h"), "______");
        assertEquals(processing.buildSecretWord("o"), "_o__oo");
    }

    @Test
    public void guessTest() {
        Processing processing = new Processing();
        processing.setWord("woop");

        assertFalse(processing.guess("g"));
        assertFalse(processing.guess("o"));
        assertFalse(processing.guess("w"));
        assertTrue(processing.guess("p"));
    }

    @Test
    public void setDescriptionTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Processing processing = new Processing();

        //when
        processing.setDescription("desc");

        //then
        final Field field = processing.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(processing), "desc");
    }

    @Test
    public void guessWordTest() {
        Processing processing = new Processing();
        processing.setWord("woop");

        assertFalse(processing.guessWord("wood"));
        assertTrue(processing.guessWord("woop"));
    }

    @Test
    public void isGuessedTest() {
        Processing processing = new Processing();
        processing.setWord("wordoo");

        assertFalse(processing.isGuessed("h"));
        assertTrue(processing.isGuessed("o"));
    }



}