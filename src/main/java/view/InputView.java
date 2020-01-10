package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

  private static Scanner scanner = new Scanner(System.in);

  /** 보유 금액 입력 */
  public static int inputMoneyAmount() {
    System.out.println("enter amount");
    return scanner.nextInt();
  }

  /** 지난 당첨 번호 입력 */
  public static List<Integer> inputWinningNumbers() {
    removeBuffer();
    System.out.println("Enter last winning numbers");
    List<Integer> result = InputParser.convertToIntegerList(InputParser.splitBySeparator(scanner.nextLine()));
    return result;
  }

  /** 보너스 볼 입력 */
  public static int inputBonusNumber() {
    System.out.println("enter Bonus number");
    return scanner.nextInt();
  }

  /** 엔터키 버퍼 제거*/
  private static void removeBuffer() {
    scanner.nextLine();
  }
}
