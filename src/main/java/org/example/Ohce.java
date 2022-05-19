package org.example;

import java.util.Objects;

public class Ohce {

  public static final String BONITA_PALABRA = "\r\n¡Bonita palabra!";
  public static final String BUENAS_NOCHES = "¡Buenas noches ";
  public static final String BUENAS_TARDES = "¡Buenas tardes ";
  public static final String BUENAS_DIAS = "¡Buenas dias ";
  public static final String WELCOME = " - Wolcome , What is your name ? ";
  public static final String PROCESS = " - What to reverse ? ";
  private WordService wordService = new WordService();
  private TimeService timeService = new TimeService();
  private ConsoleService consoleService = new ConsoleService();

  public static void main(String... args) {
    ConsoleService console = new ConsoleService();
    console.writeLine(WELCOME);
    String name = console.readLine();
    new Ohce().startOhce(name);
  }

  public void startOhce(String name) {
    greeting(name);
    processWords();
    adios(name);
  }

  public void greeting(String name) {
    if (timeService.isMorning()) {
      consoleService.writeLine(buenasDias(name));
    } else if (timeService.isAfternoon()) {
      consoleService.writeLine(buenasTardes(name));
    } else if (timeService.isNight()) {
      consoleService.writeLine(buenasNoches(name));
    }
  }

  public void processWords() {
    consoleService.writeLine(PROCESS);
    String readWord = consoleService.readLine();
    while (!Objects.equals(readWord, "Stop!")) {
      consoleService.writeLine(getReverseWordResponse(readWord));
      readWord = consoleService.readLine();
    }
  }

  public void adios(String name) {
    consoleService.writeLine("Adios " + name);
  }

  public String buenasNoches(String name) {
    return BUENAS_NOCHES + name + "!";
  }

  public String buenasTardes(String name) {
    return BUENAS_TARDES + name + "!";
  }

  public String buenasDias(String name) {
    return BUENAS_DIAS + name + "!";
  }

  public String getReverseWordResponse(String word) {
    try {
      boolean isPalindrome = wordService.isPalindrome(word);
      if (isPalindrome) return wordService.reverseWord(word) + BONITA_PALABRA;
      return wordService.reverseWord(word);
    } catch (IllegalArgumentException e) {
      return "Please enter a word that is made up only of letters! "
          + "To stop enter the following command: Stop!";
    }
  }
}
