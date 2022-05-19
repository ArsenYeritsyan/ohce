package org.example;

import java.util.Objects;

public class WordService {
  public static final String WORD_PATTERN = "[a-zA-Z]+";

  public boolean isPalindrome(String word) throws IllegalArgumentException {
    checkWordIsValid(word);

    return Objects.equals(word, reverseWord(word));
  }

  public String reverseWord(String wordToReverse) throws IllegalArgumentException {
    checkWordIsValid(wordToReverse);

    return String.valueOf(reverseWordCharArray(wordToReverse));
  }

  protected char[] reverseWordCharArray(String wordToReverse) {
    char[] reverseWord = new char[wordToReverse.length()];
    for (int index = 0; index < wordToReverse.length(); index++) {
      reverseWord[reverseWord.length - 1 - index] = wordToReverse.charAt(index);
    }
    return reverseWord;
  }

  protected void checkWordIsValid(String wordToCheck) throws IllegalArgumentException {
    if (Objects.equals(wordToCheck, "") || (!wordToCheck.matches(WORD_PATTERN)))
      throw new ArgumentException("Please enter a word!");
  }
}
