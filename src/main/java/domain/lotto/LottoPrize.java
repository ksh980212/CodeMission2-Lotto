package domain.lotto;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

  FIRST(6, 2_000_000_000, true),
  SECOND(5, 15_000_000, true),
  THIRD(4, 50_000, true),
  FOURTH(3, 5_000, true),
  FIFTH(2, 0, false),
  SIXTH(1, 0, false),
  NONE(0, 0, false),
  DEFAULT(-1, 0, false);

  private final long matchedCount;
  private final long prizeAmount;
  private final boolean isDisplayed;

  LottoPrize(long matchedCount, long prizeAmount, boolean isDisplayed) {
    this.matchedCount = matchedCount;
    this.prizeAmount = prizeAmount;
    this.isDisplayed = isDisplayed;
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
}
