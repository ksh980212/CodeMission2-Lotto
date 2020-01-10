package domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  void 로또_초기화시_로또수가_여섯개가_아니면_에러가_발생한다() {
    //given
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Lotto.of(numbers);
    });
  }

  @Test
  void 지난당첨_로또수가_여섯개가_아니면_에러가_발생한다() {
    //given
    List<Integer> lastWinningNumbers =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Lotto lotto = Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      lotto.check(lastWinningNumbers);
    });
  }
}
