package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.creatorPolicy.AutoCreatorPolicy;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class AutoCreatorPolicyTest {

  @Test
  void 자동으로_로또번호가_중복없이_생성된다() {
    //given
    AutoCreatorPolicy autoCreatorPolicy = AutoCreatorPolicy.of();

    //when & then
    Lotto lotto = autoCreatorPolicy.generate();
    Set<Integer> set = new HashSet<>(lotto.getNumbers());
    assertThat(set.size()).isEqualTo(lotto.getNumbers().size());
  }

  @Test
  void 자동으로_로또번호가_6개_생성된다() {
    //given
    AutoCreatorPolicy autoCreatorPolicy = AutoCreatorPolicy.of();

    //when
    Lotto lotto = autoCreatorPolicy.generate();

    //then
    assertThat(lotto.getSize()).isEqualTo(6);
  }
}
