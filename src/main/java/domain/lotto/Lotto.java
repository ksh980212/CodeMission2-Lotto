package domain.lotto;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;
  private final LottoType type;

  private Lotto(List<Integer> numbers, LottoType type) {
    validateLottoNumbersSizeAndRange(numbers);
    this.numbers = numbers;
    this.type = type;
  }

  public static Lotto of(List<Integer> numbers, LottoType type) {
    return new Lotto(numbers, type);
  }

  /** 로또 당첨 확인 */
  public LottoPrize check(List<Integer> lastWinningNumbers, int bonusNumber) {
    validateWinningNumbersSizeAndRange(lastWinningNumbers);
    LottoPrize prize = LottoPrize.of(checkMatchedCount(lastWinningNumbers));
    return checkBonus(bonusNumber, prize);
  }

  /** 로또 보너스 당첨 확인 */
  private LottoPrize checkBonus(int bonusNumber, LottoPrize prize) {
    if(numbers.contains(bonusNumber)){
      return LottoPrize.upgradeIfBonusConditionMatch(prize);
    }
    return prize;
  }

  private long checkMatchedCount(List<Integer> lastWinningNumbers) {
    return numbers.stream().filter(lastWinningNumbers::contains).count();
  }

  /** 로또 생성자 validate */
  private void validateLottoNumbersSizeAndRange(List<Integer> numbers) {
    validateLottoNumbersSize(numbers);
    validateNumbersRange(numbers);
  }

  private void validateLottoNumbersSize(List<Integer> numbers) {
    if(numbers.size() != 6) {
      throw new IllegalArgumentException("Lotto numbers size should be 6");
    }
  }

  private void validateNumbersRange(List<Integer> numbers) {
    for (Integer number : numbers) {
      validateNumberRange(number);
    }
  }

  private void validateNumberRange(int number) {
    if( number > LottoCreator.LOTTO_MAX_NUMBER || number < LottoCreator.LOTTO_MIN_NUMBER ) {
      throw new IllegalArgumentException("Lotto numbers should be 1 ~ 45");
    }
  }

  /** 지난 당첨 번호 validate */
  private void validateWinningNumbersSizeAndRange(List<Integer> lastWinningNumbers) {
    validateWinningNumbersSize(lastWinningNumbers);
    validateWinningNumbersRange(lastWinningNumbers);
  }

  private void validateWinningNumbersSize(List<Integer> lastWinningNumbers) {
    if(lastWinningNumbers.size() != 6) {
      throw new IllegalArgumentException("Lotto Winning numbers size should be 6");
    }
  }

  private void validateWinningNumbersRange(List<Integer> lastWinningNumbers) {
    for (Integer lastWinningNumber : lastWinningNumbers) {
      validateWinningNumberRange(lastWinningNumber);
    }
  }

  private void validateWinningNumberRange(int number) {
    if( number > LottoCreator.LOTTO_MAX_NUMBER || number < LottoCreator.LOTTO_MIN_NUMBER ) {
      throw new IllegalArgumentException("Lotto Winning numbers should be 1 ~ 45");
    }
  }

  /** Getter */
  public List<Integer> getNumbers() {
    return numbers;
  }

  public int getSize() {
    return numbers.size();
  }

  public LottoType getType() {
    return type;
  }

  /** toString() */
  public String toString() {
    return numbers.toString();
  }

}
