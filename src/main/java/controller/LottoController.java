package controller;

import domain.person.Person;
import view.InputView;

public class LottoController {

  public static void buyLottoAndConfirm() {
    Person person = Person.of(InputView.inputMoneyAmount());
    buyLotto(person);
  }

  private static void buyLotto(Person person) {
    person.buyAutoLottoAllProperty();
  }
}
