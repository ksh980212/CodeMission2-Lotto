package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static Scanner scanner = new Scanner(System.in);

  /** 보유 금액 입력 */
  public static int inputMoneyAmount() {
    System.out.println("enter amount");
    return scanner.nextInt();
  }

  /** 수동 로또 갯수 입력 */
  public static int inputManualLottoCount() {
    System.out.println("enter Manual Lotto Count");
    return scanner.nextInt();
  }

  /** 수동 로또 번호 입력 */
  public static List<List<Integer>> inputManualLottoNumbers(int count) {
    removeBuffer();
    // COMMENT 직접적인 2차원 리스트는 절대 사용하지 않습니다
    // List<Integer>을 일급컬렉션으로 만드세요
    // List<InputLottoNumbers> 이런식으로요
    List< List<Integer> > manualLottoList = new ArrayList<>();
    printManualLottoBoardIfExists(count);

    for(int i = 0 ; i < count ; i++) {
      manualLottoList.add( inputManualLottoNumbers() );
    }
    return manualLottoList;
  }

  private static void printManualLottoBoardIfExists(int count) {
    if(count > 0) {
      System.out.println("Enter Manual Lotto number");
    }
  }

  // 그러면 여기에 List<InputLottoNumbers> 를 반환하겠죠?
  private static List<Integer> inputManualLottoNumbers() {
    return InputParser.convertToIntegerList(InputParser.splitBySeparator(scanner.nextLine()));
  }

  /** 지난 당첨 번호 입력 */
  public static List<Integer> inputWinningNumbers() {
    System.out.println("Enter last winning numbers");
    return InputParser.convertToIntegerList(InputParser.splitBySeparator(scanner.nextLine()));
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
