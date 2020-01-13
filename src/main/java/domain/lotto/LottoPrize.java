package domain.lotto;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

  FIRST(6, 2_000_000_000, true, false),
  SECOND(5, 30_000_000, true, true),
  THIRD(5, 1_500_000, true, false),
  FOURTH(4, 50_000, true, false),
  FIFTH(3, 5_000, true, false),
  SIXTH(2, 0, false, false),
  SEVEN(1, 0, false, false),
  NONE(0, 0, false, false),
  DEFAULT(-1, 0, false, false);

  // COMMENT 저번에 필드 2개 이하로 줄이기 말씀드렸던 것 같은데 아쉽네요 ㅠㅠ
  //  다음에 도전해보시죠!
  private final long matchedCount;
  private final long prizeAmount;
  private final boolean isDisplayed;
  private final boolean isBonusMatched;

  LottoPrize(long matchedCount, long prizeAmount, boolean isDisplayed, boolean isBonusMatched) {
    this.matchedCount = matchedCount;
    this.prizeAmount = prizeAmount;
    this.isDisplayed = isDisplayed;
    this.isBonusMatched = isBonusMatched;
  }

  private final static Map<Long, LottoPrize> cachedLottoPrize = new HashMap<>();

  // COMMENT 일반적인 컨벤션으로는 if ( / for ( 처럼 if와 for 뒤에 공백 하나를 주게 됩니다
  static {
    for(LottoPrize lottoPrize : LottoPrize.values()) {
      cachedLottoPrize.put(lottoPrize.matchedCount, lottoPrize);
    }
  }

  public static LottoPrize of(long matchedCount) {
    return cachedLottoPrize.getOrDefault(matchedCount, DEFAULT);
  }

  // COMMENT 구역을 나눈 건 좋습니다!
  // 하지만 API 라는 표현은 적절하지 않네요! message 등으로 표현하는게 좋을 듯 합니다
  // 그리고 제 습관이긴 한데 getter / setter 등 비즈니스와 관계없는 로직은 다 위로 뺍니다
  // 상수, 변수, 생성자 관련 메소드, 게터 / 세터, 다음에 주요 로직들이 올 수 있도록요
  /** API */

  public static LottoPrize upgradeIfBonusConditionMatch(LottoPrize prize) {
    if(prize == LottoPrize.THIRD) {
      prize = LottoPrize.SECOND;
    }
    return prize;
  }

  /** Getter */

  public boolean isDisplayed() {
    return isDisplayed;
  }

  public long getMatchedCount() {
    return matchedCount;
  }

  public long getPrizeAmount() {
    return prizeAmount;
  }

  public boolean isBonusMatched() {
    return isBonusMatched;
  }

}
