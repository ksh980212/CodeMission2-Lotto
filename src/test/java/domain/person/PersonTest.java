package domain.person;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.org.apache.bcel.internal.generic.ILOAD;
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
}
