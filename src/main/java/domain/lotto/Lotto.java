package domain.lotto;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;
  private LottoPrize prize;

  private Lotto(List<Integer> numbers) {
    validateLottoNumbersSizeAndRange(numbers);
    this.numbers = numbers;
    this.prize = LottoPrize.DEFAULT;
  }

  public static Lotto of(List<Integer> numbers) {
    return new Lotto(numbers);
  }

  /** 로또 당첨 확인 */
  public void check(List<Integer> lastWinningNumbers) {
    validateWinningNumbersSizeAndRange(lastWinningNumbers);
    this.prize = LottoPrize.of(checkMatchedCount(lastWinningNumbers));
  }

  /** 로또 보너스 당첨 확인 */
  public void checkBonus(int bonusNumber) {
    if(numbers.contains(bonusNumber)){
      this.prize = LottoPrize.upgradeIfBonusConditionMatch(prize);
    }
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
    for(int i = 0, end= numbers.size() ; i < end ; i++) {
      validateNumberRange(numbers.get(i));
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
    for(int i = 0, end= lastWinningNumbers.size() ; i < end ; i++) {
      validateWinningNumberRange(lastWinningNumbers.get(i));
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
