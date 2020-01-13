package domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// COMMENT 테스트 코드는 모두 살펴봤는데 정말 많이 늘었네요!!
// 코드 컨벤션 및 커버리지 외에 딱히 말씀드릴게 없어요 잘하셨습니다~
class LottoTest {

  @Test
  void 로또_초기화시_로또수가_여섯개가_아니면_에러가_발생한다() {
    //given
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Lotto.of(numbers, LottoType.MANUAL);
    });
  }

  @Test
  void 지난당첨_로또수가_여섯개가_아니면_에러가_발생한다() {
    //given
    List<Integer> lastWinningNumbers =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Lotto lotto = Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoType.MANUAL);

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      lotto.check(lastWinningNumbers, 10);
    });
  }

  @Test
  void 지난당첨_로또에_범위밖의_수가_입력되면_에러가_발생한다() {
    //given
    List<Integer> lastWinningNumbers =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 50)); // 50:  범위내
    Lotto lotto = Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoType.MANUAL);

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      lotto.check(lastWinningNumbers, 10);
    });
  }

  @Test
  void 로또번호가_중복되면_에러가_발생한다() {
    //given
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));

    //when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Lotto.of(numbers, LottoType.MANUAL);
    });
  }
}
