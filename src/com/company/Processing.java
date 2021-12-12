package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Processing {

    Word mWord;
    String description;

    public Processing(){
        mWord = new Word();
    }

    public boolean setWord(String word){
        word = word.toLowerCase();
        Pattern pattern = Pattern.compile("[a-zа-я]{3,}");
        if (pattern.matcher(word).matches()){
            mWord.setWord(word);
            System.out.println("Пароль установлен");
            return true;
        }
        else {
            System.out.println("Неправильный тип пароля");
            return false;
        }
    }

    public void setDescription(String description){
        this.description = description;
    }



    public boolean guess(String letter){

        letter = letter.toLowerCase();
        if (isGuessed(letter)){
            mWord.setSecretWord(buildSecretWord(letter));
            if (mWord.isGuessedFully())
            {
                System.out.println("Вы угадали пароль:  \"" + mWord.getSecretWord() + "\"");
                return true;
            }
            else System.out.println("Слово содержит специальный символ" + mWord.getSecretWord());
        }
        return false;
    }
    public boolean isGuessed(String letter){
        if (letter.length() > 1){
            System.out.println("Вы можете угадать только один элемент пароля");
            return false;
        }
        if (!mWord.getWord().contains(letter)){
            System.out.println("Пароль не содержит символ");
            return false;
        }
        else return true;
    }

    public String buildSecretWord(String letter){
        Matcher matcher = Pattern.compile(letter).matcher(mWord.getWord());
        StringBuilder sb = new StringBuilder(mWord.getSecretWord());
        while (matcher.find()){
            sb.setCharAt(matcher.start(), letter.charAt(0));
        }
        return sb.toString();
    }

    public boolean guessWord(String word){
        if (word.equals(mWord.getWord())){
            mWord.setSecretWord(word);
            System.out.println("Вы угадали все слово \"" + mWord.getSecretWord() + "\"");
            return true;
        }
        else {
            System.out.println("Wrong word");
            return false;
        }
    }

    public boolean restart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите сыграть? y/n");
        String play;
        do {
            play = scanner.nextLine();
            play = play.toLowerCase();
        } while (!play.equals("y") && !play.equals("n"));

        if (play.equals("y")){
            return true;
        } else {
            System.out.println("Удачи");
            return false;
        }
    }
}
