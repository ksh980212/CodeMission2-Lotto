package view;

import dto.LottoPrizeDto;
import dto.LottoResultDto;

public class OutputView {

  public static void showLottoStatus(LottoResultDto lottoResultDto) {
    lottoResultDto.showStatus();
  }

  public static void showLottoPrizeStatus(LottoPrizeDto lottoPrizeDto) {
    lottoPrizeDto.showPrizeStatus();
  }
}
