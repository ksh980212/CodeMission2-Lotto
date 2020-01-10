package controller;

import domain.lotto.LottoPrize;
import domain.person.Person;
import dto.LottoPrizeDto;
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
    List<List<Integer>> list = InputView.inputManualLottoNumbers(InputView.inputManualLottoCount());
    for (List<Integer> integers : list) {
      person.buyManualLotto(integers);
    }
  }

  private static void buyAutoLotto(Person person) {
    person.buyAutoLottoAllProperty();
  }

  private static void printLottoStatus(Person person) {
    OutputView.showLottoStatus(person.getLottoStatusDto());
  }

  private static void confirmLotto(Person person) {
    List<LottoPrize> lottoPrizeList = person.confirmLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
    OutputView.showLottoPrizeStatus(LottoPrizeDto.of(lottoPrizeList));
  }
}
