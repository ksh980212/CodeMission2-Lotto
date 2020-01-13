package domain.lotto.creatorPolicy;

import domain.lotto.Lotto;
import domain.lotto.LottoCreator;
import domain.lotto.LottoType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoCreatorPolicy implements LottoCreatorPolicy{

  private List<Integer> lotteries;

  private AutoCreatorPolicy() {
    lotteries = new ArrayList<>(makeLottoNumber());
  }

  public static AutoCreatorPolicy of() {
    return new AutoCreatorPolicy();
  }

  @Override
  public Lotto generate() {
    Collections.shuffle(lotteries);
    return Lotto.of(lotteries.subList(0, 6), LottoType.AUTO);
  }

  private List<Integer> makeLottoNumber() {
    List<Integer> numbers= new ArrayList<>();
    for (int i = LottoCreator.LOTTO_MIN_NUMBER; i <= LottoCreator.LOTTO_MAX_NUMBER; i++) {
      numbers.add(i);
    }
    return numbers;
  }
}
