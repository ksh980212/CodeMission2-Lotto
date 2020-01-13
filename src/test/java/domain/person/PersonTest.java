package domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void Person_생성자가_정상적으로_작동된다() {
    //given
    long amount = 10000;

    //when
    Person person = Person.of(amount);

    //then
    assertThat(person.getWallet().getAmount()).isEqualTo(amount);
  }

  @Test
  void 총액의_입력이_음수가_들어오면_에러가_발생한다() {
    // given
    long amount = -10000;

    // when & then
    Assertions.assertThrows( IllegalArgumentException.class, () -> {
      Person.of(amount);
    });
  }

  @Test
  void 로또를_구매하면_사람이_로또를_소유하게된다() {
    //given
    Person person = Person.of(10000);

    //when
    person.buyAutoLottoAllProperty();

    //then
    assertThat(person.getLottoList()).isNotNull();
  }

  @Test
  void 돈의수에따라_구매_로또갯수의_수가_결정된다() {
    //given
    Person person = Person.of(9999); // 로또의 가격은 1000원으로 9개 구매가능해야함.

    //when
    person.buyAutoLottoAllProperty();

    //then
    assertThat(person.getLottoList().size()).isEqualTo(9);
  }

  @Test
  void 보유한_금액으로_수동_로또를_살수없으면_에러가_발생한다() {
    //given
    Person person = Person.of(999); // 로또의 가격은 1000원.

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      person.buyManualLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    });
  }

  @Test
  void 지난_당첨번호의_크기가_잘못되면_에러가_발생한다() {
    //given
    List<Integer> lastWinningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3)); //여섯개야한다.
    int bonusNumber = 6;

    //when & then
    Person person = Person.of(10000);
    Assertions.assertThrows(IllegalArgumentException.class , () -> {
      person.confirmLotto(lastWinningNumbers, bonusNumber);
    });
  }

  @Test
  void 지난_당첨번호이_중복되면_에러가_발생한다() {
    //given
    List<Integer> lastWinningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)); // 보너스 번호와 중복된다
    int bonusNumber = 6;

    //when & then
    Person person = Person.of(10000);
    Assertions.assertThrows(IllegalArgumentException.class , () -> {
      person.confirmLotto(lastWinningNumbers, bonusNumber);
    });
  }
}
