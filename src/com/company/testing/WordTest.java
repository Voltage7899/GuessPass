package com.company.testing;

import com.company.Word;
import org.junit.Test;


import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void isGuessedFullyTest()
    {
        Word word = new Word();
        word.setWord("word");
        word.setSecretWord("word");
        assertTrue(word.isGuessedFully());
        word.setSecretWord("w_rd");
        assertFalse(word.isGuessedFully());
    }
}
