package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

  private static Scanner scanner = new Scanner(System.in);

  public static int inputMoneyAmount() {
    System.out.println("enter amount");
    return scanner.nextInt();
  }

//  public static List<Integer> inputWinningNumbers() {
//    System.out.println("지난 주 당첨 번호를 입력해 주세요");
//  }
}
