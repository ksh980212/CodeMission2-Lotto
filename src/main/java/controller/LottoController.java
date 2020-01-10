package controller;

import domain.person.Person;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoController {

  public static void buyLottoAndConfirm() {
    Person person = Person.of(InputView.inputMoneyAmount());
    buyLotto(person);
    confirmLotto(person);
  }

  private static void buyLotto(Person person) {
    buyManualLotto(person);
    buyAutoLotto(person);
    printLottoStatus(person);
  }

  private static void buyManualLotto(Person person) {
    int manualLottoCount = InputView.inputManualLottoCount();
    List<List<Integer>> list = InputView.inputManualLottoNumbers(manualLottoCount);
    for(int i = 0, end = list.size(); i < end ; i++) {
      person.buyManualLotto(list.get(i));
    }
  }

  private static void buyAutoLotto(Person person) {
    person.buyAutoLottoAllProperty();
  }

  private static void printLottoStatus(Person person) {
    OutputView.showLottoStatus(person.getLottoStatusDto());
  }

  private static void confirmLotto(Person person) {
    person.confirmLotto(InputView.inputWinningNumbers());
    person.checkBonusLotto(InputView.inputBonusNumber());
    OutputView.showLottoPrizeStatus(person.getLottoPrizeDto());
  }
}
