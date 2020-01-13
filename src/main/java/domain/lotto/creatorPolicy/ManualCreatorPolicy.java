package domain.lotto.creatorPolicy;

import domain.lotto.Lotto;
import domain.lotto.LottoType;
import java.util.List;

public class ManualCreatorPolicy implements LottoCreatorPolicy{

  private List<Integer> lotteries;

  private ManualCreatorPolicy(List<Integer> numbers) {
    this.lotteries = numbers;
  }

  public static ManualCreatorPolicy of(List<Integer> numbers) {
    return new ManualCreatorPolicy(numbers);
  }

  @Override
  public Lotto generate() {
    return Lotto.of(lotteries, LottoType.MANUAL);
  }
}
