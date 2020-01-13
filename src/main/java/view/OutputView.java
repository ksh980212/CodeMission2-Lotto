package view;

import dto.LottoPrizeDto;
import dto.LottoResultDto;

public class OutputView {

  /** 보유 로또 현황 View */
  public static void showLottoStatus(LottoResultDto lottoResultDto) {
    lottoResultDto.showStatus();
  }

  /** 로또 통계 & 수익률 View */
  public static void showLottoPrizeStatus(LottoPrizeDto lottoPrizeDto) {
    lottoPrizeDto.showPrizeStatus();
    lottoPrizeDto.showYieldStatus();
  }
}
