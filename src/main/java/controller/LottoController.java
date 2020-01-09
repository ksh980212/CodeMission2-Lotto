package controller;

import domain.person.Person;
import dto.LottoResultDto;
import view.InputView;
import view.OutputView;

public class LottoController {

  public static void buyLottoAndConfirm() {
    Person person = Person.of(InputView.inputMoneyAmount());
    buyLotto(person);
    confirmLotto(person);
  }

  private static void buyLotto(Person person) {
    person.buyAutoLottoAllProperty();
    OutputView.showLottoStatus(person.getLottoStatusDto());
  }

  private static void confirmLotto(Person person) {
//    person.confirmLotto(InputView.inputWinningNumbers());
  }
}
