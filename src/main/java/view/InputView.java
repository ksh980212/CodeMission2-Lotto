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
    List<Integer> result = convertToIntegerList(InputParser.splitBySeparator(scanner.nextLine()));
    return result;
  }

  public static int inputBonusNumber() {
    System.out.println("enter Bonus number");
    return scanner.nextInt();
  }

  private static List<Integer> convertToIntegerList(String[] splitString) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0 ; i < splitString.length ; i++) {
      result.add(InputParser.convertToInteger(splitString[i]));
    }
    return result;
  }

  private static void removeBuffer() {
    scanner.nextLine();
  }
}
