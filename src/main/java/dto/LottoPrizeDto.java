package dto;

import domain.lotto.LottoCreator;
import domain.lotto.LottoPrize;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoPrizeDto {

  private List<LottoPrize> lottoPrizeList;

  private LottoPrizeDto(List<LottoPrize> lottoPrizeList) {
    this.lottoPrizeList = lottoPrizeList;
  }

  public static LottoPrizeDto of(List<LottoPrize> lottoPrizeList) {
    return new LottoPrizeDto(lottoPrizeList);
  }

  public void showPrizeStatus() {
    System.out.println("Winning statistics");
    System.out.println("-------------------");

    for(LottoPrize prize : LottoPrize.values()) {
      filterIsDisplayed(prize);
    }
  }

  public void showYieldStatus() {
    long earnedMoney = 0;
    for(LottoPrize prize : LottoPrize.values()) {
      earnedMoney += filterYield(prize);
    }
    BigDecimal investAmount = new BigDecimal(lottoPrizeList.size() * LottoCreator.LOTTO_PRICE);
    System.out.println(String.format("Total Yield : %f", new BigDecimal(earnedMoney).divide(investAmount, 2, RoundingMode.HALF_UP)));
  }

  private void filterIsDisplayed(LottoPrize prize) {
    if(prize.isDisplayed()) {
      filterBonusMatched(prize);
    }
  }

  private void filterBonusMatched(LottoPrize prize) {
    if(prize.isBonusMatched()) {
      System.out.println(String.format("%d correct  + bonus Matched (%d amount) %d count",
          prize.getMatchedCount(), prize.getPrizeAmount(), lottoPrizeList.stream().filter(x -> x.getMatchedCount() == prize.getMatchedCount()).filter(LottoPrize::isBonusMatched).count()));
      return;
    }
      System.out.println(String.format("%d correct (%d amount) %d count",
          prize.getMatchedCount(), prize.getPrizeAmount(), lottoPrizeList.stream().filter(x -> x.getMatchedCount() == prize.getMatchedCount()).filter(x-> !x.isBonusMatched()).count()));
  }

  private long filterYield(LottoPrize prize) {
    if(prize.isDisplayed()) {
      return lottoPrizeList.stream().filter(x -> x.getMatchedCount() == prize.getMatchedCount()).filter(x -> x.isBonusMatched() == prize.isBonusMatched()).count() * prize.getPrizeAmount();
    }
    return 0;
  }
}
