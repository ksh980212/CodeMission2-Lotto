package view;

import dto.LottoResultDto;

public class OutputView {

  public static void showLottoStatus(LottoResultDto lottoResultDto) {
    lottoResultDto.showStatus();
  }
}
