package domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  // COMMENT 로또 타입이 있는 이유가 있나요?
  // 수동 자동을 구분할 필요가 있는지 궁금하네요
  // 이렇게 되면 수동v1 자동v2 수동v3 이런식으로 다른 생성 전략이 생길때마다
  // LottoType 의 enum 이 커질 텐데 OOP와 상충되는 듯 하네요
  // 만약 구분해야 한다면 지울 필요는 없을 것 같아요~
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
    if(numbers.contains(bonusNumber)) {
      return LottoPrize.upgradeIfBonusConditionMatch(prize);
    }
    return prize;
  }

  // COMMENT stream() 이후 '.' 마다 줄바꿈... (저번에도 한 번 말씀드렸던 것 같은데 ㅠㅠ)
  // method reference 좋고요~
  private long checkMatchedCount(List<Integer> lastWinningNumbers) {
    return numbers.stream().filter(lastWinningNumbers::contains).count();
  }

  /** 로또 생성자 validate */
  private void validateLottoNumbersSizeAndRange(List<Integer> numbers) {
    validateLottoNumbersSize(numbers);
    validateNumbersRange(numbers);
    validateDuplicateNumbers(numbers);
  }

  private void validateLottoNumbersSize(List<Integer> numbers) {
    if(numbers.size() != 6) {
      throw new IllegalArgumentException("Lotto numbers size should be 6");
    }
  }

  // COMMENT 여기는 for ( 이렇게 하셨네요
  private void validateNumbersRange(List<Integer> numbers) {
    for (Integer number : numbers) {
      validateNumberRange(number);
    }
  }

  private void validateDuplicateNumbers(List<Integer> numbers) {
    Set<Integer> set = new HashSet<>(numbers);
    if(set.size() != numbers.size()) {
      throw new IllegalArgumentException("Duplicate in Lotto numbers");
    }
  }

  private void validateNumberRange(int number) {
    if( number > LottoConstant.LOTTO_MAX_NUMBER || number < LottoConstant.LOTTO_MIN_NUMBER ) {
      throw new IllegalArgumentException("Lotto numbers should be 1 ~ 45");
    }
  }

  // COMMENT 지난 당첨 번호 validate 이라고 주석에 써져 있는데 로직상 지난 당첨 번호는 아닌 것 같아요
  // 여기 아래 메소드 모두 없어도 되지 않나요? 여기 validation 로직은 왜 존재하나요?
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
    if( number > LottoConstant.LOTTO_MAX_NUMBER || number < LottoConstant.LOTTO_MIN_NUMBER ) {
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
