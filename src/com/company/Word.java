package com.company;

public class Word {
    private String word;
    private String secretWord;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< word.length(); i++){
            sb.append("_");
        }
        this.secretWord = sb.toString();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String word) {
        this.secretWord = word;
    }

    public boolean isGuessedFully(){
        return secretWord.equals(word);
    }
}
