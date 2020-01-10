package domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
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
    Person person = Person.of(9999);

    //when
    person.buyAutoLottoAllProperty();

    //then
    assertThat(person.getLottoList().size()).isEqualTo(9);
  }

  @Test
  void 보유한_금액으로_수동_로또를_살수없으면_에러가_발생한다() {
    //given
    Person person = Person.of(999);

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      person.buyManualLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    });
  }
}
