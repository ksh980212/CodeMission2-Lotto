package domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void Person_생성자가_초기화된다() {
    //given
    long amount = 10000;

    //when
    Person person = Person.of(amount);

    //then
    assertThat(person.getWallet().getAmount()).isEqualTo(amount);
  }

  @Test
  void 총액이_음수이면_에러가_발생한다() {
    // given
    long amount = -10000;

    // when & then
    Assertions.assertThrows( IllegalArgumentException.class, () -> {
      Person person = Person.of(amount);
    });
  }

  @Test
  void makeLottoNumber_작동한다() {
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
}
