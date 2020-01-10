package view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

  private final static String SEPARATOR = ", ";

  public static String[] splitBySeparator(String inputString) {
    return inputString.split(SEPARATOR);
  }

  public static List<Integer> convertToIntegerList(String[] splitString) {
    List<Integer> result = new ArrayList<>();
    for (String s : splitString) {
      result.add(InputParser.convertToInteger(s));
    }
    return result;
  }

  private static int convertToInteger(String string) {
    return Integer.parseInt(string);
  }

}
