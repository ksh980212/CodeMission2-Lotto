package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static Scanner scanner = new Scanner(System.in);

  public static int inputMoneyAmount() {
    System.out.println("enter amount");
    return scanner.nextInt();
  }

  public static List<Integer> inputWinningNumbers() {
    removeBuffer();
    System.out.println("Enter last winning numbers");
    String[] splitString = splitBySeparator(scanner.nextLine());
    List<Integer> result = new ArrayList<>();
    for(int i = 0 ; i < splitString.length ; i++) {
      result.add(convertToInteger(splitString[i]));
    }
    return result;
  }

  private static String[] splitBySeparator(String inputString) {
    return inputString.split(", ");
  }

  private static int convertToInteger(String string) {
    return Integer.parseInt(string);
  }

  private static void removeBuffer() {
    scanner.nextLine();
  }
}
