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

  static {
    for(LottoPrize lottoPrize : LottoPrize.values()) {
      cachedLottoPrize.put(lottoPrize.matchedCount, lottoPrize);
    }
  }

  public static LottoPrize of(long matchedCount) {
    return cachedLottoPrize.getOrDefault(matchedCount, DEFAULT);
  }

  public static LottoPrize upgradeIfBonusConditionMatch(LottoPrize prize) {
    if(prize == LottoPrize.THIRD) {
      prize = LottoPrize.SECOND;
    }
    return prize;
  }

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
