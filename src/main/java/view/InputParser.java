package view;

public class InputParser {

  public static String[] splitBySeparator(String inputString) {
    return inputString.split(", ");
  }

  public static int convertToInteger(String string) {
    return Integer.parseInt(string);
  }
}
