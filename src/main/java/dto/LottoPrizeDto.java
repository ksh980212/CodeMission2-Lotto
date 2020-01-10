package dto;

import domain.lotto.Lotto;
import domain.lotto.LottoCreator;
import domain.lotto.LottoPrize;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoPrizeDto {

  private List<LottoPrize> lottoPrizeList;

  private LottoPrizeDto(List<Lotto> lottoList) {
    lottoPrizeList = new ArrayList<>();
    for(int i = 0, end= lottoList.size() ; i < end ; i++ ) {
      lottoPrizeList.add(lottoList.get(i).getPrize());
    }
  }

  public static LottoPrizeDto of(List<Lotto> lottoList) {
    return new LottoPrizeDto(lottoList);
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
    int investAmount =  lottoPrizeList.size() * LottoCreator.LOTTO_PRICE;
    BigDecimal calculate = new BigDecimal(earnedMoney/ investAmount);
    System.out.println(String.format("Total Yield : %f", calculate.setScale(2, RoundingMode.CEILING)));
  }
  private void filterIsDisplayed(LottoPrize prize) {
    if(prize.isDisplayed()) {
      System.out.println(String.format("%d correct (%d amount) %d count",
          prize.getMatchedCount(), prize.getPrizeAmount(),
          lottoPrizeList.stream().filter(x -> x.getMatchedCount() == prize.getMatchedCount()).count()));
    }
  }

  private long filterYield(LottoPrize prize) {
    if(prize.isDisplayed()) {
      return lottoPrizeList.stream().filter(x -> x.getMatchedCount() == prize.getMatchedCount()).count() * prize.getPrizeAmount();
    }
    return 0;
  }
}
