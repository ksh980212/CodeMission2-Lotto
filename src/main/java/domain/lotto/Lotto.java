package domain.lotto;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;
  private LottoPrize prize;

  private Lotto(List<Integer> numbers) {
    validateLottoNumbersSize(numbers);
    this.numbers = numbers;
    this.prize = LottoPrize.DEFAULT;
  }

  public static Lotto of(List<Integer> numbers) {
    return new Lotto(numbers);
  }

  public void check(List<Integer> lastWinningNumbers) {
    validateWinningNumbersSize(lastWinningNumbers);
    this.prize = LottoPrize.of(checkMatchedCount(lastWinningNumbers));
  }

  public void checkBonus(int bonusNumber) {
    if(numbers.contains(bonusNumber)){
      this.prize = LottoPrize.upgradeIfBonusConditionMatch(prize);
    }
  }

  private long checkMatchedCount(List<Integer> lastWinningNumbers) {
    return numbers.stream().filter(lastWinningNumbers::contains).count();
  }

  private void validateLottoNumbersSize(List<Integer> numbers) {
    if(numbers.size() != 6) {
      throw new IllegalArgumentException("Lotto numbers size should be 6");
    }
  }

  private void validateWinningNumbersSize(List<Integer> lastWinningNumbers) {
    if(lastWinningNumbers.size() != 6) {
      throw new IllegalArgumentException("Lotto Winning numbers size should be 6");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public String toString() {
    return numbers.toString();
  }

  public int getSize() {
    return numbers.size();
  }

  public LottoPrize getPrize() {
    return prize;
  }
}
