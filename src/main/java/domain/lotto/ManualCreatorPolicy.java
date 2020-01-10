package domain.lotto;

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
    return Lotto.of(lotteries);
  }
}
