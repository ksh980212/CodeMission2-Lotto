package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoPrizeTest {

  @Test
  void 여섯개를_맞추면_1등이_된다() {
    //given
    long matchedCount = 6;

    //when
    LottoPrize prize = LottoPrize.of(matchedCount);

    //then
    assertThat(prize).isEqualTo(LottoPrize.FIRST);
  }

  @Test
  void 하나도_맞추지못하면_NONE_이된다() {
    //given
    long matchedCount = 0;

    //when
    LottoPrize prize = LottoPrize.of(matchedCount);

    //then
    assertThat(prize).isEqualTo(LottoPrize.NONE);
  }

  @Test
  void 다섯개를_맞추면_기본으로_3등이된다() {
    //given
    long matchedCount= 5;

    //when
    LottoPrize prize = LottoPrize.of(matchedCount);

    //then
    assertThat(prize).isEqualTo(LottoPrize.THIRD);
  }
}
