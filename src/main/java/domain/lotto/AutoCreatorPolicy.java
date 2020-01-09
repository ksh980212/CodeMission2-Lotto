package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoCreatorPolicy implements LottoCreatorPolicy{

  private List<Integer> lotteries;

  private AutoCreatorPolicy() {
    lotteries = new ArrayList<>(makeLottoNumber(LottoCreator.LOTTO_MIN_NUMBER, LottoCreator.LOTTO_MAX_NUMBER));
  }

  public static AutoCreatorPolicy of() {
    return new AutoCreatorPolicy();
  }

  @Override
  public Lotto generate() {
    Collections.shuffle(lotteries);
    return Lotto.of(lotteries);
  }

  private List<Integer> makeLottoNumber(int min, int max) {
    List<Integer> numbers= new ArrayList<>();
    for(int i = min; i <= max; i++) {
      numbers.add(i);
    }
    return numbers;
  }
}
