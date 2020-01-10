package view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

  public static String[] splitBySeparator(String inputString) {
    return inputString.split(", ");
  }

  public static int convertToInteger(String string) {
    return Integer.parseInt(string);
  }

  public static List<Integer> convertToIntegerList(String[] splitString) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0 ; i < splitString.length ; i++) {
      result.add(InputParser.convertToInteger(splitString[i]));
    }
    return result;
  }
}
